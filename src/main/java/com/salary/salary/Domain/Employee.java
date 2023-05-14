package com.salary.salary.Domain;

import java.util.Objects;

public abstract class Employee {
    public static int counter = 1;
    private final String name;
    private final String surName;
    private final String patronymicName;
    private double salary;
    private int department;
    private final int id;

    public Employee(String name, String surName, String patronymicName, double salary, int department) {
        id = counter++;
        this.name = name;
        this.surName = surName;
        this.patronymicName = patronymicName;
        this.salary = salary;
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
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

    public int getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
}
