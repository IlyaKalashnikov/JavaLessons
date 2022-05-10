package learning_collections.second_task;

import java.util.*;

public class PhoneBook {
    /**
     * Написать простой класс Телефонный Справочник,
     * который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи,
     * а с помощью метода get() искать номер телефона по фамилии.
     * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
     * тогда при запросе такой фамилии должны выводиться все телефоны.
     */

    private Map<Employee, Integer> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(Employee e) {
        book.put(e, e.getPhoneNumber());
    }

    public void get(String s) {
        for (Map.Entry<Employee, Integer> entry : book.entrySet()) {
            if (entry.getKey().getSurname().equalsIgnoreCase(s))
                System.out.println(entry.getKey().getSurname() + ": " + entry.getValue());
        }
    }

    public Map<Employee, Integer> getBook() {
        return book;
    }
}


