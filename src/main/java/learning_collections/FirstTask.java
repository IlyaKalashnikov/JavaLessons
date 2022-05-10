package learning_collections;

import java.util.*;

public class FirstTask {
    /**
     * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
     * Посчитать, сколько раз встречается каждое слово.
     */
    public static void main(String[] args) {
        String[] arr = {"Winter", "Spring", "Summer", "Winter", "Spring", "Summer",
                "Autumn", "Winter", "Spring", "Summer", "Autumn", "Winter", "Spring", "Summer", "Autumn", "Orange"};

        Map<String, Integer> wordsAndFrequency = new HashMap<>();
        for (String s: arr) {
            int frequency = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equalsIgnoreCase(s)) {
                    frequency++;
                }
            }
            wordsAndFrequency.put(s, frequency);
        }
        System.out.println(wordsAndFrequency);

        Map<String, Integer> wordsAndFrequencyNew = new HashMap<>();
        for (String s: arr) {
            wordsAndFrequencyNew.put(s, Collections.frequency(Arrays.asList(arr), s));
        }
        System.out.println(wordsAndFrequencyNew);
    }
}