package learning_generics;

import java.util.Arrays;
import java.util.Random;

public class LearningGenerics {
    public static void main(String[] args) {
        String[] array = {" Андрей", "Привет"};
        swapArrayElements(array);
        System.out.println(Arrays.toString(array));
    }

    public static <T extends Object> void swapArrayElements(T[] array) {
        int firstIndex;
        int secondIndex;
        do {
            Random random = new Random();
            firstIndex = random.nextInt(array.length);
            secondIndex = random.nextInt(array.length);
        } while (firstIndex == secondIndex);
        T t = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = t;
    }
}
