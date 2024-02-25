package com.codegym.hue.casemd4shopping.controller.rest;

import com.codegym.hue.casemd4shopping.model.Category;
import com.codegym.hue.casemd4shopping.service.impl.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryRestController {
    private final ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
