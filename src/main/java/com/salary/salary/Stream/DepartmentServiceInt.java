package com.salary.salary.Stream;

import java.util.List;

public interface DepartmentServiceInt {
    Employee findEmployeeWithMaxSalaryForDepartment(Integer departmentId);

    Employee findEmployeeWithMinSalaryForDepartment(Integer departmentId);

    List<Employee> findEmployeeByDepartment(Integer departmentId);

    List<Employee> findEmployeeSortByDepartment();
}
