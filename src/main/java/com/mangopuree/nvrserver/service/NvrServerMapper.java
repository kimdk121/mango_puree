package com.mangopuree.nvrserver.service;

import com.mangopuree.nvrserver.dto.NvrServerDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NvrServerMapper {

    NvrServerDto getNvrServer();
}
