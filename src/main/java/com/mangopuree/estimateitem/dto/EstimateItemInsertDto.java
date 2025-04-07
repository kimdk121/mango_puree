package com.mangopuree.estimateitem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.BaseAuditDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EstimateItemInsertDto extends BaseAuditDto {

    private String estimateId;
    private String itemId;
    private String itemName;
    private String unitCd;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private Integer price;
    private Integer quantity;
    private Integer supplyAmount;
    private Integer vatAmount;
    private Integer totalAmount;
}
