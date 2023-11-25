package ru.gb;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1, 1_000_000))
                .limit(1_000)
                .toList();

        // 1.1. Найти максимальное
        System.out.print("1.1. Максимальное число из списка: ");
        list.stream()
                .max((o1, o2) -> o1 - o2)
                .ifPresent(System.out::println);

        // 1.2. Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.print("1.2. Все числа, большие, чем 500 000, умножить на 5, отнять от них 150 и просуммировать: ");
        System.out.println(
                list.stream()
                        .filter(x -> x > 500_000)
                        .map(x -> x * 5 - 150)
                        .mapToInt(Integer::intValue)
                        .sum()
        );

        // 1.3. Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.print("1.3. Количество чисел, квадрат которых меньше, чем 100 000: ");
        System.out.println(
                list.stream()
                        .filter(x -> x * x < 100_000)
                        .count()
        );
        System.out.println();

        // 2.1. Создать список из 10-20 сотрудников
        List<Employee> employees = List.of(
                new Employee("Vasya", 35, 100000, "purchase"),
                new Employee("Nastya", 28, 90000, "accounting"),
                new Employee("Vasilisa", 32, 95000, "human resources"),
                new Employee("Petya", 22, 5000, "delivery"),
                new Employee("Yana", 21, 9000, "accounting"),
                new Employee("Kostya", 33, 50000, "purchase"),
                new Employee("Denis", 23, 8500, "human resources"),
                new Employee("Kolya", 22, 15000, "delivery"),
                new Employee("Oleg", 37, 150000, "development"),
                new Employee("Marina", 33, 140000, "development")
                );

        // 2.2. Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println("2.2. Список всех отделов:");
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // 2.3. Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream()
                .filter(employee -> employee.getSalary() < 10000)
                .forEach(employee -> employee.setSalary(employee.getSalary() * 1.2));
        // выведем список сотрудников с зарплатами, чтобы убедиться в повышении зарплат
        System.out.println();
        System.out.println("2.3 Список сотрудников с зарплатами после их повышения:");
        employees.forEach(employee -> System.out.println(employee.getName() + ".  Salary: " + employee.getSalary()));

        // 2.4*. Из списка сотрудников с помощью стрима создать Map<String, List> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.toList()
                ));
        System.out.println();
        System.out.println("2.4*. Map<String, List> с отделами и сотрудниками внутри отдела:");
        employeesByDepartment.forEach((department, employeeList) ->
                System.out.println("Department: " + department + ".  " + employeeList));

        // 2.5*. Из списка сотрудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> departmentsWithAverageSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println();
        System.out.println("2.5*. Map<String, Double> с отделами и средней зарплатой внутри отдела");
        departmentsWithAverageSalary.forEach((department, averageSalary) ->
                System.out.println("Department: " + department + ".  Average salary: " + averageSalary));
    }
}