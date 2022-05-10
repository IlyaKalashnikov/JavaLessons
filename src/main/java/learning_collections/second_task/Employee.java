package learning_collections.second_task;

import java.util.Objects;

public class Employee {
    private final String surname;
    private final Integer phoneNumber;

    public Employee(String surname, Integer phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return surname.equals(employee.surname) && phoneNumber.equals(employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, phoneNumber);
    }
}
