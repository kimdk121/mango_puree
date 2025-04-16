package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstimateGridDto extends ResponseGridDto {

    private String businessName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateDate;
    private String estimateId;
    private String estimateStatusCd;
    private String estimateStatusCdName;
    private String vendorName;
    private String managerName;
    private String validDateCdName;
    private String itemId;
    private String itemName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private Integer price;
    private Integer quantity;
    private Integer supplyAmount;
    private Integer vatAmount;
    private Integer totalAmount;
    private String regUsername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
