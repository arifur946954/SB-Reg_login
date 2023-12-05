package com.CRUD.LogReg.rest;

import com.CRUD.LogReg.entity.Employee;
import com.CRUD.LogReg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
    private EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/home")
    public  String homePage(){
    return "/employee/index";
    }
@GetMapping("/list")
    public String findAllEmp(Model theModel){
  List<Employee> theEmployees=   employeeService.findAll();
  theModel.addAttribute("employees",theEmployees);
  return "employee/list-employee";
    }
    //save employee from frontEnt
    @PostMapping("/saveEmployeeForm")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
    employeeService.save(theEmployee);
    return "redirect:/employee/list";

    }
//@GetMapping("/signUp")
//    public String signUp(Model theModel){
//    //create Employee object
//    Employee theEmployee=new Employee();
//    //add student obj in the model
//    theModel.addAttribute("employees",theEmployee);
//return "/employee/signUp";
//    }

    @GetMapping("/signUp")
    public String signUp(Model theModel){
        Employee theEmployee=new Employee();
        theModel.addAttribute("employees",theEmployee);
        return "/employee/signUp";
    }


}
