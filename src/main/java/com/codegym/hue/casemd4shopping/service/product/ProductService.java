package com.codegym.hue.casemd4shopping.service.product;

import com.codegym.hue.casemd4shopping.service.impl.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

import com.codegym.hue.casemd4shopping.repository.IProductRepository;
import com.codegym.hue.casemd4shopping.service.impl.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

}
