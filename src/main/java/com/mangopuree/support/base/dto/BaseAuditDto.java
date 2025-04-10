package com.mangopuree.support.base.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BaseAuditDto {

    private Long regId;
    private Long updId;
}
