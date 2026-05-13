package com.felipemovio.stock.controller;

import com.felipemovio.stock.dto.ProductResponseMiniDTO;
import com.felipemovio.stock.exception.NotFoundException;
import com.felipemovio.stock.model.Category;
import com.felipemovio.stock.service.FilterProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filter")
@RequiredArgsConstructor
public class FilterPoductController {

    private final FilterProductsService filterProductsService;

    @GetMapping("/melhores")
    public ResponseEntity <List<ProductResponseMiniDTO>> melhores(){
        return ResponseEntity.ok(filterProductsService.top5());
    }

    @GetMapping("/melhores/baratos")
    public ResponseEntity <List<ProductResponseMiniDTO>> melhoresBaratos(){
        return ResponseEntity.ok(filterProductsService.melhoresAndBaratos());
    }

    @GetMapping("/busca/categoria/{category}")
    public ResponseEntity<List<ProductResponseMiniDTO>> porCategoria(@PathVariable String category) throws NotFoundException {

            Category categoryConvert = Category.valueOf(category.toUpperCase());

            return ResponseEntity.ok(filterProductsService.buscaPorCategoria(categoryConvert));


    }
}
