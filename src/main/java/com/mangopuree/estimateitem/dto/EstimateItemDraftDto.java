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
public class EstimateItemDraftDto extends BaseAuditDto {

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

    public EstimateItemInsertDto toInsertDto(String estimateId, Long regId) {
        return EstimateItemInsertDto.builder()
                .estimateId(estimateId)
                .itemId(this.itemId)
                .itemName(this.itemName)
                .unitCd(this.unitCd)
                .dueDate(this.dueDate)
                .price(this.price)
                .quantity(this.quantity)
                .supplyAmount(this.supplyAmount)
                .vatAmount(this.vatAmount)
                .totalAmount(this.totalAmount)
                .regId(regId)
                .build();
    }

    public EstimateItemUpdateDto toUpdateDto(Long regId) {
        return EstimateItemUpdateDto.builder()
                .estimateId(this.estimateId)
                .itemId(this.itemId)
                .itemName(this.itemName)
                .unitCd(this.unitCd)
                .dueDate(this.dueDate)
                .price(this.price)
                .quantity(this.quantity)
                .supplyAmount(this.supplyAmount)
                .vatAmount(this.vatAmount)
                .totalAmount(this.totalAmount)
                .regId(regId)
                .build();
    }
}
