package com.bootcamp.comex.entrypoints.db.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductsDAO extends JpaRepository<ProductEntity, Long> {
}
