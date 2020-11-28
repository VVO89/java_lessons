package lesson1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // основные типы данных, те типы, которых нет - аналогично
        //int a      = 3;
        //double b   = 3.15;
        //char c     = 'f';
        //String str = "Hello";
        //float pi = 3.14f;

        // 3 задание
        int a,b,c,d;
        double result;
        a = 1;
        b = 2;
        c = 3;
        d = 4;

        result = execute_sum(a,b,c,d);
        System.out.println("3 задание: " + result);

        // 4 задание
        System.out.println("4 задание: " + execute_4(10,5));

        // 5 задание
        execute_5(7);

        // 6 задание
        System.out.println("6 задание: " + execute_6(10));

        // 7 задание
        execute_7("Viktor");

        // 8 задание
        execute_8(800);

        /*int[] data = {1,2,3,4,5};

        for (int i = 0; i<data.length; i++){
            System.out.printf("Index %d: %d%n", i, data[i]);
        }*/
        // еще один вывод
        //System.out.println(Arrays.toString(data));

        int[][] deepArray = new int[20][20];
        int n = 1;
        for(int i = 0; i< 20; i++){
            for(int j = 0; j<20; j++){
                deepArray[i][j] = n++;
            }
        }


        /*for(int i = 0; i< 20; i++){
            for(int j = 0; j<20; j++){
               System.out.printf("%2d ",deepArray[i][j]) ;
            }
            System.out.println();
        }*/
        String str = "Hello world";

        for (char da : str.toCharArray()){
            System.out.println(da);
        }
        
    }

    public static double execute_sum(int a,int b,int c,int d){

        if(d == 0){
            return a*b;
        }
        else {
            return a*(b + c/d);
        }

    }

    public static boolean execute_4(int a,int b){

       int sum = a + b;

        if(sum >= 10 && sum<= 20){
            return true;
        }
        else {
            return false;
        }
    }

    public static void execute_5(int a){
        if(a >= 0) {
            System.out.println("5 задание: " + "Положительное число");
        }
        else {
            System.out.println("5 задание: " + "Отрицательное число");
        }
    }

    public static boolean execute_6(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void execute_7(String name){
        System.out.println("7 задание: " + "Привет, " + name);
    }

    public static void execute_8(int Year){

        if(Year % 4 == 0){
            if ( Year % 400 == 0) {
                System.out.println("Високосный год");
            }
            else{
                if( Year % 100 == 0){
                    System.out.println("Не високосный год");
                }
            }
        }
        else{
            System.out.println("Не високосный год");
        }
    }

}
