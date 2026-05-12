package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Product;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        Double price,
        Integer stock,


        BigDecimal assessment
) {
    public Product toEntity(){
        return new Product(null,this.name, this.price, this.stock, this.assessment);
    }
}
