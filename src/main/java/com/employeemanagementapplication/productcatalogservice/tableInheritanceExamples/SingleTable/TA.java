package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.SingleTable;

import jakarta.persistence.Entity;

@Entity(name="st_ta")
public class TA extends User {
    private Long rating;
}
