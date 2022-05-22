package io_app.service;

import io_app.exceptions.AlreadyExistException;
import io_app.exceptions.NoSuchEmployeeException;
import io_app.repository.Employee;
import io_app.repository.EmployeeRepository;

import java.io.IOException;
import java.util.*;

public class EmployeeService {

    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void add(Employee employee) throws IOException {

        List<Employee> allEmployee = repository.getAll();

        if (!allEmployee.isEmpty()) {
            for (Employee e : allEmployee) {
                if (e.equals(employee)) {
                    throw new AlreadyExistException("Этот сотрудник уже есть в базе");
                }
            }
            repository.add(employee);
        } else {
            repository.add(employee);
        }
    }

    public void remove(Long id) throws IOException {

        List<Employee> employees = new ArrayList<>(repository.getAll());
        Employee exist = null;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getId() == id) {
                exist = employees.get(i);
                employees.remove(i);
            }
        }

        if (exist != null) {
            repository.overwriteRepository(employees);
        } else {
            throw new NoSuchEmployeeException("Такого сотрудника нет в базе.");
        }
    }

    public List<Employee> getAll() throws IOException {
        return repository.getAll();
    }

    public void sortById() throws IOException {
        List<Employee> employees = new ArrayList<>(repository.getAll());

        for (int i = 0; i < employees.size(); i++) {
            Employee biggerId = employees.get(i);
            for (int j = i + 1; j < employees.size(); j++) {
                Employee smallerId = employees.get(j);
                if (biggerId.getId() > smallerId.getId()) {
                    employees.set(i, smallerId);
                    employees.set(j, biggerId);
                }
            }
        }
        repository.overwriteRepository(employees);
    }

    public void sortByName() throws IOException {
        List<Employee> employeeList = new ArrayList<>(repository.getAll());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            names.add(i, employeeList.get(i).getName());
        }

        Collections.sort(names);

        for (int i = 0; i < employeeList.size(); i++) {

            Employee unordered;

            for (int j = 0; j < employeeList.size(); j++) {
                if (names.get(j).equalsIgnoreCase(employeeList.get(i).getName())) {
                    unordered = employeeList.get(j);
                    employeeList.set(j, employeeList.get(i));
                    employeeList.set(i, unordered);
                }
            }
        }

        repository.overwriteRepository(employeeList);
    }
}
