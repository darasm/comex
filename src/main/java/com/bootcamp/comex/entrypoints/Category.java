package com.bootcamp.comex.entrypoints;

import com.bootcamp.comex.enums.CategoryStatus;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryStatus status = CategoryStatus.ACTIVE;


}
