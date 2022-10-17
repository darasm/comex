package com.bootcamp.comex.entity.category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> listAllCategories();
    Category registerNewCategory(Category category);
    void deleteCategory(Long id);
    Category searchCategory(Long id);
    Category updateCategory(Long id, Category category);
    Category updateCategoryStatus(Long id);
}
