package com.codegym.hue.casemd4shopping.controller;

import com.codegym.hue.casemd4shopping.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "")String search){
        var model = new ModelAndView("index", "productList", productService.findAll());
        model.addObject("search", search);
        return model;
    }
}
