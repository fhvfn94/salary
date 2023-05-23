package com.salary.salary.Domain;

import java.util.Objects;

public class Employee {
    public static int counter = 1;
    private final String name;
    private final String surName;
    private final String patronymicName;
    private Double salary;
    private Integer department;
    private final int id;



    public Employee(String name, String surName, String patronymicName, Double salary, Integer department) {
        id = counter++;
        this.name = name;
        this.surName = surName;
        this.patronymicName = patronymicName;
        this.salary = salary;
        this.department = department;
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

    public String getPatronymicName() {
        return patronymicName;
    }

    public int getId() {
        return id;
    }

    public Integer getDepartment() {
        return department;
    }
    public Double getSalary() {
        return salary;
    }
}
