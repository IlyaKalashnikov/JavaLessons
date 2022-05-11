package learning_collections.second_task;

import java.util.*;

/**
 * Написать простой класс Телефонный Справочник,
 * который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи,
 * а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneBook {

    private Map<String, List<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(String surname, String number) {
        if (!book.containsKey(surname)) {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(number);
            book.put(surname, phoneNumbers);
        } else {
            book.get(surname).add(number);
        }
    }
        public List<String> get(String surname){
            return book.get(surname);
        }
    }


