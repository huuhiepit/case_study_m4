package com.codegym.hue.casemd4shopping.controller.rest;

import com.codegym.hue.casemd4shopping.model.Product;
import com.codegym.hue.casemd4shopping.service.impl.IProductService;
import com.codegym.hue.casemd4shopping.service.product.dto.request.ProductReq;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductDetailRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductHomeRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductRestController {
    private final IProductService productService;
    @GetMapping
    public ResponseEntity<Page<ProductRes>> index(@RequestParam(defaultValue = "") String search,
                                                  @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(productService.findAllBySearch(search, pageable));
    }
    @GetMapping("/home")
    public ResponseEntity<Page<ProductHomeRes>> indexHome(@RequestParam(defaultValue = "") String search,
                                                          @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(productService.findAllByWithHome(search, pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailRes> getDetailProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findDetailBy(id));
    }
    @PostMapping
    public ResponseEntity<ProductRes> create(@Valid @RequestBody ProductReq productReq) {
        return ResponseEntity.ok(productService.create(productReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRes> update(@PathVariable Long id , @Valid @RequestBody ProductReq productReq) {
        return ResponseEntity.ok(productService.update(productReq, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deletedBy(id);
        return ResponseEntity.ok().build();
    }
}
