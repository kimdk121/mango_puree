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

    /**
     * 전체 조회
     * @return List<NvrCameraDto>
     */
    public List<NvrCameraDto> findAll() {
        return nvrCameraMapper.findAll();
    }

    /**
     * 사용중인 카메라 조회
     * @return List<NvrCameraDto>
     */
    public List<NvrCameraDto> findActiveCameras() {
        return nvrCameraMapper.findActiveCameras();
    }

    /**
     * 카메라아이디로 조회
     * @param cameraId
     * @return NvrCameraDto
     */
    public NvrCameraDto findByCameraId(String cameraId) {
        return nvrCameraMapper.findByCameraId(cameraId);
    }

    /**
     * 등록
     * @param nvrCameraDto
     * @return int
     */
    public int insert(NvrCameraDto nvrCameraDto) {
        return nvrCameraMapper.insert(nvrCameraDto);
    }

    /**
     * 수정
     * @param nvrCameraDto
     * @return int
     */
    public int update(NvrCameraDto nvrCameraDto) {
        return nvrCameraMapper.update(nvrCameraDto);
    }

    /**
     * 삭제
     * @param cameraId
     * @return int
     */
    public int delete(String cameraId) {
        return nvrCameraMapper.delete(cameraId);
    }

    /**
     * 카메라 목록 동기화
     * @param cameras
     */
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
