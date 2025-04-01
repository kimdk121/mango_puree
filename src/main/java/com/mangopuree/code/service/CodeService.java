package com.mangopuree.code.service;

import com.mangopuree.code.dto.CodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeMapper codeMapper;

    /**
     * 코드목록 조회
     * @param codeGroupId
     * @return List<CodeDto>
     */
    public List<CodeDto> getCodeListByCodeGroupId(String codeGroupId) {
        return codeMapper.getCodeListByCodeGroupId(codeGroupId);
    }
}
