package com.salary.salary.Stream.service;

import com.salary.salary.Stream.module.Employee;

import java.util.List;

public interface DepartmentServiceInt {
    String add(Integer idDepartment, Employee employee);

    String remove(Integer idDepartment, Employee employee);

    Employee find(Integer idDepartment, String name, String surName);

    List<Employee> getAllEmployeesByDepartment(Integer idDepartment);

    double getSumSalaryForDepartment(Integer departmentId);

    Employee getMaxSalaryForDepartment(Integer departmentId);

    Employee getMinSalaryForDepartment(Integer departmentId);

    String getMap();
}
