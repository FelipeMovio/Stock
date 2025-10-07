package com.felipemovio.stock.controller;

import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import com.felipemovio.stock.service.ProductService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class PorductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> verTodosProdutos(){
        List<Product> produtos = service.verProdutos();
        return ResponseEntity.ok(produtos);
    }

}
