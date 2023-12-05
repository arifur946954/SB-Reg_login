package com.CRUD.LogReg.dao;

import com.CRUD.LogReg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
