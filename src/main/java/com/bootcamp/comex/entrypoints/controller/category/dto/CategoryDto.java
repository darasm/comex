package com.bootcamp.comex.entrypoints.controller.category.dto;

import com.bootcamp.comex.enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryDto {

    private Long id;
    private String name;
    private CategoryStatus status;

}
