package com.codegym.hue.casemd4shopping.service.impl;

import com.codegym.hue.casemd4shopping.model.Product;
import com.codegym.hue.casemd4shopping.service.product.dto.request.ProductReq;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Iterable<Product> findAll();
    Page<ProductRes> findAllWithSearch(String search, Pageable pageable);
    void create(ProductReq request);
    void update(ProductReq request, long id) throws JsonMappingException;

    void delete(long id);

    Product findById(long id);

    ProductRes findDetailById(long id);

    long count();
    void init();
}
