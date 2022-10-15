package com.bootcamp.comex.entrypoints;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDAO extends JpaRepository<Category, Long> {
}
