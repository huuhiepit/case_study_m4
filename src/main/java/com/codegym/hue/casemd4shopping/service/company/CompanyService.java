package com.codegym.hue.casemd4shopping.service.company;

import com.codegym.hue.casemd4shopping.model.Company;
import com.codegym.hue.casemd4shopping.repository.ICompanyRepository;
import com.codegym.hue.casemd4shopping.service.impl.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
    private final ICompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
