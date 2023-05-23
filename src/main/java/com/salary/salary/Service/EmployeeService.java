package com.salary.salary.Service;

import com.salary.salary.Domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String name, String surName, String patronymicName, double salary, int department);

    Employee removeEmployee(String name, String surName, String patronymicName, double salary, int department);

    Employee findEmployee(String name, String surName, String patronymicName, double salary, int department);

    Employee findEmployeeWithMaxSalaryForDepartment(Integer departmentId);

    Employee findEmployeeWithMinSalaryForDepartment(Integer departmentId);

    List<Employee> findEmployeeByDepartment(Integer departmentId);

    List<Employee> findEmployeeSortByDepartment();
}
