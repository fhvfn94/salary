package com.salary.salary.Stream.repository;
import com.salary.salary.Stream.module.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class RepEmployee {
    private final Integer idDepartment1 = 1;
    private final Integer idDepartment2 = 2;
    private final Integer idDepartment3 = 3;
    private final Integer idDepartment4 = 4;
    private final Map<Integer, List<Employee>> map = new HashMap<>();
    @PostConstruct
    public void base() {
        map.put(idDepartment1, new ArrayList<Employee>(List.of(
                new Employee("Петр", "Петрович", idDepartment1, 10.0),
                new Employee("Владимир", "Владимирович", idDepartment1, 11.0),
                new Employee("Евгений", "Евгеньевич", idDepartment1, 12.0),
                new Employee("Ян", "Янович", idDepartment1, 13.0)
        )));
        map.put(idDepartment2, new ArrayList<Employee>(List.of(
                new Employee("Алла", "Алловна", idDepartment2, 14.0),
                new Employee("Ольга", "Ольговна", idDepartment2, 15.0),
                new Employee("Яна", "Яновна", idDepartment2, 16.0),
                new Employee("Марина", "Мариновна", idDepartment2, 17.0)
        )));
        map.put(idDepartment3, new ArrayList<Employee>(List.of(
                new Employee("Игорь", "Игоревич", idDepartment3, 18.0),
                new Employee("Алексей", "Алексеевич", idDepartment3, 19.0),
                new Employee("Нина", "Нинович", idDepartment3, 20.0),
                new Employee("Мария", "Мариевич", idDepartment3, 21.0)
        )));
        map.put(idDepartment3, new ArrayList<Employee>(List.of(
                new Employee("Игорь", "Игоревич", idDepartment3, 22.0),
                new Employee("Алексей", "Алексеевич", idDepartment3, 23.0),
                new Employee("Нина", "Нинович", idDepartment3, 24.0),
                new Employee("Мария", "Мариевич", idDepartment3, 25.0)
        )));
        map.put(idDepartment4, new ArrayList<Employee>(List.of(
                new Employee("Антон", "Антонов", idDepartment4, 26.0),
                new Employee("Артур", "Артуров", idDepartment4, 27.0),
                new Employee("Лида", "Лидовна", idDepartment4, 28.0),
                new Employee("Лариса", "Ларисовна", idDepartment4, 29.0)
        )));
    }
// в методе add почему то могу не ограниченное количество одинаковых значений создавать
    public String add(Integer idDepartment, Employee employee) {
        List<Employee> employees = map.get(idDepartment);
        if (employees != null && !employees.contains(employee)) {
            map.get(employee.getDepartment()).add(new Employee(
                    employee.getName(),
                    employee.getSurName(),
                    employee.getDepartment(),
                    employee.getSalary()
            ));
            return "Новый сотрудник добавлен " + employee.getName() +  " " + employee.getSurName();
        }
        return "Сотрудник уже существует в данном отделе";
    }

    public String remove(Integer idDepartment, Employee employee) {
        List<Employee> employees = map.get(idDepartment);
        if (employees.contains(employee)) {
            map.get(employee.getDepartment()).remove(employee);
            return "Сотрудник " + employee.getName() + " " + employee.getSurName() + " удален из департамента " + employee.getDepartment();
        }
        return "Такого сотрудника нет";
    }

    public Employee find(Integer idDepartment, String name, String surName) {
        List<Employee> employees = map.get(idDepartment);
        Optional<Employee> findEmployee = employees.stream()
                .filter(it -> it.getName().equals(name) && it.getSurName().equals(surName))
                .findFirst();
        return findEmployee.orElseThrow(()-> new NoSuchElementException("Сотрудник не найден"));

    }

    public List<Employee> getAllEmployeesByDepartment(Integer idDepartment) {
        return map.get(idDepartment);
    }

    public double getSumSalaryForDepartment(Integer departmentId) {
        double sumSalary = map.get(departmentId).stream()
                .mapToDouble(it -> it.getSalary())
                .sum();
        return sumSalary;
    }

    public Employee getMaxSalaryForDepartment(Integer departmentId) {
        Optional<Employee> maxSalary = map.get(departmentId).stream()
                .max((it1, it2) -> Double.compare(it1.getSalary(), it2.getSalary()));
        return maxSalary.orElseThrow();
    }

    public Employee getMinSalaryForDepartment(Integer departmentId) {
        Optional<Employee> minSalary = map.get(departmentId).stream()
                .min((it1, it2) -> Double.compare(it1.getSalary(), it2.getSalary()));
        return minSalary.orElseThrow();
    }

    public String getMap() {
        return map.toString();
    }
}
