package com.codegym.hue.casemd4shopping.repository;

import com.codegym.hue.casemd4shopping.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Long> {
}
