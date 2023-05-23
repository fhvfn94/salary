package com.salary.salary.Controllers;

import com.salary.salary.Domain.Employee;
import com.salary.salary.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to HR application";
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("patronymicName") String patronymicName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department) {
        return service.addEmployee(firstName, lastName, patronymicName,  salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("patronymicName") String patronymicName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department) {
        return service.findEmployee(firstName, lastName, patronymicName,  salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("patronymicName") String patronymicName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department) {
        return service.removeEmployee(firstName, lastName, patronymicName,  salary, department);
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
