package com.felipemovio.stock.service;

import com.felipemovio.stock.dto.ProductResponseStatsDTO;
import com.felipemovio.stock.model.Product;
import com.felipemovio.stock.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MediaProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private MediaProductService service;

    @Test
    void deveCalcularMediaMinimoEMaximoCorretamente() {

        Product p1 = new Product();
        p1.setAssessment(BigDecimal.valueOf(5));

        Product p2 = new Product();
        p2.setAssessment(BigDecimal.valueOf(8));

        Product p3 = new Product();
        p3.setAssessment(BigDecimal.valueOf(10));

        when(repository.findAll())
                .thenReturn(List.of(p1, p2, p3));

        ProductResponseStatsDTO resultado = service.media();

        assertEquals(7.666666666666667, resultado.average());
        assertEquals(5.0, resultado.min());
        assertEquals(10.0, resultado.max());
    }
}