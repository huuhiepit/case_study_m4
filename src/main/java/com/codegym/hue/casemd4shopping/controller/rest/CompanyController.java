package com.codegym.hue.casemd4shopping.controller.rest;

import com.codegym.hue.casemd4shopping.model.Company;
import com.codegym.hue.casemd4shopping.service.impl.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/companies")
@AllArgsConstructor
public class CompanyController {
    private final ICompanyService companyService;
    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(companyService.getAll());
    }
}
