package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductAtualizarDTO;
import com.felipemovio.stock.dto.ProductRequestDTO;
import com.felipemovio.stock.dto.ProductResponseDTO;
import com.felipemovio.stock.exception.NotFoundException;
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
    public ProductResponseDTO criar(ProductRequestDTO dto){
        Product product = new Product(null, dto.name(), dto.price(), dto.quantity());

        Product saved = repository.save(product);

        return new ProductResponseDTO(saved);
    }


    // ver itens listas
    public List<ProductResponseDTO> verProdutos(){
     return repository.findAll()
             .stream()
             .map(ProductResponseDTO ::new)
             .toList();

    }

    // ver um item
    public ProductResponseDTO verUm(Integer id) throws NotFoundException {
        Product procurar = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto ao encontrado"));

        return new ProductResponseDTO(procurar);
    }

    // atualizar algum campo
    public ProductResponseDTO atualizar(ProductAtualizarDTO dto, Integer id) throws NotFoundException {
        Product atualixado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto ao encontrado"));

        atualixado.setName(dto.name());
        atualixado.setPrice(dto.price());
        atualixado.setQuantity(dto.quantity());

        return new ProductResponseDTO(atualixado);

    }

    // deletar

    public void deletar(Integer id){
        repository.deleteById(id);
    }


}
