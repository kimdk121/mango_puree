package com.mangopuree.nvrcamera.service;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NvrCameraService {

    private final NvrCameraMapper nvrCameraMapper;

    public List<NvrCameraDto> findAll() {
        return nvrCameraMapper.findAll();
    }

    public List<NvrCameraDto> findActiveCameras() {
        return nvrCameraMapper.findActiveCameras();
    }

    public NvrCameraDto findByCameraId(String cameraId) {
        return nvrCameraMapper.findByCameraId(cameraId);
    }

    public int insert(NvrCameraDto nvrCameraDto) {
        return nvrCameraMapper.insert(nvrCameraDto);
    }

    public int update(NvrCameraDto nvrCameraDto) {
        return nvrCameraMapper.update(nvrCameraDto);
    }

    public int delete(String cameraId) {
        return nvrCameraMapper.delete(cameraId);
    }

    @Transactional
    public void syncCameras(List<NvrCameraDto> cameras) {
        List<String> dbCameraIds = findAll().stream().map(nvrCameraDto -> nvrCameraDto.getCameraId()).toList();

        for (NvrCameraDto camera : cameras) {
            if(dbCameraIds.contains(camera.getCameraId())) {
                update(camera);
            } else {
                insert(camera);
            }
        }
        for (String dbCameraId : dbCameraIds) {
            if (cameras.stream().noneMatch(nvrCameraDto -> nvrCameraDto.getCameraId().equals(dbCameraId))) {
                delete(dbCameraId);
            }
        }

    }
}
