package com.salary.salary.Domain;

import com.salary.salary.Service.EmployeeService;

import java.util.*;

public class EmployeeBook {
    private final Map<String, Employee> employees;


    public EmployeeBook() {
        employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getName() + " " + employee.getSurName() + " " + employee.getPatronymicName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String name,
                            String surName,
                            String patronymicName,
                            double salary,
                            int department) {
        addEmployee(new Employee(name, surName, patronymicName, salary, department));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            String key = entry.getKey();
            if (employee.getId() == id) {
                employees.remove(key);
                break;
            }
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(getKey(key)).setSalary(newSalary);
        }
    }

    public void changeDepartment() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудники из отдела " + department + ":");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                    System.out.println(employee.getSurName() + " " + employee.getName() + " " + employee.getPatronymicName());
                }
            }
        }

    }

    public void printEmployeesWithSalaryLessThen(double bound) {
        System.out.println("Сотрудник с ЗП меньшей чем " + bound + ":");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() < bound) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSurName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                );
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public double averageSalary() {
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                count++;
            }
        }
        if (count != 0) {
            return totalSalaries / count;
        }
        return 0;
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryForDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMaxSalaryForDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public double totalSalariesForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printFullNameEmployees() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(
                        employee.getName() + " " +
                                employee.getSurName() + " " +
                                employee.getPatronymicName()
                );
            }
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployeesForDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSurName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                );
            }
        }
    }

   /* private Map<String, Employee> staff = new HashMap<>();
    private Map<Integer, String> idToName = new HashMap<>();

    public void hireEmployee(Employee employee) {
        staff.put(employee.getFullName(), employee);
        idToName.put(employee.getId(), employee.getFullName());
    }

    public void fireEmployee(String fullName) {
        if (staff.containsKey(fullName)) {
            staff.remove(fullName);
        } else {
            System.out.println("There is no such employee");
        }
    }

    public void fireEmployee(int id) {
        if (idToName.containsKey(id)) {
            staff.remove(idToName.get(id));
        }
    }

    public void changeDepartment(String fullName, int newDepartmentNumber) {
        if (staff.containsKey(fullName)) {
            staff.get(fullName).setDepartment(newDepartmentNumber);
        } else {
            System.out.println("There is no such employee");
        }
    }

    public void changeSalary(String fullName, double salary) {
        if (staff.containsKey(fullName)) {
            staff.get(fullName).setSalary(salary);
        } else {
            System.out.println("There is no such employee");
        }
    }

    public void showAllEmployee() {
        for (Employee employee : staff.values()) {
            System.out.println(employee);
        }
    }*/
}
