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

    private Map<Integer,Employee> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(Employee e) {
        book.put(e.getPhoneNumber(), e);
    }

    public void get(String s){
        for (Map.Entry<Integer, Employee> entry : book.entrySet()) {
            if (entry.getValue().getSurname().equalsIgnoreCase(s)){
                System.out.println(entry.getValue());
        }
        }
    }
}


