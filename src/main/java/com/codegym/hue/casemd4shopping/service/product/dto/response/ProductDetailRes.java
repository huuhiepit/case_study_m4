package com.codegym.hue.casemd4shopping.service.product.dto.response;

import java.math.BigInteger;

public record ProductDetailRes(
        Long id,
        String name,
        BigInteger price,
        Long categoryId,
        String categoryName,
        Long companyId,
        String companyName,
        Long quantity,
        String urlImage
) { }
