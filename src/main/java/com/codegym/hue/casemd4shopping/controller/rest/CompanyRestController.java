package com.codegym.hue.casemd4shopping.controller.rest;

import com.codegym.hue.casemd4shopping.service.company.dto.request.CompanyReq;
import com.codegym.hue.casemd4shopping.service.impl.ICompanyService;
import com.codegym.hue.casemd4shopping.service.response.SelectOptionResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyRestController {
    private final ICompanyService companyService;


    public CompanyRestController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<SelectOptionResponse>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CompanyReq request){
        companyService.create(request);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CompanyReq request,
                                        @PathVariable Long id){
        companyService.update(request, id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        companyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
