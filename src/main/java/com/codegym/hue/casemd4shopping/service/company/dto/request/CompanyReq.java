package com.codegym.hue.casemd4shopping.service.company.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record CompanyReq(
        @NotBlank(message = "Tên không được để trống")
        @Max(value = 100, message = "Tên không quá 100 ký tự")
        String name
) {
}
