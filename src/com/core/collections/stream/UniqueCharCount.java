package com.core.collections.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharCount {
    public static void main(String[] args) {

        String str = "hello";
        Map<Character, Long> charCountMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMap);
        Map<Character, Long > charMap = str.chars().mapToObj(c -> (char)c).collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println(charMap);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ricky", 30, 30000, "IT"));
        employeeList.add(new Employee("Glen", 35, 45000, "HR"));
        employeeList.add(new Employee("James", 24, 20000, "Finance"));
        employeeList.add(new Employee("Tom", 40, 35000, "IT"));
        employeeList.add(new Employee("Jim", 24, 25000, "HR"));
        employeeList.add(new Employee("Ricky", 30, 50000, "IT"));
        employeeList.add(new Employee("Glen", 35, 25000, "HR"));
        employeeList.add(new Employee("James", 24, 20000, "Finance"));
        employeeList.add(new Employee("Tom", 40, 45000, "IT"));
        employeeList.add(new Employee("Jim", 24, 25000, "HR"));
        employeeList.add(new Employee("Ricky", 30, 30000, "IT"));
        employeeList.add(new Employee("Glen", 35, 28000, "HR"));
        employeeList.add(new Employee("James", 24, 40000, "Finance"));

        Map<String, Double> map = employeeList.stream().collect(Collectors.toMap(Employee::getDepartment, Employee::getSalary, Double::max));
        System.out.println(map);
        Map<Integer, List<String>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(collect);
        Map<String, List<String>> departmentMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(departmentMap);

        List<Person> people = Arrays.asList(
                new Person("John", "USA", "New York"),
                new Person("Paul", "USA", "Los Angeles"),
                new Person("George", "UK", "London"),
                new Person("Mark", "UK", "London"),
                new Person("Ringo", "UK", "Liverpool")
        );

        Map<String, Map<String, List<Person>>> countryMap = people.stream().collect(Collectors.toMap(Person::getCountry, person -> new HashMap<>(Map.of(person.getCity(), List.of(person))), (m1, m2) -> {
            m1.forEach((name, personList) -> {
                m2.merge(name, personList, (list1, list2) -> {
                    System.out.println("*******************");
                    System.out.println("Merging " + name + " and " + personList);
                    System.out.print("Merging " + list1 + " and " + list2);
                    System.out.println();
                    System.out.println("*******************");
                    List<Person> combinedList = new ArrayList<>(list1);
                    combinedList.addAll(list2);
                    return combinedList;
                });
            });
            return m2;
        }));
        System.out.println(countryMap);
        Map<String, List<Person>> countryMap1 = people.stream().collect(Collectors.groupingBy(Person::getCountry));
        System.out.println(countryMap1);
    }
}

class Employee {

    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

class Person {
    String name;
    String country;
    String city;

    Person(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return name;
    }
}