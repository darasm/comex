package com.bootcamp.comex.entrypoints.db.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DimensionsEntity {

    private BigDecimal weight;
    private int length;
    private int height;
    private int width;

}
