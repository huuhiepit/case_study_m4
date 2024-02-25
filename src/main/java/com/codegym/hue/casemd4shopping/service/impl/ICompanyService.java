package com.codegym.hue.casemd4shopping.service.impl;

import com.codegym.hue.casemd4shopping.model.Company;
import com.codegym.hue.casemd4shopping.service.company.dto.request.CompanyReq;
import com.codegym.hue.casemd4shopping.service.response.SelectOptionResponse;

import java.util.List;

public interface ICompanyService {
    List<SelectOptionResponse> findAll();
    void create(CompanyReq request);
    void update(CompanyReq request, long id);

    void delete(long id);

    Company findById(long id);
    long count();

    void init();


}
