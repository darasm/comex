package com.bootcamp.comex.entrypoints.controller.products.dto;

import com.bootcamp.comex.entity.product.Dimensions;
import com.bootcamp.comex.entrypoints.controller.category.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productCode;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int quantity;
    private CategoryDto category;
    private Dimensions dimensions;


}
