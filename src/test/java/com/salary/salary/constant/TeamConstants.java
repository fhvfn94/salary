package com.salary.salary.constant;

import com.salary.salary.Stream.module.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamConstants {
    private static final Integer idDepartment1 = 1;
    private static final Integer idDepartment2 = 2;
    private static final Integer idDepartment3 = 3;
    private static final Integer idDepartment4 = 4;
    public static final Map<Integer, List<Employee>> TEST_MAP = new HashMap<>(
            Map.of(
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
                            new Employee("Игорь", "Игоревич", idDepartment3, 18.0),
                            new Employee("Алексей", "Алексеевич", idDepartment3, 19.0),
                            new Employee("Нина", "Нинович", idDepartment3, 20.0),
                            new Employee("Мария", "Мариевич", idDepartment3, 21.0)
                    )),
                    idDepartment4, new ArrayList<Employee>(List.of(
                            new Employee("Антон", "Антонов", idDepartment4, 26.0),
                            new Employee("Артур", "Артуров", idDepartment4, 27.0),
                            new Employee("Лида", "Лидовна", idDepartment4, 28.0),
                            new Employee("Лариса", "Ларисовна", idDepartment4, 29.0)
                    ))
            )
    );

//    public static final String GOOD_PREFIX = "Tea";
//    public static final String BAD_PREFIX = "ABC";
//
//    public static final List<String> TEAM_LIST = List.of(
//            TEST_MAP,
//    );
}
