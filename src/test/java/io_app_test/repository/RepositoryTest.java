package io_app_test.repository;

import io_app.repository.Employee;
import io_app.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class RepositoryTest {

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
    void addMethod_ShouldAddEmployee() throws IOException {

        EmployeeRepository repo = new EmployeeRepository(file);
        repo.add(testEmployee);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        reader.close();

        Assertions.assertEquals(Employee.splitByColumn(testEmployee), line);
    }

    @Test
    void getAllMethod_ShouldReturnEmployeeList(){

        EmployeeRepository repo = new EmployeeRepository(file);
        repo.add(testEmployee);
        repo.add(testEmployee1);

        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(testEmployee);
        expectedList.add(testEmployee1);

        List<Employee> actualList = repo.getAll();

        Assertions.assertTrue(expectedList.size() == actualList.size()
                && expectedList.containsAll(actualList)
                && actualList.containsAll(expectedList));
    }

    @Test
    void overWriteMethod_ShouldOverwriteExistingFile_WithImportedList() {

        EmployeeRepository repo = new EmployeeRepository(file);
        repo.add(testEmployee);

        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(testEmployee);
        expectedList.add(testEmployee1);
        repo.overwriteRepository(expectedList);

        List<Employee> actualList = repo.getAll();

        Assertions.assertTrue(expectedList.size() == actualList.size()
                && expectedList.containsAll(actualList)
                && actualList.containsAll(expectedList));
    }
}
