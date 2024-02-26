package com.codegym.hue.casemd4shopping.repository;

import com.codegym.hue.casemd4shopping.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByNameContainingIgnoreCaseOrCategoryNameOrCompanyName(String name, String categoryName, String companyName, Pageable pageable);
    Page<Product> findAllByCategoryIdOrCompanyId(Long categoryId, Long companyId, Pageable pageable);
    boolean existsProductByNameContainingIgnoreCase(String productName);
}
