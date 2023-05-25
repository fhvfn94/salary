package com.salary.salary.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService  service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(path = "/departments/max-salary/{departmentId}")
    public Employee findEmployeeWithMaxSalaryForDepartment(@PathVariable("departmentId") Integer departmentId) {
        return service.findEmployeeWithMaxSalaryForDepartment(departmentId);
    }

    @GetMapping(path = "/departments/min-salary/{departmentId}")
    public Employee findEmployeeWithMinSalaryForDepartment(@PathVariable("departmentId") Integer departmentId) {
        return service.findEmployeeWithMinSalaryForDepartment(departmentId);
    }

    @GetMapping(path = "/departments/all/{departmentId}")
    public List<Employee> findEmployeeByDepartment(@PathVariable("departmentId") Integer departmentId) {
        return service.findEmployeeByDepartment(departmentId);
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> findEmployeeSortByDepartment() {
        return service.findEmployeeSortByDepartment();
    }
}
