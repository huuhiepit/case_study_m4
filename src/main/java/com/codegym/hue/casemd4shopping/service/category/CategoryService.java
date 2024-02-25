package com.codegym.hue.casemd4shopping.service.category;

import com.codegym.hue.casemd4shopping.model.Category;
import com.codegym.hue.casemd4shopping.repository.ICategoryRepository;

import com.codegym.hue.casemd4shopping.service.category.dto.request.CategoryReq;
import com.codegym.hue.casemd4shopping.service.category.dto.response.CategoryRes;
import com.codegym.hue.casemd4shopping.service.impl.ICategoryService;
import com.codegym.hue.casemd4shopping.service.response.SelectOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;


    @Override
    public List<SelectOptionResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new SelectOptionResponse(category.getId(), category.getName())).toList();
    }

    @Override
    public void createCategory(CategoryReq request) {
        Category category = new Category();
        category.setName(request.name());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryReq request, Long id) {
        Category category = findById(id);
        category.setName(request.name());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Id %s not found in %s", id, "Category")));
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public void init() {
        Category category = new Category();
        category.setName("Category 1");
        categoryRepository.save(category);
    }
}
