package com.bootcamp.comex.entrypoints.controller.products.dto;


import com.bootcamp.comex.enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDto {

    private Long id;
    private String name;
    private CategoryStatus status = CategoryStatus.ACTIVE;

}
