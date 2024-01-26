package Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employees2 {
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
        employee1.put("name", "Кирилл");
        employee1.put("age", "26");
        employee1.put("position", "Middle java dev");
        employee1.put("salary", "150000 руб");
        employeeList.add(employee1);

        Map<String, String> employee2 = new HashMap<>();
        employee2.put("name", "Виталий");
        employee2.put("age", "28");
        employee2.put("position", "Senior java automation QA");
        employee2.put("salary", "2000$");
        employeeList.add(employee2);

        Map<String, String> employee3 = new HashMap<>();
        employee3.put("name", "Александр");
        employee3.put("age", "31");
        employee3.put("position", "junior functional tester");
        employee3.put("salary", "50000 руб");
        employeeList.add(employee3);

        Map<String, String> employee4 = new HashMap<>();
        employee4.put("name", "Дементий");
        employee4.put("age", "35");
        employee4.put("position", "dev-ops");
        employee4.put("salary", "1500$");
        employeeList.add(employee4);
    }

    private static List<String> namesEmployeesUnder30(List<Map<String, String>> employeeList) {

        return employeeList.stream()
                .filter(n -> Integer.parseInt(n.get("age")) < 30)
                .map(n2 -> n2.get("name"))
                .collect(Collectors.toList());
    }

    private static List<String> namesEmployeesSalaryRubles(List<Map<String, String>> employeeList) {
        return employeeList.stream()
                .filter(n -> n.get("salary").contains("руб"))
                .map(n2 -> n2.get("name"))
                .collect(Collectors.toList());
    }

    private static int averageAgeEmployees(List<Map<String, String>> employeeList) {
        return (int) employeeList.stream()
                .mapToInt(n -> Integer.parseInt(n.get("age")))
                .average()
                .orElse(0);
    }


}

