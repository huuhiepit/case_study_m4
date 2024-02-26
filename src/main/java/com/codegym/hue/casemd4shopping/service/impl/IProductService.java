package com.codegym.hue.casemd4shopping.service.impl;

import com.codegym.hue.casemd4shopping.model.Product;
import com.codegym.hue.casemd4shopping.service.product.dto.request.ProductReq;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductDetailRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductHomeRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductRes> findAllBySearch(String search, Pageable pageable);
    Page<ProductRes> findAllByCategoryOrCompanyType(Long categoryId, Long companyId, Pageable pageable);
    Page<ProductHomeRes> findAllByWithHome(String search, Pageable pageable);
    ProductDetailRes findDetailBy(Long id);
    ProductRes create(ProductReq productReq);
    ProductRes update(ProductReq productReq, Long id);
    void deletedBy(Long id);
}
