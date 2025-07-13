package com.employeemanagementapplication.productcatalogservice.repos;

import com.employeemanagementapplication.productcatalogservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
}