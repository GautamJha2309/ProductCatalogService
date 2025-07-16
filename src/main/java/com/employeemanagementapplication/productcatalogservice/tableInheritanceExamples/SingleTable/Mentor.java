package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.SingleTable;

import jakarta.persistence.Entity;

@Entity(name="st_mentor")
public class Mentor extends User {
    private Long Hours;
}
