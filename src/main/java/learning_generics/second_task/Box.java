package learning_generics.second_task;

import java.util.ArrayList;

public class Box<Fruit> {
    ArrayList<Fruit> fruitBox;

    public Box(ArrayList<Fruit> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public ArrayList<Fruit> getFruits() {
        return fruitBox;
    }

    public void addFruit(Fruit fruit) {
        fruitBox.add(fruit);
    }

    public double getBoxWeight() {
        if (fruitBox.isEmpty()) {
            return 0.0;
        }
        double x = fruitBox.size() * 1.0;
        if (fruitBox.get(0).getClass() == Orange.class) {
            return x * 1.5;
        } else return x;
    }

    public <Fruit> boolean compareBoxes(ArrayList<Fruit> fruitBox) {
        double secondBoxWeight;
        double firstBoxWieght;
        if (this.fruitBox.get(0).getClass() == Orange.class) {
            firstBoxWieght = this.fruitBox.size() * 1.5;
        } else firstBoxWieght = this.fruitBox.size() * 1.0;
        if (fruitBox.get(0).getClass() == Orange.class) {
            secondBoxWeight = fruitBox.size() * 1.5;
        } else secondBoxWeight = fruitBox.size() * 1.0;
        return firstBoxWieght == secondBoxWeight;
    }

    public void replaceFruitsHere(ArrayList<Fruit> fruitBox) {
        this.fruitBox.addAll(fruitBox);
        fruitBox.clear();
    }

}
