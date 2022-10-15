package com.bootcamp.comex.entrypoints;

import com.bootcamp.comex.entity.CategoryEntity;
import com.bootcamp.comex.entity.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryDAO categoryDAO;

    @Override
    public List<CategoryEntity> listAllCategories() {
        return null;
    }

    @Override
    public CategoryEntity registerNewCategory(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public CategoryEntity searchCategory(Long id) {
        return null;
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public CategoryEntity updateCategoryStatus(Long id) {
        return null;
    }
}
