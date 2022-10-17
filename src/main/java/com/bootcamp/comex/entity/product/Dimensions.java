package com.bootcamp.comex.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dimensions {

    private BigDecimal weight;
    private int length;
    private int height;
    private int width;
}
