package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User{
    private Long Hours;
}
