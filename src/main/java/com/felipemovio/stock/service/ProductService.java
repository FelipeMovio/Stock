package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductAtualizarDTO;
import com.felipemovio.stock.dto.ProductRequestDTO;
import com.felipemovio.stock.dto.ProductResponseDTO;
import com.felipemovio.stock.dto.ProductResponseMiniDTO;
import com.felipemovio.stock.exception.NotFoundException;
import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;

    //criar
    @Transactional
    public ProductResponseDTO criar(ProductRequestDTO dto){
        Product product = new Product(null, dto.name(), dto.price(), dto.quantity());

        Product saved = repository.save(product);

        return new ProductResponseDTO(saved);
    }


    // ver itens listas
    public Page<ProductResponseMiniDTO> verProdutos(Pageable pageable){
     return repository.findAll(pageable)
             .map(ProductResponseMiniDTO ::new);

    }

    // ver um item
    public ProductResponseDTO verUm(Integer id) throws NotFoundException {
        Product procurar = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto ao encontrado"));

        return new ProductResponseDTO(procurar);
    }

    // atualizar algum campo
    @Transactional
    public ProductResponseDTO atualizar(ProductAtualizarDTO dto, Integer id) throws NotFoundException {
        Product atualizado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto ao encontrado"));

        if (dto.name() != null) {
            atualizado.setName(dto.name());
        }
        if (dto.price() != null) {
            atualizado.setPrice(dto.price());
        }
        if (dto.quantity() != null) {
            atualizado.setQuantity(dto.quantity());
        }

        atualizado.setName(dto.name());
        atualizado.setPrice(dto.price());
        atualizado.setQuantity(dto.quantity());

        return new ProductResponseDTO(atualizado);

    }


    // deletar
    @Transactional
    public void deletar(Integer id) throws NotFoundException {
        Product product = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        repository.delete(product);
    }


}
