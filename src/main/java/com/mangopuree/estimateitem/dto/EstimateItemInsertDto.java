package com.mangopuree.estimateitem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.BaseAuditDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotNull
    @Min(value = 1)
    private Integer price;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    private Integer supplyAmount;
    private Integer vatAmount;
    private Integer totalAmount;
}
