package com.bootcamp.comex.entity;

import com.bootcamp.comex.enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryEntity {

    private Long id;
    private String name;
    private CategoryStatus status = CategoryStatus.ACTIVE;
}
