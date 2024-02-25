package com.codegym.hue.casemd4shopping.controller.rest;

import com.codegym.hue.casemd4shopping.service.category.CategoryService;
import com.codegym.hue.casemd4shopping.service.category.dto.request.CategoryReq;
import com.codegym.hue.casemd4shopping.service.impl.ICategoryService;
import com.codegym.hue.casemd4shopping.service.response.SelectOptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
//    private final CategoryService categoryService;

    private final ICategoryService categoryService;

    public CategoryRestController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<SelectOptionResponse>> findAll(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CategoryReq request){
        categoryService.createCategory(request);
        return ResponseEntity.ok().build();
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@Valid @RequestBody CategoryReq request,
//                                       @ExistsEntity(value = Category.class, message = "Category not found") @PathVariable Long id){
//        categoryService.update(request, id);
//        return ResponseEntity.ok().build();
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
