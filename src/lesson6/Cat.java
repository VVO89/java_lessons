package lesson6;

public class Cat extends Animals{

    @Override
    public void run(int valueRun) {

        String result = (valueRun <=200)?"Cat run:true":"Cat run:false";
        limitRun = valueRun;

        showResult(result);

    }

    @Override
    public void jump(double valueHeight) {

        String result = (valueHeight <= 2)?"Cat jump:true":"Cat jump:false";
        limitHeight = valueHeight;
        showResult(result);

    }

}
