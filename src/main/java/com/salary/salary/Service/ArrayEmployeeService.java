package com.salary.salary.Service;

import com.salary.salary.Domain.Employee;
import com.salary.salary.exception.EmployeeAlreadyAddedException;
import com.salary.salary.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class ArrayEmployeeService implements EmployeeService {
    public static final int CAPACITY = 10;
    private Employee[] staff = new Employee[CAPACITY];
    private int currentSize = 0;
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (currentSize >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        Employee temp = new Employee(firstName, lastName);
        for (Employee emp: staff) {
            if (emp.equals(temp)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        staff[currentSize] = temp;
        currentSize++;
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }
}
