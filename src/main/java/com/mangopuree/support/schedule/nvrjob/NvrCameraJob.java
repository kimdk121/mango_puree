package com.mangopuree.support.schedule.nvrjob;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.nvrserver.dto.NvrServerDto;
import com.mangopuree.nvrserver.service.NvrServerService;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.resttemplate.dto.ExternalRequestDto;
import com.mangopuree.support.resttemplate.dto.ExternalResponseDto;
import com.mangopuree.support.resttemplate.RestTemplateHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class NvrCameraJob {

    private final NvrServerService nvrServerService;
    private final NvrCameraService nvrCameraService;
    private final RestTemplateHelper restTemplateHelper;

    public static final String LOG_NAME = "[NvrCameraJob]";

    public void searchCameras() {

        try {
            log.info("{} Nvr 카메라 등록 작업 시작", LOG_NAME);
            NvrServerDto nvrServer = nvrServerService.getNvrServer();
            String url = nvrServer.getServerAddress() + "/cameras";
            ExternalResponseDto<NvrCameraDto> response = restTemplateHelper.getWithParams(url, new ExternalRequestDto(), new ParameterizedTypeReference<ExternalResponseDto<NvrCameraDto>>() {});

            List<NvrCameraDto> cameras = response.getData();
            log.info("{} {}개의 카메라가 확인 되었습니다.", LOG_NAME, cameras.size());

            nvrCameraService.syncCameras(cameras);
            log.info("{} Nvr 카메라 등록 작업 완료", LOG_NAME);
        } catch (CodeException e) {
            log.error("{} Nvr 카메라 등록 작업 실패", LOG_NAME);
        }
    }
}
