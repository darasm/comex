package com.bootcamp.comex.entrypoints.controller.products.forms;

import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateProductForm {

    @NotNull
    @NotEmpty
    @Size(min = 2)
    private String name;

    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal unitPrice;

    @Min(value = 0)
    private int quantity;

    private CategoryForm category;

    private DimensionsForm dimensions;

}
