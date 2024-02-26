package com.codegym.hue.casemd4shopping.service.product;

import com.codegym.hue.casemd4shopping.model.Product;
import com.codegym.hue.casemd4shopping.repository.ICategoryRepository;
import com.codegym.hue.casemd4shopping.repository.ICompanyRepository;

import com.codegym.hue.casemd4shopping.repository.IProductRepository;
import com.codegym.hue.casemd4shopping.service.impl.IProductService;
import com.codegym.hue.casemd4shopping.service.product.dto.request.ProductReq;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductDetailRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductHomeRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    private final ICompanyRepository companyRepository;

    @Override
    public Page<ProductRes> findAllBySearch(String search, Pageable pageable) {
        return productRepository.findAllByNameContainingIgnoreCaseOrCategoryNameOrCompanyName(search, search, search, pageable)
                .map(Product::toProductRes);
    }

    @Override
    public Page<ProductRes> findAllByCategoryOrCompanyType(Long categoryId, Long companyId, Pageable pageable) {
        return productRepository.findAllByCategoryIdOrCompanyId(categoryId, companyId, pageable)
                .map(Product::toProductRes);
    }

    @Override
    public Page<ProductHomeRes> findAllByWithHome(String search, Pageable pageable) {
        return productRepository.findAllByNameContainingIgnoreCaseOrCategoryNameOrCompanyName(search, search, search, pageable)
                .map(Product::toProductHomeRes);
    }

    @Override
    public ProductDetailRes findDetailBy(Long id) {
        Product p = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find product"));
        return p.toProductDetailRes();
    }

    @Override
    public ProductRes create(ProductReq productReq) {
        try {
            Product product = new Product();
            if(productRepository.existsProductByNameContainingIgnoreCase(productReq.name())) {
                throw new IllegalStateException("Product name already exists.");
            }
            return getProductRes(productReq, product);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error created product: " + e.getMessage());
        }
    }

    @Override
    public ProductRes update(ProductReq productReq, Long id) {
        try {
            Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find product"));
            product.setId(id);
            return getProductRes(productReq, product);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updated product: " + e.getMessage());
        }
    }

    private ProductRes getProductRes(ProductReq productReq, Product product) {
        product.setName(productReq.name());
        product.setPrice(productReq.price());
        product.setCategory(
                categoryRepository.findById(productReq.categoryId())
                        .orElseThrow(() -> new IllegalArgumentException("Cannot find category")));
        product.setCompany(
                companyRepository.findById(productReq.companyId())
                        .orElseThrow(() -> new IllegalArgumentException("Cannot find company")));
        product.setQuantity(productReq.quantity());
        product.setUrlImage(productReq.urlImage());
        return productRepository.save(product).toProductRes();
    }

    @Override
    public void deletedBy(Long id) {
        try {
            findDetailBy(id);
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Product deletion failed.");
        }
    }
}
