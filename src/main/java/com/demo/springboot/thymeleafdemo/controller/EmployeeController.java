package com.demo.springboot.thymeleafdemo.controller;

import com.demo.springboot.thymeleafdemo.entity.Employee;
import com.demo.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get all the employees from the database
        List<Employee> employees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // create model attribute to bind the form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save the employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        // redirect to request mapping "/employees/list"
        return "redirect:/employees/list";
    }
}









