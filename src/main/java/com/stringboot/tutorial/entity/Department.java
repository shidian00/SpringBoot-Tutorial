package com.stringboot.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Entity
@Data // Lombok package
@NoArgsConstructor // default constructor
@AllArgsConstructor // Constructor with all the args
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;


    @NotBlank(message = "Department name cannot be blank.")
    /*
    @Length
    @Size
    @Email
    @Positive
    @Future
    @Past
    */
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
