package com.codegym.hue.casemd4shopping.repository;

public interface IProductRepository {

import com.codegym.hue.casemd4shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {


}
