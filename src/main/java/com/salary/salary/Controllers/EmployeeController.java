package com.salary.salary.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hrapp")
public class EmployeeController {
    @GetMapping
    public String welcome() {
        return "Welcome to HR application";
    }
}
