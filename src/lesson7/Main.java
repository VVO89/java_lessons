package lesson7;

import lesson6.Animals;
import lesson6.Dog;

public class Main {

    public static void main(String[] args) {

        // по умолчанию коты голодны
        // создаем тарелку с едой
        Plate pl = new Plate(100);
        // Добавляем еще еды в тарелку
        pl.addFood(150);
        // создаем массив объектов Cat

        Cat[] masCat = new Cat[4];

        masCat[0] = new Cat("Котэ1", false);
        masCat[1] = new Cat("Котэ2", false);
        masCat[2] = new Cat("Котэ3", false);
        masCat[3] = new Cat("Котэ4", false);

        for (int i = 0; i < masCat.length; i++) {
            // питание котов
            masCat[i].catEat(pl,100);
        }

    }
}
