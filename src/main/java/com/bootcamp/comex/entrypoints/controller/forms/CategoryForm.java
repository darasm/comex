package com.bootcamp.comex.entrypoints.controller.forms;
import com.bootcamp.comex.entity.Category;
import com.bootcamp.comex.enums.CategoryStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CategoryForm {

    @NotNull
    @NotEmpty
    @Size(min = 2)
    private String name;

    public Category changeToCategory() {
        return Category.builder()
                .name(this.name)
                .status(CategoryStatus.ACTIVE)
                .build();
    }
}
