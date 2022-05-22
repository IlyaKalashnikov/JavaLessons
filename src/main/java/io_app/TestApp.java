package io_app;

import io_app.repository.Employee;
import io_app.repository.EmployeeRepository;
import io_app.service.EmployeeService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\79657\\Documents\\Java занятия\\IO_Repository\\repository.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        EmployeeService service = new EmployeeService(new EmployeeRepository(file));


        List<Employee> checkList = new ArrayList<>(service.getAll());
        for (int i = 0; i < checkList.size(); i++) {
            System.out.println(Employee.splitByColumn(checkList.get(i)));
        }
    }
}

