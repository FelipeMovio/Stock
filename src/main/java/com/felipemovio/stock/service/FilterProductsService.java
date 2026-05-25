package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductResponseMiniDTO;
import com.felipemovio.stock.dto.ProductResponseStatsDTO;
import com.felipemovio.stock.model.Category;
import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterProductsService {

    private final ProductRepository repository;


    // filtragens apenas por stream(), lambdas
    // melhores avaliados
    public List<ProductResponseMiniDTO> melhores(){
        return repository.findAll()
                .stream()
                .filter(p -> p.getAssessment() != null &&
                        p.getAssessment().compareTo(new BigDecimal("3.5")) >= 0)
                .sorted(Comparator.comparing(Product::getAssessment).reversed())
                .map(ProductResponseMiniDTO::new)
                .collect(Collectors.toList());

    }

    // melhores e mais baratos
    public  List<ProductResponseMiniDTO> melhoresAndBaratos(){

        return melhores().stream()
                .sorted(Comparator.comparing(ProductResponseMiniDTO::price)) // mais baratos primeiro
                .limit(10) // (top 10)
                .collect(Collectors.toList());
    }

    // filtragens por consultas sql atraves do jpa( spring )
    // top5 produtos por avaliacao
    public List<ProductResponseMiniDTO> top5(){

        List<Product> top5 = repository.findTop5ByOrderByAssessmentDesc();



        return  top5
                .stream()
                .map(ProductResponseMiniDTO::new)
                .collect(Collectors.toList());
    }

    public List<ProductResponseMiniDTO> buscaPorCategoria(Category category){

        List<Product> search = repository.findByCategory(category);

        return search
                .stream()
                .map(ProductResponseMiniDTO ::new)
                .toList();
    }
}
