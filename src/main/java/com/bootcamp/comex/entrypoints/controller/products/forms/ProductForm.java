package com.bootcamp.comex.entrypoints.controller.products.forms;

import com.bootcamp.comex.entity.category.Category;
import com.bootcamp.comex.entity.product.Dimensions;
import com.bootcamp.comex.entity.product.Product;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductForm {

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

    public Product toProduct(){
        return Product.builder()
                .name(this.name)
                .category(Category.builder().id(this.category.getId()).build())
                .description(this.description)
                .unitPrice(this.unitPrice)
                .quantity(this.quantity)
                .dimensions(Dimensions.builder()
                        .height(this.dimensions.getHeight())
                        .length(this.dimensions.getLength())
                        .weight(this.dimensions.getWeight())
                        .width(this.dimensions.getWidth())
                        .build())
                .build();

    }

}
