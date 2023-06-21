package com.salary.salary.Stream.module;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surName;
    private Double salary;
    private Integer department;



    public Employee(String name, String surName, Integer department, Double salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }


    public Integer getDepartment() {
        return department;
    }
    public Double getSalary() {
        return salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
