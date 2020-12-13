package lesson7;

public class Cat extends Animal{

    public Cat(String name, boolean satiety) {
        super(name,satiety);
    }

    @Override
    public void run(int valueRun) {

        String result = (valueRun <=200)?"Cat run:true":"Cat run:false";
        showResult(result);

    }

    @Override
    public void jump(double valueHeight) {

        String result = (valueHeight <= 2)?"Cat jump:true":"Cat jump:false";
        showResult(result);

    }

    @Override
    public void swim(int valueSwim) {
        System.out.println("Кот не умеет плавать");
    }

    // питание кота
    public void catEat(Plate pl, int catFood) {
        // остаток еды в тарелке
        int remainFood = pl.getFood() - catFood;
        StringBuilder message = new StringBuilder();
        // кот не может быть наполовину сыт
        if (remainFood >= 0){
            pl.setFood(remainFood);
            // кот поел, а значит сыт
            this.setSatiety(true);
            message.append(this.getName().concat(" поел!").concat(" ".concat(Integer.toString(catFood).concat(" еды"))));
        }else{
            message.append("Еды в тарелке больше нет! ".concat(this.getName().concat(" не поел!")));
        }

        if (this.isSatiety()){
            message.append(" Котик насытился.");
        }else {
            message.append(" Котик не насытился.");
        }

        System.out.println(message);
    }
}
