package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductAtualizarDTO;
import com.felipemovio.stock.dto.ProductRequestDTO;
import com.felipemovio.stock.dto.ProductResponseDTO;
import com.felipemovio.stock.dto.ProductResponseMiniDTO;
import com.felipemovio.stock.exception.NotFoundException;
import com.felipemovio.stock.exception.PageSizeExceededException;
import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;

    //criar
    @Transactional
    public ProductResponseDTO criar(ProductRequestDTO dto) throws NotFoundException {
        if (dto.name() == null || dto.price() == null || dto.stock() == null|| dto.assessment() == null || dto.category() == null){
            throw new NotFoundException("Os valores nao podem ser nulos ");
        }

        Product product = new Product(null, dto.name(), dto.price(), dto.stock(), dto.assessment(),dto.category());

        Product saved = repository.save(product);

        return new ProductResponseDTO(saved);
    }


    // ver itens listas
    public Page<ProductResponseMiniDTO> verProdutos(Pageable pageable) throws PageSizeExceededException{

        int size = pageable.getPageSize();

        if (size < 1 || size > 50) {
            throw new PageSizeExceededException("O tamanho da página deve estar entre 1 e 50");
        }
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
        if (dto.stock() != null) {
            atualizado.setStock(dto.stock());
        }


        repository.save(atualizado);

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
