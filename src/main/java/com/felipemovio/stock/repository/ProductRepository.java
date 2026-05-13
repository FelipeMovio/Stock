package com.felipemovio.stock.repository;

import com.felipemovio.stock.model.Category;
import com.felipemovio.stock.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findTop5ByOrderByAssessmentDesc();

    List<Product> findByProdutos(Category category);

}
