package learning_collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee {
    String name;
    String surname;
    Long id;

    public Employee(String name, String surname, Long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this + "equals with" + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(id);
        System.out.println("Hashcode: " + hash);
        return hash;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +
                '}';
    }

    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee("test","test",123L));
        set.add(new Employee("test","test",1234L));
        set.add(new Employee("test","test",1234L));
        set.add(new Employee("test","test",12345L));
    }
}
