package com.bootcamp.comex.entity;

import java.util.List;

public interface ICategoryRepository {

    List<CategoryEntity> listAllCategories();

    CategoryEntity registerNewCategory(CategoryEntity categoryEntity);

    void deleteCategory(Long id);

    CategoryEntity searchCategory(Long id);

    CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity);

    CategoryEntity updateCategoryStatus(Long id);
}
