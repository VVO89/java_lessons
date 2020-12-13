package lesson7;

public class Animal {

    protected int limitRun;
    protected int limitSwim;
    protected double limitHeight;
    private String name; // имя животного
    private boolean satiety; // сытость

    public Animal(String name, boolean satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    // бежать
    public  void run(int valueRun) {}
    // плыть
    public void swim(int valueSwim) {}
    // прыгать
    public void jump(double valueHeight) {}

    // вывод результата
    static void showResult(String result){
        System.out.println(result);
    }

}
