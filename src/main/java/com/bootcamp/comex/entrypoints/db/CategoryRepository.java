package com.bootcamp.comex.entrypoints.db;

import com.bootcamp.comex.entity.CategoryEntity;
import com.bootcamp.comex.entity.ICategoryRepository;
import com.bootcamp.comex.enums.CategoryStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryDAO categoryDAO;

    private final ModelMapper modelMapper;

    @Override
    public List<CategoryEntity> listAllCategories() {
        List<Category> categories = categoryDAO.findAll();
        return categories.stream().map(m -> modelMapper.map(m, CategoryEntity.class)).toList();
    }

    @Override
    public CategoryEntity registerNewCategory(CategoryEntity categoryEntity) {
        Category category = categoryDAO.save(modelMapper.map(categoryEntity, Category.class));
        return modelMapper.map(category, CategoryEntity.class);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);
        categoryDAO.deleteById(category.getId());

    }

    @Override
    public CategoryEntity searchCategory(Long id) {
        Category category = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);
        return modelMapper.map(category, CategoryEntity.class);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
        Category category = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);
        category.setName(categoryEntity.getName());
        return modelMapper.map(category, CategoryEntity.class);
    }

    @Override
    public CategoryEntity updateCategoryStatus(Long id) {
        Category category = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);

        if (category.getStatus().equals(CategoryStatus.ACTIVE)){
            category.setStatus(CategoryStatus.INACTIVE);
        } else {
            category.setStatus(CategoryStatus.ACTIVE);
        }
        return modelMapper.map(category, CategoryEntity.class);
    }
}
