package com.salary.salary.Stream.controller;

import com.salary.salary.Stream.service.DepartmentService;
import com.salary.salary.Stream.module.Employee;
import com.salary.salary.Stream.service.DepartmentServiceInt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceInt departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "add/{departmentId}/{name}/{surname}/{salary}")
//    метод add/{departmentId}/{name}/{surname}/{salary} работает
    public String add(@PathVariable("departmentId")Integer idDepartment, @PathVariable("name") String name, @PathVariable("surname") String surname, @PathVariable("salary") Double salary) {
        Employee employee = new Employee(name, surname, idDepartment, salary);
        return departmentService.add(idDepartment, employee);
    }
    @GetMapping(path = "remove/{departmentId}/{name}/{surname}")
    public String remove(@PathVariable("departmentId")Integer idDepartment, @PathVariable("name") String name, @PathVariable("surname") String surname) {
        Employee employee = departmentService.find(idDepartment, name, surname);
        return departmentService.remove(idDepartment, employee);
    }

    @GetMapping(path = "find/{departmentId}/{name}/{surname}")
    public Employee find(@PathVariable("departmentId")Integer idDepartment, @PathVariable("name") String name, @PathVariable("surname") String surname) {
        return departmentService.find(idDepartment, name, surname);
    }

    @GetMapping(path = "getAllEmployeesByDepartment/{departmentId}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }

    @GetMapping(path = "/sum-salary/{departmentId}")
    public double getSumSalaryForDepartment(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.getSumSalaryForDepartment(departmentId);
    }

    @GetMapping(path = "/max-salary/{departmentId}")
    public Employee getMaxSalaryForDepartment(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.getMaxSalaryForDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary/{departmentId}")
    public Employee getMinSalaryForDepartment(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.getMinSalaryForDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public String getAllMap() {
        return departmentService.getMap();
    }
}
