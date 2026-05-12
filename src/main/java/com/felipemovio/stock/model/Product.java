package com.felipemovio.stock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;
    private Double price;
    private Integer stock;

    @Column(columnDefinition = "DECIMAL(2,1) CHECK (assessment >= 0 AND assessment <= 5)")
    private BigDecimal assessment;

    @Enumerated(EnumType.STRING)
    private Category category;


}
