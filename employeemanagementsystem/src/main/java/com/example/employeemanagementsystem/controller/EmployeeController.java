package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employee")
public class EmployeeController
{

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public Employee saveEmployee(@Valid @RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/fetchall")
    public List<Employee> fetchAllEmployee()
    {
        return employeeService.fetchAllEmployeesList();
    }

    @GetMapping("/fetch/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long empId)
    {
       return employeeService.fetchEmployeeById(empId);
    }

    @DeleteMapping("delete/{id}")
    public String  deleteEmployee(@PathVariable("id") Long empId)
    {
        employeeService.deleteEmployeeById(empId);
        return "Employee Details Deleted Successfully";
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") Long empId,@Valid @RequestBody Employee employee)
    {
        return employeeService.updateEmployeeById(empId, employee);
    }

    @GetMapping("/name/{firstname}")
    public Employee fetchEmployeeByName(@PathVariable("firstname") String firstname) {
        return employeeService.fetchEmployeeByName(firstname);
    }
}
