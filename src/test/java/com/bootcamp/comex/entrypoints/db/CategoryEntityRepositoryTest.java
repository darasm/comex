package com.bootcamp.comex.entrypoints.db;

import com.bootcamp.comex.entity.Category;
import com.bootcamp.comex.enums.CategoryStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CategoryEntityRepositoryTest {

    @InjectMocks
    private CategoryRepository repository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ICategoryDAO iCategoryDAO;

    @Test
    public void shouldSaveCategory(){

        Category category = Category.builder()
                .id(1L)
                .name("Tech")
                .status(CategoryStatus.ACTIVE)
                .build();

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .id(1L)
                .name("Tech")
                .status(CategoryStatus.ACTIVE)
                .build();

        Category returnedCategory = repository.registerNewCategory(category);
        assertThat(returnedCategory).isEqualTo(category);
    }



}