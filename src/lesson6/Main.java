package lesson6;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        // бегать
        dog.run(120);
        cat.run(4500);

        // прыгать
        dog.jump(0.7);
        cat.jump(1);

        // плыть (кот плавать не умеет)
        dog.swim(20);

    }
}
