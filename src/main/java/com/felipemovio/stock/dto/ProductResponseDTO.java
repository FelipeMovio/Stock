package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(Integer id,
                                 String name,
                                 Double price,
                                 Integer Stock,
                                 BigDecimal assessment) {
    public ProductResponseDTO(Product product) {
        this(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getAssessment()
        );

    }
}
