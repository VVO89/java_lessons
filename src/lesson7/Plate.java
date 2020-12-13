package lesson7;

public class Plate {

    private int food;

    // конструктор класса
    public Plate(int food) {
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    // добавление еды в миску
    public void addFood(int _food) {
        food +=_food;
    }

}
