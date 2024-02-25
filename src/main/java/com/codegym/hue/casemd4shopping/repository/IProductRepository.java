package com.codegym.hue.casemd4shopping.repository;


import com.codegym.hue.casemd4shopping.model.Product;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Page<ProductRes> findAllByNameContainingIgnoreCase(String search, Pageable pageable);
}
