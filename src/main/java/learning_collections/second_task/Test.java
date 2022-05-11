package learning_collections.second_task;

public class Test {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("Иванов", "123123");
        book.add("Иванов", "321321");
        System.out.println(book.get("Иванов"));
    }
}
