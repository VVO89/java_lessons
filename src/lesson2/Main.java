package lesson2;

public class Main {

    public static void main(String[] args) {

        // lesson1
        //execute_1();

        //lesson2
        //execute_2();

        //lesson3
        //execute_3();

        // lesson4
        //execute_4();

        // lesson5
        //execute_5();

        //lesson6
        //int[] mas = {2,2,2,1,2,2,10,1};
        //System.out.println(execute_6(mas));

        //lesson7
        //int[] mas = {2,2,2,1,2,2,10,1};
        //execute_7(mas,2);

    }

    public static void execute_1() {
        // задаем массив
        int[] mas = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int mas_Length = mas.length;
        // замена 0 и 1
        for (int i = 0; i < mas_Length; i++) {
            mas[i] = (mas[i] == 0) ? 1 : 0;
        }
        //вывод результата
        for (int i = 0; i < mas_Length; i++) {
            System.out.printf("mas[%s]: %s %n", i, mas[i]);
        }

    }

    public static void execute_2() {
        // задаем массив
        int[] mas = new int[8];
        int mas_length = mas.length;

        // заполняем массив
        for (int i = 0; i < mas_length; i++) {
            mas[i] = 3 * i;
        }
        // вывод массива
        for (int i = 0; i < mas_length; i++) {
            System.out.printf("mas[%s]: %s %n", i, mas[i]);
        }

    }

    public static void execute_3() {
        // задаем массив
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 1, 4, 8, 9, 1};
        int mas_length = mas.length;

        for (int i = 0; i < mas_length; i++) {
            mas[i] = (mas[i] < 6) ? mas[i] * 2 : mas[i];
        }

        for (int i = 0; i < mas_length; i++) {
            System.out.printf("mas[%s]: %s %n",i,mas[i]);
        }
    }

    public static void execute_4() {
        // создаем двумерный массив
        final int SIZE = 5;
        int[][] mas = new int[SIZE][SIZE];

        // заполнение по главной и побочной диагонали единицами
        for (int i = 0; i <SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mas[i][j] = (i == j || i == (SIZE-j-1))?mas[i][j] = 1:0;
            }
        }

        // вывод массива в корректном виде
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2d ", mas[i][j]);
            }
            System.out.println(); // перевод строки, а то все в строчку будет
        }

    }

    public static void execute_5() {

        int maximum = 0;
        int minimum = 0;

        int[] mas = {1,5,7,2,4,9,10};
        int mas_length = mas.length;

        maximum = mas[0];
        minimum = mas[0];

        for (int i = 0; i < mas_length; i++) {

          if(mas[i] > maximum){
              maximum = mas[i];
          }
          if(mas[i]<minimum){
              minimum = mas[i];
          }
        }

        System.out.printf("Минимальное значение массива: %s%n",minimum);
        System.out.printf("Максимальное значение массива: %s%n",maximum);

    }

    public static boolean execute_6(int[] mas) {

        int left_sum,right_sum;

        for (int i = 0; i < mas.length; i++) {

            left_sum  = 0;
            right_sum = 0;

            // считаем сумму слева
            for (int j = 0; j < i; j++) {
                left_sum += mas[j];
            }
            // Считаем суму справа
            for (int j = i; j < mas.length; j++) {
                right_sum += mas[j];
            }

            if (left_sum == right_sum) return true;

        }
        return false;
    }

    public static void execute_7(int[] mas, int n) {

        System.out.println("Массив до изменений");
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("mas[%s]: %s %n",i,mas[i]);
        }

        if(n>0){
            for (int i = 0; i < n; i++) {

                int b = mas[mas.length - 1]; // последний элемент массива

                if(mas.length - 1>= 0){
                    System.arraycopy(mas,0,mas,1,mas.length - 1);
                    mas[0] = b;
                }
            }
        }

        if(n<0){
            for (int i = 0; i > n; i--) {

                int b = mas[0]; // первый элемент массива
                System.arraycopy(mas,1,mas,0,mas.length - 1);
                mas[mas.length - 1] = b;

            }
        }

        System.out.println("Массив после изменений");
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("mas[%s]: %s %n",i,mas[i]);
        }
    }
}
