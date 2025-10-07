package com.felipemovio.stock.repository;

import com.felipemovio.stock.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {
}
