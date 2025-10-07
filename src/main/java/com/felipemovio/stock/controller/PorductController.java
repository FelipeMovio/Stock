package com.felipemovio.stock.controller;

import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class PorductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> verProdutos(Product product){
        return repository.findAll(product);
    }

}
