package com.example.employeemanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2,max = 50,message = "First name must be 2 and 50 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2,max = 50,message = "Last name must be 2 and 50 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotBlank(message = "Designation cannot be Empty")
    private String designation;
}
