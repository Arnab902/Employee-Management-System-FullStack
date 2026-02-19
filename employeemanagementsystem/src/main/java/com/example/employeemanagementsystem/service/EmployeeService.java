package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchAllEmployeesList();

    public Employee fetchEmployeeById(Long empId);

    public void deleteEmployeeById(Long empId);

    public Employee updateEmployeeById(Long empId, Employee employee);

    public Employee fetchEmployeeByName(String firstName);
}
