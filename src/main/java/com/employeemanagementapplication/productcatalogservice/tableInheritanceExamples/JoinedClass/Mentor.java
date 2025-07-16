package com.employeemanagementapplication.productcatalogservice.tableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private Long Hours;
}
