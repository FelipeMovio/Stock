package com.felipemovio.stock.dto;

import com.felipemovio.stock.model.Category;
import com.felipemovio.stock.model.Product;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        Double price,
        Integer stock,


        BigDecimal assessment,
        Category category
) {
    public Product toEntity(){
        return new Product(null,this.name, this.price, this.stock, this.assessment, this.category);
    }
}
