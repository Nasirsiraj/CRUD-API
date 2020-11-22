package org.io.crud.service;

import org.io.crud.model.Employee;
import org.io.crud.repository.Employee_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class Employee_Service {
    @Autowired
    Employee_Repository employee_repository;

    // get all employee
    public List<Employee> getEmployeeList(){
        return employee_repository.findAll();
    }
    // get employee by id
    public Employee getEmployee(@Validated int id$){
        return employee_repository.findById(id$).orElse(null);
    }
    // post all employee
    public List<Employee> postEmployeeList(@Validated List<Employee> employeeList$){
        return employee_repository.saveAll(employeeList$);
    }
    // post one employee
    public Employee postEmployee(@Validated Employee employee$){
        return employee_repository.save(employee$);
    }
    // delete employee by id
    public String deleteEmployee(@Validated int id$){
        Employee employee_ = employee_repository.findById(id$).orElse(null);
        if (employee_ != null){
            employee_repository.deleteById(id$);
            return "employee deleted, id: "+id$;
        }else {
            return "employee not found!";
        }
    }
    // delete employee by obj
    public String deleteEmployee(@Validated Employee employee$){
        Employee employee_ = employee_repository.findById(employee$.getId()).orElse(null);
        if(employee_ != null){
            employee_repository.delete(employee$);
            return "employee deleted, id: "+employee$.getId()+".";
        }else {
            return "employee not found!";
        }
    }
    // update employee obj
    public Employee updateEmployee(@Validated Employee employee$){
        Employee employee$$ = employee_repository.findById(employee$.getId()).orElse(null);
        if(employee$$ != null){
            employee$$.setName(employee$.getName());
            employee$$.setDepartment(employee$.getDepartment());
            employee$$.setShift(employee$.getShift());
            employee$$.setSalary(employee$.getSalary());

            return employee_repository.save(employee$$);
        }else{
            return null;
        }
    }
}
