package lesson6;

public abstract class Animals {

    protected int limitRun;
    protected int limitSwim;
    protected double limitHeight;

    // бежать
    public void run(int valueRun) {}
    // плыть
    public void swim(int valueSwim) {}
    // прыгать
    public void jump(double valueHeight) {}

    // вывод результата
    static void showResult(String result){
        System.out.println(result);
    }

}
