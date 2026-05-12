package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

public record ProductResponseMiniDTO(
        Integer id,
        String name,
        Double price
) {

    public ProductResponseMiniDTO(Product product) {
        this(product.getId(),
                product.getName(),
                product.getPrice()
                );
    }
}
