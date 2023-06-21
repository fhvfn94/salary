package com.salary.salary.service;

import com.salary.salary.Stream.module.Employee;
import com.salary.salary.Stream.repository.RepEmployee;
import com.salary.salary.Stream.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceImplTest {

    @Mock
    private RepEmployee repEmployee;

    @InjectMocks
    private DepartmentService departmentService;

    private static final Integer idDepartment1 = 1;
    private static final Integer idDepartment2 = 2;
    private static final Integer idDepartment3 = 3;
    private static final Integer idDepartment4 = 4;
    public static final Employee Employee = new Employee("Лев", "Львович", idDepartment1, 30.0);
    public static final Employee Employee1 = new Employee("Петр", "Петрович", idDepartment1, 10.0);
    public static final Employee Employee2 = new Employee("Руслан", "Русланов", idDepartment2, 30.0);

    @Test
    public void add() {
        when(repEmployee.add(idDepartment1, Employee))
                .thenReturn("Новый сотрудник добавлен " + Employee.getName() +  " " + Employee.getSurName());;
        String result = departmentService.add(idDepartment1, Employee);
        assertEquals("Новый сотрудник добавлен " + Employee.getName() +  " " + Employee.getSurName(), result);
        when(repEmployee.add(idDepartment1, Employee1))
                .thenReturn("Сотрудник уже существует в данном отделе");;
        String result1 = departmentService.add(idDepartment1, Employee1);
        // Проверяем, что результат соответствует ожидаемому значению
        assertEquals("Сотрудник уже существует в данном отделе", result1);
    }

    @Test
    public void find() {
        when(repEmployee.find(idDepartment1, Employee1.getName(), Employee1.getSurName()))
                .thenReturn(Employee1);
        Employee result = departmentService.find(idDepartment1, Employee1.getName(), Employee1.getSurName());
        assertEquals(Employee1, result);
        when(repEmployee.find(idDepartment2, Employee2.getName(), Employee2.getSurName()))
                .thenReturn(Employee2);
        Employee result1 = repEmployee.find(idDepartment2, Employee2.getName(), Employee2.getSurName());
        assertEquals(Employee2, result1);
    }
    private final Map<Integer, List<Employee>> map = new HashMap<>(Map.of(
            idDepartment1, new ArrayList<Employee>(List.of(
                    new Employee("Петр", "Петрович", idDepartment1, 10.0),
                    new Employee("Владимир", "Владимирович", idDepartment1, 11.0),
                    new Employee("Евгений", "Евгеньевич", idDepartment1, 12.0),
                    new Employee("Ян", "Янович", idDepartment1, 13.0)
            )),
            idDepartment2, new ArrayList<Employee>(List.of(
                    new Employee("Алла", "Алловна", idDepartment2, 14.0),
                    new Employee("Ольга", "Ольговна", idDepartment2, 15.0),
                    new Employee("Яна", "Яновна", idDepartment2, 16.0),
                    new Employee("Марина", "Мариновна", idDepartment2, 17.0)
            )),
            idDepartment3, new ArrayList<Employee>(List.of(
                new Employee("Игорь", "Игоревич", idDepartment3, 22.0),
                    new Employee("Алексей", "Алексеевич", idDepartment3, 23.0),
                    new Employee("Нина", "Нинович", idDepartment3, 24.0),
                    new Employee("Мария", "Мариевич", idDepartment3, 25.0)
            )),
            idDepartment4, new ArrayList<Employee>(List.of(
                new Employee("Антон", "Антонов", idDepartment4, 26.0),
                    new Employee("Артур", "Артуров", idDepartment4, 27.0),
                    new Employee("Лида", "Лидовна", idDepartment4, 28.0),
                    new Employee("Лариса", "Ларисовна", idDepartment4, 29.0)
            ))
    ));



    @Test
    public void findThrow() {
        when(repEmployee.find(idDepartment1, Employee.getName(), Employee.getSurName()))
                .thenThrow(new NoSuchElementException("Сотрудник не найден"));
/*        Employee result = departmentService.find(idDepartment1, Employee.getName(), Employee.getSurName());*/
//        Тут не понятно зачем было использовать пустое лямбдо-выражение
        assertThrows(NoSuchElementException.class, () -> departmentService.find(idDepartment1, Employee.getName(), Employee.getSurName()));
    }

    @Test
    public void remove() {
        when(repEmployee.remove(idDepartment1, Employee1))
                .thenReturn("Сотрудник " + Employee1.getName() + " " + Employee1.getSurName() + " удален из департамента " + Employee1.getDepartment());
        String result = departmentService.remove(idDepartment1, Employee1);

        when(repEmployee.remove(idDepartment1, Employee2))
                .thenReturn("Такого сотрудника нет");
        String result1 = departmentService.remove(idDepartment1, Employee2);
        assertEquals("Такого сотрудника нет", result1);
    }

    @Test
    public void getAllEmployeesByDepartment() {
        when(repEmployee.getAllEmployeesByDepartment(idDepartment2))
                .thenReturn(map.get(idDepartment2));
        List<Employee> result = departmentService.getAllEmployeesByDepartment(idDepartment2);
        assertEquals(repEmployee.getAllEmployeesByDepartment(idDepartment2), result);
    }

    @Test
    public void getSumSalaryForDepartment() {
        when(repEmployee.getSumSalaryForDepartment(idDepartment2))
                .thenReturn(110.0);
        Double result = departmentService.getSumSalaryForDepartment(idDepartment2);
        assertEquals(repEmployee.getSumSalaryForDepartment(idDepartment2), result);
    }

    @Test
    public void getMap() {
        when(repEmployee.getMap())
                .thenReturn(map.toString());
        String result = departmentService.getMap();
        assertEquals(repEmployee.getMap(), result);
    }




}