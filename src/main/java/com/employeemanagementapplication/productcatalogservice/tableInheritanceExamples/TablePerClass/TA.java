package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class TA extends User {
    private Long rating;
}
