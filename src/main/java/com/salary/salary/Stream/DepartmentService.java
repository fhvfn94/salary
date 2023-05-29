package com.salary.salary.Stream;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInt {
    private List<Employee> staff = new ArrayList<>();
    private final ValidatorService validatorServices;
    private String name;
    private String surName;

    public DepartmentService(ValidatorService validatorServices) {
        this.validatorServices = validatorServices;
    }


    public Employee add(String name, String surName) {
        Employee employee = new Employee(validatorServices.validateName(name), validatorServices.validateSurname(surName));
    }

    @Override
    public Employee findEmployeeWithMaxSalaryForDepartment(Integer departmentId) {
        Optional<Employee> maxSalary = staff.stream()
                .filter(it -> Objects.equals(it.getDepartment(), departmentId))
                .max((m1, m2) -> m1.getSalary().compareTo(m2.getSalary()));
        return maxSalary.orElseThrow(RuntimeException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalaryForDepartment(Integer departmentId) {
        Optional<Employee> minSalary = staff.stream()
                .filter(it -> Objects.equals(it.getDepartment(), departmentId))
                .min((m1, m2) -> m1.getSalary().compareTo(m2.getSalary()));
        return minSalary.orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Employee> findEmployeeByDepartment(Integer departmentId) {
        return staff.stream()
                .filter(it -> Objects.equals(it.getDepartment(), departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findEmployeeSortByDepartment() {
        return staff.stream()
                .sorted((it1, it2) -> it1.getDepartment().compareTo(it2.getDepartment()))
                .collect(Collectors.toList());
    }

}
