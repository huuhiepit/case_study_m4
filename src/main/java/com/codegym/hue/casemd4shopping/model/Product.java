package com.codegym.hue.casemd4shopping.model;

import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductDetailRes;
import com.codegym.hue.casemd4shopping.service.product.dto.response.ProductRes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigInteger price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;

    private Long quantity;

    private String urlImage;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

    public ProductRes toProductRes() {
        return new ProductRes(this.id, this.name, this.price,
                this.category.getName(), this.company.getName(),
                this.quantity, this.urlImage);
    }
    public ProductDetailRes toProductDetailRes() {
        return new ProductDetailRes(id, name, price, category.getId(), category.getName(), company.getId(), company.getName(), quantity, urlImage);
    }
}
