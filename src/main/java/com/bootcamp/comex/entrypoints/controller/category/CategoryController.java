package com.bootcamp.comex.entrypoints.controller.category;

import com.bootcamp.comex.entity.category.Category;
import com.bootcamp.comex.entity.category.ICategoryRepository;
import com.bootcamp.comex.entrypoints.controller.category.forms.CategoryForm;
import com.bootcamp.comex.entrypoints.controller.category.dto.CategoryDto;
import com.bootcamp.comex.entrypoints.controller.category.forms.UpdatedCategoryForm;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final ICategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody @Valid CategoryForm categoryForm,
                                                    UriComponentsBuilder uriComponentsBuilder){
        Category category = categoryRepository.registerNewCategory(categoryForm.changeToCategory());

        URI uri = uriComponentsBuilder.path("/api/v1/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(category, CategoryDto.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> searchCategoryById(@PathVariable Long id){
        Category category = categoryRepository.searchCategory(id);
        return ResponseEntity.ok(modelMapper.map(category,CategoryDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategoryStatus(@PathVariable Long id){
        Category updatedCategory = categoryRepository.updateCategoryStatus(id);
        return ResponseEntity.ok(modelMapper.map(updatedCategory, CategoryDto.class));
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody UpdatedCategoryForm updatedCategoryForm){
        Category category = Category.builder().name(updatedCategoryForm.getName()).build();
        Category updatedCategory = categoryRepository.updateCategory(id, category);
        return ResponseEntity.ok(modelMapper.map(updatedCategory, CategoryDto.class));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removeCategory(@PathVariable Long id){
        categoryRepository.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<Category> categories = categoryRepository.listAllCategories();
        return ResponseEntity.ok(categories.stream().map(m -> modelMapper.map(m, CategoryDto.class)).toList());
    }
}
