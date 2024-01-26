/*
Имя      |Возраст|Должность                |Зарплата
Кирилл   |  26   |Middle java dev          |150000 руб
Виталий  |  28   |Senior java automation QA|2000$
Александр|  31   |junior functional tester |50000 руб
Дементий |  35   |dev-ops                  |1500$

Данная таблица представлена в формате List<Map<String,String>>,
где каждый элемент list - строка, key в map - название столбца, value в map - значение ячейки

 */


package Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employees {
    public static void main(String[] args) {
        List<Map<String, String>> employeeList = new ArrayList<>();
        fillEmployeeList(employeeList);

        List<String> specialEmployees = namesEmployeesUnder30(employeeList);
        System.out.println("Имена сотрудников, младше 30: " + specialEmployees);

        specialEmployees = namesEmployeesSalaryRubles(employeeList);
        System.out.println("Имена сотрудников, получающих зарплату в рублях: " + specialEmployees);

        System.out.println("Средний возраст всех сотрудников: " + averageAgeEmployees(employeeList));
    }

    private static void fillEmployeeList(List<Map<String, String>> employeeList) {
        Map<String, String> employee1 = new HashMap<>();
        employee1.put("name", "Êèðèëë");
        employee1.put("age", "26");
        employee1.put("position", "Middle java dev");
        employee1.put("salary", "150000 ðóá");
        employeeList.add(employee1);

        Map<String, String> employee2 = new HashMap<>();
        employee2.put("name", "Âèòàëèé");
        employee2.put("age", "28");
        employee2.put("position", "Senior java automation QA");
        employee2.put("salary", "2000$");
        employeeList.add(employee2);

        Map<String, String> employee3 = new HashMap<>();
        employee3.put("name", "Àëåêñàíäð");
        employee3.put("age", "31");
        employee3.put("position", "junior functional tester");
        employee3.put("salary", "50000 ðóá");
        employeeList.add(employee3);

        Map<String, String> employee4 = new HashMap<>();
        employee4.put("name", "Äåìåíòèé");
        employee4.put("age", "35");
        employee4.put("position", "dev-ops");
        employee4.put("salary", "1500$");
        employeeList.add(employee4);
    }

    private static List<String> namesEmployeesUnder30(List<Map<String, String>> employeeList) {
        List<String> specialEmployees = new ArrayList<>();
        for (Map<String, String> employee : employeeList) {
            int ageEmployee = Integer.parseInt(employee.get("age"));
            if (ageEmployee < 30) {
                specialEmployees.add(employee.get("name"));
            }
        }
        return specialEmployees;
    }

    private static List<String> namesEmployeesSalaryRubles(List<Map<String, String>> employeeList) {
        List<String> specialEmployees = new ArrayList<>();
        for (Map<String, String> employee : employeeList) {
            String salary = employee.get("salary");
            if (salary != null && salary.contains("ðóá")) {
                specialEmployees.add(employee.get("name"));
            }
        }
        return specialEmployees;
    }

    private static int averageAgeEmployees(List<Map<String, String>> employeeList) {
        int ageEmployee = 0;

        for (Map<String, String> employee : employeeList) {
            ageEmployee += Integer.parseInt(employee.get("age"));
        }

        return ageEmployee / employeeList.size();
    }


}

