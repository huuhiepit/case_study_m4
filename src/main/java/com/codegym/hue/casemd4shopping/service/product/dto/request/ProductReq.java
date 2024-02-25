package com.codegym.hue.casemd4shopping.service.product.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record ProductReq(
        @NotBlank(message = "Product name cannot be blank.")
        String name,
        @NotNull(message = "Product price cannot be blank")
        @Min(value = 1000, message = "Product price must be greater than or equal to 1000.")
        BigInteger price,
        @NotNull(message = "Product category cannot be blank.")
        Long categoryId,
        @NotNull(message = "Product company cannot be blank.")
        Long companyId,
        @Min(value = 0, message = "Product quantity must be greater than or equal to 0.")
        Long quantity,
        @NotNull(message = "Product image cannot be blank.")
        String urlImage
) { }
