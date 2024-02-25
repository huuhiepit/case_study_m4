package com.codegym.hue.casemd4shopping.service.company;

import com.codegym.hue.casemd4shopping.model.Company;
import com.codegym.hue.casemd4shopping.repository.ICompanyRepository;
import com.codegym.hue.casemd4shopping.service.category.dto.request.CategoryReq;
import com.codegym.hue.casemd4shopping.service.company.dto.request.CompanyReq;
import com.codegym.hue.casemd4shopping.service.impl.ICategoryService;
import com.codegym.hue.casemd4shopping.service.impl.ICompanyService;
import com.codegym.hue.casemd4shopping.service.response.SelectOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
    private final ICompanyRepository companyRepository;

    private final String ENTITY = "Company";


    @Override
    public List<SelectOptionResponse> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(company -> new SelectOptionResponse(company.getId(), company.getName())).toList();

    }

    @Override
    public void create(CompanyReq request) {
        Company company = new Company();
        company.setName(request.name());
        companyRepository.save(company);
    }

    @Override
    public void update(CompanyReq request, long id) {
        Company company = findById(id);
        company.setName(request.name());
        companyRepository.save(company);
    }

    @Override
    public void delete(long id) {
//        productRepository.deleteAllByCategory_Id(id);
        companyRepository.deleteById(id);
    }

    @Override
    public Company findById(long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Id %s not found in %s", id, "Category")));

    }

    @Override
    public long count() {
        return companyRepository.count();
    }

    @Override
    public void init() {
        Company company = new Company();
        company.setName("Category 1");
        companyRepository.save(company);
    }
}
