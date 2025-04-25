package com.mangopuree.nvrcamera.service;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrCameraMapper {

    /**
     * 전체 조회
     * @return List<NvrCameraDto>
     */
    List<NvrCameraDto> findAll();

    /**
     * 사용중인 카메라 조회
     * @return List<NvrCameraDto>
     */
    List<NvrCameraDto> findActiveCameras();

    /**
     * 카메라아이디로 조회
     * @param cameraId
     * @return NvrCameraDto
     */
    NvrCameraDto findByCameraId(String cameraId);

    /**
     * 등록
     * @param nvrCameraDto
     * @return int
     */
    int insert(NvrCameraDto nvrCameraDto);

    /**
     * 수정
     * @param nvrCameraDto
     * @return int
     */
    int update(NvrCameraDto nvrCameraDto);

    /**
     * 삭제
     * @param cameraId
     * @return int
     */
    int delete(String cameraId);
}
