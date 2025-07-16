package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.SingleTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.UUID;

@Entity(name="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    private UUID id;

    private String name;

    private String email;
}
