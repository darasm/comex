package com.bootcamp.comex.entity.product;

import com.bootcamp.comex.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {

    private Long productCode;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int quantity;
    private Category category;
    private Dimensions dimensions;
}
