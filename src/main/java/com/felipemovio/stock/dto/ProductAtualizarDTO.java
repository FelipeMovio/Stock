package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

public record ProductAtualizarDTO(
        String name,
        Double price,
        Integer stock
) {
    public ProductAtualizarDTO(Product product) {
        this(product.getName(),
                product.getPrice(),
                product.getStock());
    }
}
