package com.bootcamp.comex.entrypoints.db.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDAO extends JpaRepository<CategoryEntity, Long> {
}
