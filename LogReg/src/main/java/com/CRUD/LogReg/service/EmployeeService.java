package com.CRUD.LogReg.service;

import com.CRUD.LogReg.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    void save(Employee theEmployee);

}
