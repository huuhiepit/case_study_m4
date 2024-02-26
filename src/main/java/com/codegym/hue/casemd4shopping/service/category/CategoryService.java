package com.codegym.hue.casemd4shopping.service.category;


import com.codegym.hue.casemd4shopping.model.Category;
import com.codegym.hue.casemd4shopping.repository.ICategoryRepository;
import com.codegym.hue.casemd4shopping.service.impl.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
