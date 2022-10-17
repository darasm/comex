package com.bootcamp.comex.entrypoints.controller.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class UpdatedCategoryForm {

    @NotEmpty
    @NotNull
    @Size(min = 2)
    private String name;
}
