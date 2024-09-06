package com.core.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ToMapExamples {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(getUser(101, "Ryan", 8000, "Consultant"));
        users.add(getUser(102, "Madison", 10000, "Manager"));
        users.add(getUser(101, "Kimberly", 9000, "Associate"));
        users.add(getUser(101, "Philip", 7500, "Associate Consultant"));
        users.add(getUser(101, "Philip", 9000, "Associate"));
        users.add(getUser(101, "Betty", 7600, "Associate Consultant"));
        users.add(getUser(101, "Matt", 7600, "Associate Consultant"));

        double max = users.stream().map(User::getSalary).max(Comparator.comparingDouble(Double::doubleValue)).orElse(0d);

        System.out.println("max:\n"+max);

        Map<String, String> designationMap = users.stream().collect(Collectors.toMap(User::getDesignation, User::getName, (name1, name2) -> name1));
        System.out.println("designationMap:\n"+designationMap);

        Map<String, Double> maxSalaryByName = users.stream().collect(Collectors.toMap(User::getName, User::getSalary, BinaryOperator.maxBy(Comparator.comparingDouble(Double::doubleValue))));
        Map<String, Double> maxSalaryByDesignation = users.stream().collect(Collectors.toMap(User::getDesignation, User::getSalary, Math::max, ConcurrentHashMap::new));
        System.out.println("maxSalaryByName:\n"+maxSalaryByName);
        System.out.println("maxSalaryByDesignation:\n"+maxSalaryByDesignation);

        Map<String, List<User>> maxSalariedEmployees = maxSalaryByDesignation.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> users.stream().filter(user -> user.getDesignation().equals(entry.getKey()) && user.getSalary() == entry.getValue()).collect(Collectors.toList())));
        Map<String, List<User>> maxSalariedEmployeesByName = maxSalaryByName.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> users.stream().filter(user -> user.getName().equals(entry.getKey()) && user.getSalary() == entry.getValue()).collect(Collectors.toList())));

        System.out.println("maxSalariedEmployees:\n"+maxSalariedEmployees);
        System.out.println("maxSalariedEmployeesByName:\n"+maxSalariedEmployeesByName);

    }

    static User getUser(final int id, final String name, final double salary, final String designation) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSalary(salary);
        user.setDesignation(designation);
        return user;
    }
}

class User {
    private int id;
    private String name;
    private double salary;
    private String designation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String toString() {
        return "Name:\t"+ this.name + "\tSalary:\t"+ this.salary + "\tDesignation:\t"+ this.designation;
    }
}
