package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

public record ProductResponseDTO(Integer id,
                                 String name,
                                 Double price,
                                 Integer quantity) {
    public ProductResponseDTO(Product product) {
        this(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );

    }
}
