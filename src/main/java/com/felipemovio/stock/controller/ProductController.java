package com.felipemovio.stock.controller;

import com.felipemovio.stock.dto.ProductAtualizarDTO;
import com.felipemovio.stock.dto.ProductRequestDTO;
import com.felipemovio.stock.dto.ProductResponseDTO;
import com.felipemovio.stock.exception.NotFoundException;

import com.felipemovio.stock.service.ProductService;
import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> verTodosProdutos (@PageableDefault(size = 10) Pageable pageable){
        Page<ProductResponseDTO> produtos = service.verProdutos(pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> verUm(@PathVariable Integer id) throws NotFoundException {
        ProductResponseDTO get = service.verUm(id);

        return ResponseEntity.ok(get);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> criar(@RequestBody ProductRequestDTO dto){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> atualizar(@PathVariable Integer id,
                                                        @RequestBody ProductAtualizarDTO dto
    ) throws NotFoundException {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.atualizar(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) throws NotFoundException {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
