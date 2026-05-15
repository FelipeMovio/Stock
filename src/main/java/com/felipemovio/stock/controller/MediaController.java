package com.felipemovio.stock.controller;

import com.felipemovio.stock.dto.ProductResponseStatsDTO;
import com.felipemovio.stock.service.FilterProductsService;
import com.felipemovio.stock.service.MediaProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaProductService mediaProductService;

    @GetMapping
    public ResponseEntity<ProductResponseStatsDTO> medias(){
        return ResponseEntity.ok(mediaProductService.media());
    }

}
