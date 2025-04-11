package com.mangopuree.nvrcamera.service;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NvrCameraService {

    private final NvrCameraMapper nvrCameraMapper;

    @Transactional
    public void syncCameras(List<NvrCameraDto> cameras) {

    }
}
