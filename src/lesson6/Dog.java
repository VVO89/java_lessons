package lesson6;

public class Dog extends Animals{

    private int maxLength;

    public Dog() {
        // разброс в ограниениях
        maxLength = Math.random() > 0.5? 400:600;
    }

    @Override
    public void swim(int valueSwim) {

        String result = (valueSwim <= 10)?"Dog swim:true":"Dog swim:false";
        showResult(result);

    }

    @Override
    public void run(int valueRun) {

        String result = (valueRun <= maxLength)?"Dog run:true":"Dog run:false";
        showResult(result);

    }

    @Override
    public void jump(double valueHeight) {
        String result = (valueHeight <= 0.5)?"Dog jump:true":"Dog jump:false";
        limitHeight = valueHeight;
        showResult(result);
    }

}
