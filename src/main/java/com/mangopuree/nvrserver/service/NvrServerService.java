package com.mangopuree.nvrserver.service;

import com.mangopuree.nvrserver.dto.NvrServerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NvrServerService {

    private final NvrServerMapper nvrServerMapper;

    /**
     * 조회
     * @return NvrServerDto
     */
    public NvrServerDto getNvrServer() {
        return nvrServerMapper.getNvrServer();
    }
}
