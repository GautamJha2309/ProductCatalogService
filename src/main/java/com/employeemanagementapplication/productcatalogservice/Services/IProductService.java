package com.employeemanagementapplication.productcatalogservice.Services;

import com.employeemanagementapplication.productcatalogservice.Models.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(Product product, Long id);

    List<Product> getAllProducts();
}
