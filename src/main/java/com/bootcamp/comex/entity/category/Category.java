package com.bootcamp.comex.entity.category;

import com.bootcamp.comex.entity.product.Product;
import com.bootcamp.comex.enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    private Long id;
    private String name;
    private CategoryStatus status = CategoryStatus.ACTIVE;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        product.setCategory(this);
        this.products.add(product);
    }
}
