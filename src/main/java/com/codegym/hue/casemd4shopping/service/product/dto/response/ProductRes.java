package com.codegym.hue.casemd4shopping.service.product.dto.response;


import java.math.BigInteger;

public record ProductRes(
        Long id,
        String name,
        BigInteger price,
        String categoryName,
        String companyName,
        Long quantity,
        String urlImage

) { }
