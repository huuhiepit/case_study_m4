package com.codegym.hue.casemd4shopping.repository;

import com.codegym.hue.casemd4shopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
