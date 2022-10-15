package com.bootcamp.comex.entrypoints.controller;

import com.bootcamp.comex.entity.CategoryEntity;
import com.bootcamp.comex.entity.ICategoryRepository;
import com.bootcamp.comex.entrypoints.controller.dto.CategoryDto;
import com.bootcamp.comex.entrypoints.controller.forms.CategoryForm;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

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

        CategoryEntity category = categoryRepository.registerNewCategory(categoryForm.changeToCategory());

        URI uri = uriComponentsBuilder.path("/api/v1/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(category, CategoryDto.class));
    }

}
