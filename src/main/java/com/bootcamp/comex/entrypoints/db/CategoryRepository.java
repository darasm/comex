package com.bootcamp.comex.entrypoints.db;

import com.bootcamp.comex.entity.Category;
import com.bootcamp.comex.entity.ICategoryRepository;
import com.bootcamp.comex.enums.CategoryStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryRepository implements ICategoryRepository {
    private final ICategoryDAO categoryDAO;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Category> listAllCategories() {
        List<CategoryEntity> categories = categoryDAO.findAll();
        return categories.stream().map(m -> modelMapper.map(m, Category.class)).toList();
    }

    @Override
    public Category registerNewCategory(Category category) {
        CategoryEntity categoryEntityInput = modelMapper.map(category, CategoryEntity.class);
        CategoryEntity categoryEntity = categoryDAO.save(categoryEntityInput);
        return modelMapper.map(categoryEntity, Category.class);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);
        categoryDAO.deleteById(categoryEntity.getId());

    }

    @Override
    public Category searchCategory(Long id) {
        CategoryEntity categoryEntity = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);
        return modelMapper.map(categoryEntity, Category.class);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        CategoryEntity categoryEntity = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);
        categoryEntity.setName(category.getName());
        return modelMapper.map(categoryEntity, Category.class);
    }

    @Override
    public Category updateCategoryStatus(Long id) {
        CategoryEntity categoryEntity = categoryDAO.findById(id)
                .orElseThrow(RuntimeException::new);

        if (categoryEntity.getStatus().equals(CategoryStatus.ACTIVE)){
            categoryEntity.setStatus(CategoryStatus.INACTIVE);
        } else {
            categoryEntity.setStatus(CategoryStatus.ACTIVE);
        }
        categoryDAO.save(categoryEntity);

        return modelMapper.map(categoryEntity, Category.class);
    }
}
