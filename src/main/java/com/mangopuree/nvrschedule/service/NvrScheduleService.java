package com.mangopuree.nvrschedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NvrScheduleService {

    private final NvrScheduleMapper nvrScheduleMapper;
}
