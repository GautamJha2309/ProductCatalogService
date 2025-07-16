package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.SingleTable;

import jakarta.persistence.Entity;

@Entity(name="st_instructor")
public class Instructor extends User {
    private String companyName;
}
