package com.codegym.hue.casemd4shopping.service.impl;


import com.codegym.hue.casemd4shopping.model.Category;
import com.codegym.hue.casemd4shopping.service.category.dto.request.CategoryReq;
import com.codegym.hue.casemd4shopping.service.category.dto.response.CategoryRes;
import com.codegym.hue.casemd4shopping.service.response.SelectOptionResponse;

import java.util.List;

public interface ICategoryService {
    List<SelectOptionResponse> getAllCategories();

    void createCategory(CategoryReq request);
    void updateCategory(CategoryReq request, Long id);
    void deleteCategory(Long id);
    Category findById(long id);
    long count();

    void init();
}
