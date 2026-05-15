package com.felipemovio.stock.service;

import com.felipemovio.stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaProductController {

    private final ProductRepository repository;
}
