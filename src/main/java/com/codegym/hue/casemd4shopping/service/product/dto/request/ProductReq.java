package com.codegym.hue.casemd4shopping.service.product.dto.request;

import com.codegym.hue.casemd4shopping.model.Category;
import com.codegym.hue.casemd4shopping.model.Company;
import com.codegym.hue.casemd4shopping.model.Image;
import com.codegym.hue.casemd4shopping.model.OrderItem;
import com.codegym.hue.casemd4shopping.service.request.SelectOptionRequest;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.math.BigInteger;
import java.util.List;

public record ProductReq (
         String name,
         BigInteger price,
         SelectOptionRequest category,
         SelectOptionRequest company,
         Long quantity,
         SelectOptionRequest image
//         List<OrderItem> orderItemList
){
}
