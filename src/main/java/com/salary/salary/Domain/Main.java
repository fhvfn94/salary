package com.salary.salary.Domain;

public class Main {
    public static void main(String[] args) {
        EmployeeBook = EmployeeBook = new EmployeeBook();
        Employee alex = new Employee("Алексей", "Козлов", 45000, 2);
        EmployeeBook.addEmployee("Петр", "Романов", 52000, 1);
        EmployeeBook.addEmployee(alex);
        EmployeeBook.changeSalary(alex, 42000);
        EmployeeBook.printEmployeeByDepartment();
        EmployeeBook.printAllEmployee();
        double totalSalaries = EmployeeBook.totalSalaries();
        System.out.println("Сумма ЗП всех сотрудников за месяц: %.3f%n", totalSalaries);
        Employee employeeWithMinSalary = EmployeeBook.findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = EmployeeBook.findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП " + employeeWithMinSalary);
        double averageSalary = EmployeeBook.averageSalary();
        System.out.println("Средняя ЗП всех сотрудников за месяц: %.3f%n", averageSalary);
        EmployeeBook.indexSalaries();
        System.out.println("После индексации");
        EmployeeBook.printAllEmployee();
        System.out.println("Сотрудник с минимальной ЗП из %d отдела %s%n ", 1, EmployeeBook.employeeWithMinSalaryFromDepartment(1));
        System.out.println("Сотрудник с максимальной ЗП из %d отдела %s%n ", 1, EmployeeBook.employeeWithMaxSalaryFromDepartment(2));
        System.out.println("Сумма ЗП всех сотрудников за месяц из отдела %d отдела %.2f%n ", 3, EmployeeBook.totalSalariesForDepartment(3));
        System.out.println("Средняя ЗП всех сотрудников за месяц из отдела %d отдела %.3f%n ", 4, EmployeeBook.averageSalaryForDepartment(4));
        EmployeeBook.indexSalariesForDepartment(5, 1);
        System.out.println("После индексации для отдела " + 1);
        EmployeeBook.printAllEmployeesForDepartment(1);
        EmployeeBook.printEmployeesWithSalaryLessThan(55000);
        EmployeeBook.printEmployeesWithSalaryGreaterEqualThan(55000);
    }
}
