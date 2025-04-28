package com.mangopuree.support.converter;

import com.mangopuree.movie.dto.MovieSearchDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleDto;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ConverterUtil {

    /**
     * NvrScheduleDto -> MovieSearchDto
     * @param nvrScheduleDto
     * @return MovieSearchDto
     */
    public static MovieSearchDto convertToMovieSearchDto(NvrScheduleDto nvrScheduleDto) {
        LocalDateTime startDate = nvrScheduleDto.getLastDownloadDt() == null
                ? LocalDateTime.now()
                : nvrScheduleDto.getLastDownloadDt().plusMinutes(nvrScheduleDto.getDuration());
        LocalDateTime endDate = startDate.plusMinutes(nvrScheduleDto.getDuration());

        return MovieSearchDto.builder()
                .cameraId(nvrScheduleDto.getCameraId())
                .startDate(startDate)
                .endDate(endDate)
                .duration(nvrScheduleDto.getDuration())
                .build();
    }

    /**
     * excelData를 pdfData로 변환
     * @param excelFile
     * @return byte[]
     */
    public static byte[] excelToPdfConverter(File excelFile) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
            Workbook workbook = new Workbook();
            workbook.loadFromFile(excelFile.getAbsolutePath());
            workbook.getConverterSetting().setSheetFitToWidth(true);

            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                workbook.setDefaultFontName("Calibri");
            } else {
                workbook.setDefaultFontName("Noto Sans CJK KR");
            }
            workbook.saveToStream(bos, FileFormat.PDF);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new CodeException(ErrorCode.EXCELTOPDF_CONVERT_FAIL);
        }
    }
}
