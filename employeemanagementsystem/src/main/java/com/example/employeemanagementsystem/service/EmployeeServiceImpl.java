package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployeesList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);

        if(employee.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long empId)
    {
        if(!employeeRepository.existsById(empId))
        {
            throw new EmployeeNotFoundException("Employee not found with id: " + empId);
        }

         employeeRepository.deleteById(empId);
    }

    @Override
    public Employee updateEmployeeById(Long empId, Employee employee)
    {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        if(employeeOptional.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee Not Available");
        }

        Employee empDb = employeeOptional.get();


        if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName()))
        {
            empDb.setFirstName(employee.getFirstName());
        }

        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName()))
        {
            empDb.setLastName(employee.getLastName());
        }

        if(Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress()))
        {
            empDb.setAddress(employee.getAddress());
        }

        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail()))
        {
            empDb.setEmail(employee.getEmail());
        }

        if(Objects.nonNull(employee.getDesignation()) && !"".equalsIgnoreCase(employee.getDesignation()))
        {
            empDb.setDesignation(employee.getDesignation());
        }

        return employeeRepository.save(empDb);
    }

    @Override
    public Employee fetchEmployeeByName(String firstName) {
        Employee employee = employeeRepository.findByFirstNameContainingIgnoreCase(firstName);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with name: " + firstName);
        }
        return employee;
    }
}
