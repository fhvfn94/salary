package com.salary.salary.Service;

import com.salary.salary.Domain.Employee;
import com.salary.salary.exception.EmployeeAlreadyAddedException;
import com.salary.salary.exception.EmployeeNotFoundException;
import com.salary.salary.exception.EmployeeStorageIsFullException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class ListEmployeeService implements EmployeeService {
    private final static int CAPACITY = 10;
    List<Employee> staff = new ArrayList<>();

    @Override
    public Employee addEmployee(String name, String surName, String patronymicName, double salary, int department) {
        if (staff.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        Employee temp = new Employee(name, surName, patronymicName, salary, department);
        if (staff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }
        staff.add(temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String name, String surName, String patronymicName, double salary, int department) {
        int index = staff.indexOf(new Employee(name, surName, patronymicName, salary, department));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return staff.remove(index);
    }

    @Override
    public Employee findEmployee(String name, String surName, String patronymicName, double salary, int department) {
        int index = staff.indexOf(new Employee(name, surName, patronymicName, salary, department));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return staff.get(index);
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
