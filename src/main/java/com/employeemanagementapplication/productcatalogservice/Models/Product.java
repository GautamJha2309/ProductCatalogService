package com.employeemanagementapplication.productcatalogservice.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String name;

    private String discription;

    private double price;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    private Boolean isPrimeSaleSpecific;
}
