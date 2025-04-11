package com.mangopuree.support.schedule.nvrjob;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.nvrserver.dto.NvrServerDto;
import com.mangopuree.nvrserver.service.NvrServerService;
import com.mangopuree.support.base.dto.ExternalRequestDto;
import com.mangopuree.support.base.dto.ExternalResponseDto;
import com.mangopuree.support.resttemplate.RestTemplateHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NvrCameraJob {

    private final NvrServerService nvrServerService;
    private final NvrCameraService nvrCameraService;
    private final RestTemplateHelper restTemplateHelper;

    public void searchCameras() {

        NvrServerDto nvrServer = nvrServerService.getNvrServer();
        String url = nvrServer.getServerAddress() + "/cameras";
        ExternalResponseDto<NvrCameraDto> withParams = restTemplateHelper.getWithParams(url, new ExternalRequestDto(), new ParameterizedTypeReference<ExternalResponseDto<NvrCameraDto>>() {
        });

        List<NvrCameraDto> cameras = withParams.getData();
        nvrCameraService.syncCameras(cameras);
    }
}
