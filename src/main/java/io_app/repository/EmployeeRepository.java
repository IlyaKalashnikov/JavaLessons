package io_app.repository;

import java.io.*;
import java.util.*;

public class EmployeeRepository {

    private File file;

    public EmployeeRepository(File file) {
        this.file = file;
    }

    public void add(Employee e) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            bufferedWriter.write(Employee.splitByColumn(e));
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void overwriteRepository(List<Employee> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (Employee e : list) {
                bufferedWriter.write(Employee.splitByColumn(e));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] columns = line.split(";");

                Long id = Long.parseLong(columns[0]);
                String name = columns[1];
                Integer age = Integer.parseInt(columns[2]);
                Double salary = Double.parseDouble(columns[3]);

                employees.add(new Employee(id, name, age, salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
