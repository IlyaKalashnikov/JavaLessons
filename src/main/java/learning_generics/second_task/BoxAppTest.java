package learning_generics.second_task;
import java.util.ArrayList;

public class BoxAppTest {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new ArrayList<>());
        Box<Orange> orangeBox = new Box<>(new ArrayList<>());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        Box<Orange> orangeBox1 = new Box<>(new ArrayList<>());
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        System.out.println(orangeBox.getFruits().size());
        System.out.println(orangeBox1.getFruits().size());
        appleBox.addFruit(new Apple());
    }


}
