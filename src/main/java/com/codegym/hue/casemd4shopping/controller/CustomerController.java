package com.codegym.hue.casemd4shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CustomerController {
    @GetMapping
    public String index() {
        return "customer/index";
    }
    @GetMapping("/shop")
    public String shop() {
        return "customer/shop";
    }
    @GetMapping("/cart")
    public String cart() {
        return "customer/cart";
    }
}
