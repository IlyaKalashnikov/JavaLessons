package io_app_test.service;

import io_app.exceptions.AlreadyExistException;
import io_app.exceptions.NoSuchEmployeeException;
import io_app.repository.Employee;
import io_app.repository.EmployeeRepository;
import io_app.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    Path path;
    File file;

    Employee testEmployee = new Employee(1l, "Ivan", 20, 20000);
    Employee testEmployee1 = new Employee(2l, "Ivan", 21, 21000);

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        try {
            path = tempDir.resolve("testFile.csv");
        } catch (InvalidPathException e) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName());
        }
        file = path.toFile();
    }

    @Test
    void addMethod_shouldAddEmployee() throws IOException {
        EmployeeRepository repository = new EmployeeRepository(file);
        EmployeeService serviceTest = new EmployeeService(repository);
        serviceTest.add(testEmployee);

        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(testEmployee);
        List<Employee> actualList = repository.getAll();

        Assertions.assertTrue(expectedList.size() == actualList.size()
                && expectedList.containsAll(actualList)
                && actualList.containsAll(expectedList));
    }

    @Test
    void addMethod_shouldThrowAlreadyExistException() throws IOException {

        EmployeeRepository repository = new EmployeeRepository(file);
        EmployeeService serviceTest = new EmployeeService(repository);
        serviceTest.add(testEmployee);

        Assertions.assertThrows(AlreadyExistException.class, () -> {
            serviceTest.add(testEmployee);
        });
    }

    @Test
    void removeMethod_shouldDeleteEmployeeFromFile() throws IOException {

        EmployeeRepository repository = new EmployeeRepository(file);
        EmployeeService serviceTest = new EmployeeService(repository);
        serviceTest.add(testEmployee);
        serviceTest.add(testEmployee1);

        serviceTest.remove(2l);

        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(testEmployee);
        List<Employee> actualList = new ArrayList<>(repository.getAll());

        Assertions.assertTrue(expectedList.size() == actualList.size()
                && expectedList.containsAll(actualList)
                && actualList.containsAll(expectedList));
    }

    @Test
    void removemethod_shouldThrowNSExceptionIfNoSuchEmployee() throws IOException {
        EmployeeRepository repository = new EmployeeRepository(file);
        EmployeeService serviceTest = new EmployeeService(repository);
        serviceTest.add(testEmployee);

        Assertions.assertThrows(NoSuchEmployeeException.class, ()-> {
                    serviceTest.remove(2l);});
    }
}
