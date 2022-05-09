package learning_collections;

import java.util.*;

public class firstTask {
    /**
     * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
     * Посчитать, сколько раз встречается каждое слово.
     */
    public static void main(String[] args) {
        String[] arr = {"Winter", "Spring", "Summer", "Autumn", "Winter", "Spring", "Summer",
                "Autumn", "Winter", "Spring", "Summer", "Autumn", "Winter", "Spring", "Summer", "Autumn"};
        Set<duplicate> uniqueWords = new HashSet<duplicate>();
        Iterator<duplicate> it = uniqueWords.iterator();
        for (int i = 0; i < arr.length; i++) {
            uniqueWords.add(new duplicate(arr[i]));
            for (int j = 0; j < arr.length; j++) {
                if (it.next().name == arr[j]) {
                    it.next().frequency++;
                }
            }
        }
        System.out.println(uniqueWords);
    }
}

class duplicate {
    String name;
    Integer frequency = 1;

    public duplicate(String name, Integer frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public duplicate(String name) {
        this.name = name;
    }
}
