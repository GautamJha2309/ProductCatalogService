package com.employeemanagementapplication.productcatalogservice.repos;

import com.employeemanagementapplication.productcatalogservice.Models.Category;
import com.employeemanagementapplication.productcatalogservice.Models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo ;

    @Test
    @Transactional //Why I am adding this ?
    public  void testLoading() {
        Optional<Category> categoryOptional = categoryRepo.findById(2L);
//        for(Product p : categoryOptional.get().getProducts()) {
//            System.out.println(p.getName());
//        }
    }

}