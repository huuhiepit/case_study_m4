package com.codegym.hue.casemd4shopping.service.product.dto.response;

import java.math.BigInteger;

public record ProductHomeRes(
        Long id,
        String urlImage,
        String name,
        BigInteger price
) {
}
