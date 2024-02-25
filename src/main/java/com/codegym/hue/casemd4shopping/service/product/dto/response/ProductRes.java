package com.codegym.hue.casemd4shopping.service.product.dto.response;

import com.codegym.hue.casemd4shopping.model.OrderItem;
import com.codegym.hue.casemd4shopping.service.request.SelectOptionRequest;

import java.math.BigInteger;
import java.util.List;

public record ProductRes(
        Long id,
        String name,
        BigInteger price,
        Long categoryId,
        Long companyId,
        Long quantity,
        Long imageId
//        List<OrderItem> orderItemList
) {
}
