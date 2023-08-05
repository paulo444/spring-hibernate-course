package com.spring.Tutorial.rest;

import com.spring.Tutorial.entity.Employee;
import com.spring.Tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public String findAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "directory";
    }
}














