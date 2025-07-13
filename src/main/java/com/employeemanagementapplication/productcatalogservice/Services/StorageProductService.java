package com.employeemanagementapplication.productcatalogservice.Services;

import com.employeemanagementapplication.productcatalogservice.Models.Product;
import com.employeemanagementapplication.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements  IProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        //Optional<Product> optionalProduct = productRepo.findById(product.getId());
        return productRepo.save(product);
        //return optionalProduct.orElseGet(() -> productRepo.save(product));
    }

    @Override
    public Product replaceProduct(Product product, Long id) {
        product.setId(id);
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
