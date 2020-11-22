package org.io.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.io.crud.model.Employee;
import org.io.crud.service.Employee_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Employee_Controller {
    @Autowired
    Employee_Service employee_service;

    // get all employee
    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employee_service.getEmployeeList();
    }
    // get employee by id
    @GetMapping("/employee/{id$}")
    public Employee getEmployee(@PathVariable int id$){
        return employee_service.getEmployee(id$);
    }
    // post all employee
    @PostMapping("/employees")
    public List<Employee> postEmployeeList(@RequestBody List<Employee> employeeList$){
        return employee_service.postEmployeeList(employeeList$);
    }
    // post one employee
    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee$){
        return employee_service.postEmployee(employee$);
    }
    // delete employee by id
    @DeleteMapping("/employee/{id$}")
    public String deleteEmployee(@PathVariable int id$){
        return employee_service.deleteEmployee(id$);
    }
    // delete employee
    @DeleteMapping("/employee")
    public String deleteEmployee(@RequestBody Employee employee$){
        return employee_service.deleteEmployee(employee$);
    }
    // update employee
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee$){
        return employee_service.updateEmployee(employee$);
    }
}
