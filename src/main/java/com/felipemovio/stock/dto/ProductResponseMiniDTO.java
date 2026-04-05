package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

public record ProductResponseMiniDTO(
        Integer id,
        String name
) {

    public ProductResponseMiniDTO(Product product) {
        this(product.getId(),
                product.getName()
                );
    }
}
