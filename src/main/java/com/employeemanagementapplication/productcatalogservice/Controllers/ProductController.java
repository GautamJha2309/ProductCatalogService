package com.employeemanagementapplication.productcatalogservice.Controllers;


import com.employeemanagementapplication.productcatalogservice.Models.Category;
import com.employeemanagementapplication.productcatalogservice.Models.Product;
import com.employeemanagementapplication.productcatalogservice.Services.IProductService;
import com.employeemanagementapplication.productcatalogservice.dtos.CategoryDto;
import com.employeemanagementapplication.productcatalogservice.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@RestController = @Controller + @ResponseBody
// https://www.baeldung.com/spring-bean-scopes
@RestController
public class ProductController {


    //@Qualifier("StorageProductService")
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        //return productService.getAllProducts();
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Read for @PathVariable , @RequestParam and @QueryParam
    //https://www.baeldung.com/spring-requestparam-vs-pathvariable
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {

        if(productId <= 0) { throw new IllegalArgumentException("Invalid product id"); }

        Product product = productService.getProductById(productId);

        if(product == null) { throw new IllegalArgumentException("Invalid product id"); }

        ProductDto productDto = from(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product output = productService.createProduct(product);
        if(output == null) { throw new IllegalArgumentException("Invalid product id"); }
        return from(output);
    }

    @PutMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product output = productService.replaceProduct(product, id);
        if(output == null) { throw new IllegalArgumentException("Invalid product id"); }
        return from(output);
    }

//    @GetMapping("/limitedProduct/{limit}")
//    public List<ProductDto> getLimitedProducts(int limit) {
//        return productService.getAllProductsByLimit(limit);
//    }

    @GetMapping("/test")
    public String test(){
        return "Connected";
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(productDto.getDescription());
        productDto.setImageUrl(product.getImageUrl());

        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDiscription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;
    }

}
