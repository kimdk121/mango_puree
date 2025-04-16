package com.mangopuree.nvrcamera.service;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrCameraMapper {

    List<NvrCameraDto> findAll();

    List<NvrCameraDto> findActiveCameras();

    NvrCameraDto findByCameraId(String cameraId);

    int insert(NvrCameraDto nvrCameraDto);

    int update(NvrCameraDto nvrCameraDto);

    int delete(String cameraId);
}
