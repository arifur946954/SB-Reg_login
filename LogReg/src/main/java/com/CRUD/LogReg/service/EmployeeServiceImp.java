package com.CRUD.LogReg.service;

import com.CRUD.LogReg.dao.EmployeeRepository;
import com.CRUD.LogReg.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImp implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

      //optional is jparepo type when we use findById we must use oprional
        Optional<Employee> tempEmployee=  employeeRepository.findById(theId);
        Employee theEmployee=null;
        if (tempEmployee.isPresent()){

            theEmployee=tempEmployee.get();//tempEmployee return type is optional thats why we use .get
        }
        else {
            throw new RuntimeException("result didnt find"+theId);
        }
        return theEmployee;






    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);

    }


}
