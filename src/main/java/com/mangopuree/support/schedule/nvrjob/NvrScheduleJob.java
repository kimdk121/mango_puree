package com.mangopuree.support.schedule.nvrjob;

import com.mangopuree.movie.dto.MovieDownloadDto;
import com.mangopuree.movie.dto.MovieInsertDto;
import com.mangopuree.movie.service.MovieService;
import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.nvrschedule.dto.NvrScheduleDto;
import com.mangopuree.nvrschedule.service.NvrScheduleService;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryInsertDto;
import com.mangopuree.nvrschedulehistory.service.NvrScheduleHistoryService;
import com.mangopuree.nvrserver.dto.NvrServerDto;
import com.mangopuree.nvrserver.service.NvrServerService;
import com.mangopuree.support.base.BaseConstant;
import com.mangopuree.support.base.dto.ExternalRequestDto;
import com.mangopuree.support.base.dto.ExternalResponseDto;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import com.mangopuree.support.hdfs.HdfsUtils;
import com.mangopuree.support.message.MessageUtil;
import com.mangopuree.support.resttemplate.RestTemplateHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class NvrScheduleJob {

    private final NvrServerService nvrServerService;
    private final NvrScheduleService nvrScheduleService;
    private final NvrScheduleHistoryService nvrScheduleHistoryService;
    private final RestTemplateHelper restTemplateHelper;
    private final HdfsUtils hdfsUtils;
    private final MovieService movieService;
    private final MessageUtil messageUtil;

    public static final String LOG_NAME = "[NvrScheduleJob]";

    @Transactional
    public void movieDownload() {

        log.info("{} Nvr 스케쥴 기반 영상 다운로드 작업 시작", LOG_NAME);
        // 다운로드 리스트 조회
        List<NvrScheduleDto> downloadScheduleList = nvrScheduleService.findScheduleToDownload();
        if (downloadScheduleList.size() < 1) {
            log.info("{} 다운로드할 스케쥴이 없습니다.", LOG_NAME);
            return;
        }
        log.info("{} {}건의 다운로드할 스케쥴이 확인 되었습니다.", LOG_NAME, downloadScheduleList.size());

        // API로 데이터 받음
        NvrServerDto nvrServer = nvrServerService.getNvrServer();
        String url = nvrServer.getServerAddress() + "/movieDownload";

        for (NvrScheduleDto nvrScheduleDto : downloadScheduleList) {
            try {
                log.info("{} 스케쥴 ID : {} 다운로드 시작", LOG_NAME, nvrScheduleDto.getScheduleId());
                ExternalResponseDto<MovieDownloadDto> response = restTemplateHelper.getWithParams(url, new ExternalRequestDto(), new ParameterizedTypeReference<ExternalResponseDto<MovieDownloadDto>>() {});

                MovieDownloadDto movieDownloadDto = response.getData().stream().findFirst().orElse(null);
                if (movieDownloadDto == null || movieDownloadDto.getMovieData().length() < 1) {
                    throw new CodeException(ErrorCode.NVR_MOVIE_NOT_EXIST);
                }
                // 하둡 저장
                String movieName = movieDownloadDto.getStartDate() + "_" + movieDownloadDto.getDuration() + "_" + movieDownloadDto.getCameraId() + "." + BaseConstant.EXTENSION_MP4;
                String savePath = BaseConstant.HADOOP_MOVIE_PATH + movieName;
                byte[] movieData = Base64.getDecoder().decode(movieDownloadDto.getMovieData());

                int fileSize = hdfsUtils.saveToHdfs(savePath, movieData);
                log.info("{} {} 영상 저장 완료", LOG_NAME, movieName);
                
                // 동영상 테이블 저장
                MovieInsertDto movieInsertDto = MovieInsertDto.builder()
                        .movieId(movieService.findNextMovieId())
                        .scheduleId(nvrScheduleDto.getScheduleId())
                        .movieName(movieName)
                        .savePath(savePath)
                        .fileSize(fileSize)
                        .build();
                movieService.insert(movieInsertDto);

                // 이력 테이블 저장
                NvrScheduleHistoryInsertDto nvrScheduleHistoryInsertDto = NvrScheduleHistoryInsertDto.builder()
                        .historyId(nvrScheduleHistoryService.findNextHistoryId())
                        .scheduleId(nvrScheduleDto.getScheduleId())
                        .movieId(movieInsertDto.getMovieId())
                        .downloadedYn(true)
                        .build();
                nvrScheduleHistoryService.insert(nvrScheduleHistoryInsertDto);
                log.info("{} 스케쥴 ID : {} 다운로드 종료", LOG_NAME, nvrScheduleDto.getScheduleId());

                // 마지막 다운로드일자 변경
                nvrScheduleService.updateLastDownloadDt(nvrScheduleDto.getScheduleId());

            } catch(CodeException e){
                log.info("{} 스케쥴 ID : {} 다운로드 실패 - {}", LOG_NAME, nvrScheduleDto.getScheduleId(), messageUtil.get(e.getMessage()));
                // 이력 테이블 저장
                NvrScheduleHistoryInsertDto nvrScheduleHistoryInsertDto = NvrScheduleHistoryInsertDto.builder()
                        .historyId(nvrScheduleHistoryService.findNextHistoryId())
                        .scheduleId(nvrScheduleDto.getScheduleId())
                        .movieId(null)
                        .downloadedYn(false)
                        .failReason(e.getMessage() != null ? messageUtil.get(e.getMessage()) : "알 수 없는 오류")
                        .build();
                nvrScheduleHistoryService.insert(nvrScheduleHistoryInsertDto);

                // 마지막 다운로드일자 변경
                nvrScheduleService.updateLastDownloadDt(nvrScheduleDto.getScheduleId());
            }
        }
        log.info("{} Nvr 스케쥴 기반 영상 다운로드 작업 종료", LOG_NAME);
    }
}
