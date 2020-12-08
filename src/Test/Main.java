package Test;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int m; // число строк
        int n; // число столбцов
        int dimension; // интервал
        int[][] mas;

        m = get_values("Введите число строк");
        n = get_values("Введите число столбцов");
        dimension = get_values("Введите размерность");

        //System.out.printf("Число строк %d%n", m);
        //System.out.printf("Число столбцов %d%n", n);

        // заполнение матрицы
        mas = masFilling(m,n,dimension);
        // вывод матрицы
        display_mas(mas,m,n);


    }

    private static int get_values(String message) {

        String x;

        do {
            System.out.println(message);
            Scanner Scan = new Scanner(System.in);
            x = Scan.next();
        } while (isInt(x) == false);

        return Integer.parseInt(x);
    }

    private static boolean isInt(String str) {

        try {
            int x = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private static int[][] masFilling(int m, int n,int dim) {

        int[][] mas = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i>j) {
                    mas[i][j] =1;
                } else
                    mas[i][j] = get_random(dim);
            }
        }
        return mas;
    }

    private static int get_random(int dim) {
        Random rand = new Random();
        return rand.nextInt(dim);
    }

    private static void display_mas(int[][] mas, int m,int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }
}

