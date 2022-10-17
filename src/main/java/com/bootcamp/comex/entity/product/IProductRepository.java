package com.bootcamp.comex.entity.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductRepository {

    Page<Product> listAllProducts(Pageable pageable);
    Product searchProductByCode(Long productCode);
    Product registerProduct(Product product);
    Product updateProduct(Long productCode, Product product);
    void deleteProduct(Long id);
}
