/*package TicTakToe;

import java.util.Random;
import java.util.Scanner;

public class TicTakToe {

    static final int SIZE = 3;
    static final char DOT_empty = 'Q'; // пустая ячейка
    static final char DOT_HUMAN = 'X'; // ходит человек
    static final char DOT_AI    = 'Y'; // ходит компьютер

    static final String HEADER_FIRST_EMPTY = "*";
    static final String EMPTY = " ";

    static char[][] map = new char[SIZE][SIZE]; // карта
    static final Scanner in = new Scanner(System.in); // ввод с клавиатуры
    static final Random rand = new Random();

    public static void main(String[] args) {

        turnGame();

    }

    public static void turnGame() {
        initMap();
        printMap();
        playGame();
    }

    private static void printMap() {
        printMapHeader();
        printMapRow();
    }

    private static void initMap() {
        // инициализация пустыми значениями
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_empty;
            }
        }
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_EMPTY + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapRow() {
        for (int i = 0; i < SIZE; i++) {
           printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    public static void playGame() {

        while (true) {
            // ход человека
            humanTurn();
            // печать поля
            printMap();
            // проверка на победу человека
            chekEnd(DOT_HUMAN);

            // ход ПК
            aiTurn();
            // печать поля
            // проверка на победу ПК
            chekEnd(DOT_AI);
        }
    }

    private static void chekEnd(char symbol) {
        boolean isEnd = false;
        // проверка на комбинацию
        if (chekWin(symbol)){
            String winMessage;

            if (symbol == DOT_HUMAN) {
                winMessage = "УРА! Мы победили";
            }
            else {
                winMessage = "Восстание близко! Компьютер победил";
            }

            System.out.println("\n" + winMessage);

        }
        // проверка на ничью
        if (!isEnd && isMapFull()){
            System.out.println("Ничья");
            isEnd = true;
        }

        if (isEnd){
            System.exit(0);
        }


    }

    private static boolean chekWin(char symbol) {

    }

    private static boolean isMapFull() {

    }

    private static void aiTurn() {
        // нужны проверки на коректность
        int rowNumber    = 0;
        int columnNumber = 0;
        System.out.println("\nХод компьютера\n");
        do{
           rowNumber = rand.nextInt(SIZE + 1);
           columnNumber = rand.nextInt(SIZE + 1);
        }while (!isCellValid(rowNumber,columnNumber,true));
        map[rowNumber - 1][columnNumber - 1] = DOT_AI;
    }

    private static boolean isCellValid(int rowNumber, int columnNumber) {
        return isCellValid(rowNumber,columnNumber,false);
    }

    private static void humanTurn() {
        // нужны проверки на коректность
        int rowNumber    = 0;
        int columnNumber = 0;

        System.out.println("\nХод человека! Введите номер строки и столбца");

        do {
            System.out.println("Строка = ");

            if (in.hasNextInt()) {
                rowNumber = in.nextInt();
            } else {
                in.next();
                System.out.println("Введите число от 1 до " + SIZE + "\n");
                continue;
            }

            System.out.println("Столбик = ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt();
            } else {
                in.next();
                System.out.println("Введите число от 1 до " + SIZE + "\n");
                continue;
            }
        }
        while (!isCellValid(rowNumber,columnNumber));

        map[rowNumber - 1][columnNumber - 1] = DOT_HUMAN;
    }

    private static boolean isCellValid(int rowNumber, int columnNumber, boolean isAi) {

        if (!isAi && (rowNumber < 1 || rowNumber > SIZE || columnNumber < 1 || columnNumber > SIZE)){
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        }

        if (map[rowNumber - 1][columnNumber - 1] != DOT_empty){
            if (!isAi) {
                System.out.println("\nВы выбрали занятую ячейку!");
            }
            return false;
        }

        return true;
    }
}
*/