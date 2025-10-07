package com.felipemovio.stock.service;

import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // ver itens listas
    public List<Product> verProdutos(){
       return repository.findAll();

    }
}
