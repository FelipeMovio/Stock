package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

public record ProductRequestDTO(
        String name,
        Double price,
        Integer quantity
) {
    public ProductRequestDTO(Product product) {
        this(product.getName(),
                product.getPrice(),
                product.getQuantity());
    }
}
