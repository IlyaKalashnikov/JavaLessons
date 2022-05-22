package io_app.repository;

import java.util.Objects;

public class Employee {

    private final long id;
    private String name;
    private int age;
    private double salary;

    public Employee(long id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public static String splitByColumn(Employee e) {
        String employeeString = Long.toString(e.getId()) + ";"
                + e.getName() + ";"
                + Integer.toString(e.getAge()) + ";"
                + Double.toString(e.getSalary());
        return employeeString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
