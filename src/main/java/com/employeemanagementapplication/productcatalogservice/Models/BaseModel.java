package com.employeemanagementapplication.productcatalogservice.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;

    private Date created_at;

    private Date updated_at;

    private Status status;
}
