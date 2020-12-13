package lesson6;

import lesson6.Animals;
import lesson6.Cat;
import lesson6.Dog;

public class Main {

    public static void main(String[] args) {

        Animals Cat1 = new Cat();
        Animals Cat2 = new Cat();
        Animals Dog1 = new Dog();
        Animals Dog2 = new Dog();

        //создадим массив типа Animals

        Animals[] masAnimals = new Animals[4];

        masAnimals[0] = Cat1;
        masAnimals[1] = Cat2;
        masAnimals[2] = Dog1;
        masAnimals[3] = Dog2;

        for (int i = 0; i < masAnimals.length; i++) {

            masAnimals[i].run(150);
            masAnimals[i].jump(2);
            masAnimals[i].swim(30);

        }

    }
}
