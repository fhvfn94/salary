package com.salary.salary.Stream.service;

import com.salary.salary.Stream.module.Employee;
import com.salary.salary.Stream.repository.RepEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements DepartmentServiceInt {

    private final RepEmployee repEmployee;

    public DepartmentService(RepEmployee repEmployee) {
        this.repEmployee = repEmployee;
    }

    @Override
    public String add(Integer idDepartment, Employee employee) {
        return repEmployee.add(idDepartment, employee);
    }

    @Override
    public String remove(Integer idDepartment, Employee employee) {
        return repEmployee.remove(idDepartment, employee);
    }

    @Override
    public Employee find(Integer idDepartment, String name, String surName) {
        return repEmployee.find(idDepartment, name, surName);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Integer idDepartment) {
        return repEmployee.getAllEmployeesByDepartment(idDepartment);
    }

    @Override
    public double getSumSalaryForDepartment(Integer departmentId) {
        return repEmployee.getSumSalaryForDepartment(departmentId);
    }

    @Override
    public Employee getMaxSalaryForDepartment(Integer departmentId) {
        return repEmployee.getMaxSalaryForDepartment(departmentId);
    }

    @Override
    public Employee getMinSalaryForDepartment(Integer departmentId) {
        return repEmployee.getMinSalaryForDepartment(departmentId);
    }
    @Override
    public String getMap() {
        return repEmployee.getMap();
    }
}
