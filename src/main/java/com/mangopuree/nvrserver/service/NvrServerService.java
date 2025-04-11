package com.mangopuree.nvrserver.service;

import com.mangopuree.nvrserver.dto.NvrServerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NvrServerService {

    private final NvrServerMapper nvrServerMapper;

    public NvrServerDto getNvrServer() {
        return nvrServerMapper.getNvrServer();
    }
}
