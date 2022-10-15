package com.bootcamp.comex.entrypoints.controller.dto;

import com.bootcamp.comex.enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class CategoryDto {

    private Long id;
    private String name;
    private CategoryStatus status;

}
