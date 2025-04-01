package com.mangopuree.estimate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstimateService {

    private final EstimateMapper estimateMapper;
}
