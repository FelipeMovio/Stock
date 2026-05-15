package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductResponseStatsDTO;
import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;

@Service
@RequiredArgsConstructor
public class MediaProductService {

    private final ProductRepository repository;


    // media das avaliacoes
    public ProductResponseStatsDTO media(){
        DoubleSummaryStatistics stats = repository.findAll().stream()
                .filter(p -> p.getAssessment() != null)
                .mapToDouble(p -> p.getAssessment().doubleValue())
                .summaryStatistics();

        return new ProductResponseStatsDTO(
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
