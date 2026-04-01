package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductResponseDTO;
import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;

    //criar



    // ver itens listas
    public List<ProductResponseDTO> verProdutos(){
     return repository.findAll()
             .stream()
             .map(ProductResponseDTO ::new)
             .toList();

    }

    //


}
