package com.codegym.hue.casemd4shopping.service.product;


import com.codegym.hue.casemd4shopping.model.Category;
import com.codegym.hue.casemd4shopping.model.Product;
import com.codegym.hue.casemd4shopping.repository.IProductRepository;
import com.codegym.hue.casemd4shopping.service.impl.IProductService;
import com.codegym.hue.casemd4shopping.service.product.dto.request.ProductReq;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final ObjectMapper objectMapper;
    private final String ENTITY = "Product";

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<ProductRes> findAllWithSearch(String search, Pageable pageable) {
        search = "%" + search + "%";
        return productRepository.findAllByNameContainingIgnoreCase(search, pageable);
    }

    @Override
    public void create(ProductReq request) {
        Product product = objectMapper.convertValue(request, Product.class);
        productRepository.save(product);
    }

    @Override
    public void update(ProductReq request, long id) throws JsonMappingException {
        Product product = findById(id);
        objectMapper.updateValue(product, request);
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(() ->new RuntimeException(String.format("Id %s not found in %s", id, ENTITY)));
    }

    @Override
    public ProductRes findDetailById(long id) {
        return null;
    }

    @Override
    public long count() {
        return productRepository.count();

    }

    @Override
    public void init() {

    }

//    public Iterable<Product> getAllCategories() {
//        return productRepository.findAll();
//    }
//
//    public void create(Product product){
//        productRepository.save(product);
//    }
//    public void delete(Long id){
//        productRepository.deleteById(id);
//    }
}
