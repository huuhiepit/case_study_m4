package com.codegym.hue.casemd4shopping.controller.rest;

import com.codegym.hue.casemd4shopping.service.impl.IProductService;
import com.codegym.hue.casemd4shopping.service.product.dto.request.ProductReq;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductRestController {
    private final IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductRes>> findAllWithSearch(@RequestParam(required = false, defaultValue = "") String search
            , @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(productService.findAllWithSearch(search, pageable));
    }
//    @GetMapping
//    public ResponseEntity<Page<ProductRes>> findAllWithSearch(@RequestParam(required = false, defaultValue = "") String search
//            , @RequestParam(required = false) Long categoryId
//            , @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        return ResponseEntity.ok(productService.findAllWithSearch(search, categoryId, pageable));
//    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductReq request) {
        productService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ProductReq request,
                                        @PathVariable Long id) throws JsonMappingException {
        productService.update(request, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRes> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findDetailById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
