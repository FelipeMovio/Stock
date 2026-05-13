package com.felipemovio.stock.controller;

import com.felipemovio.stock.dto.ProductResponseMiniDTO;
import com.felipemovio.stock.model.Category;
import com.felipemovio.stock.service.FilterProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/busca/categoria")
    public ResponseEntity<List<ProductResponseMiniDTO>> porCategoria(@RequestBody Category category){
        return ResponseEntity.ok(filterProductsService.buscaPorCategoria(category));
    }


}
