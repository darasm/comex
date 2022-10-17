package com.bootcamp.comex.entrypoints.db.products;

import com.bootcamp.comex.entrypoints.db.category.CategoryEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Min(0)
    private int quantity;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoryEntity category;

    @Embedded
    private DimensionsEntity dimensions;

}
