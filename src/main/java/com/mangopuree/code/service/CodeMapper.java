package com.mangopuree.code.service;

import com.mangopuree.code.dto.CodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeMapper {

    /**
     * 코드 조회
     * @param CodeGroupId
     * @return List<CodeDto>
     */
    List<CodeDto> getCodeListByCodeGroupId(String CodeGroupId);
}
