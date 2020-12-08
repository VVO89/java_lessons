package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {

    public static final String EMPTY = " "; // пустое пространство
    public static final char EMPTY_NEMO = 'Q'; // пустой символ
    public static final char HUMAN_MOVE = 'X'; // ход человека
    public static final char COMP_MOVE = 'Y'; // ход компьютера

    public static int number_line = 0; // номер строки
    public static int number_column = 0; // номер столбца
    public static int max_counter = 0; // максимальное количество подряд совпадающих символов

    public static int SIZE; // размерность массива (ввод с клавиатуры)
    public static char[][] map; // массив для игры
    public static int[] mas_prev = new int[2]; // массив для хранения предыдущего шага человека
    public static int[] mas_comp = new int[2]; // массив, для хранения хода компьютера
    public static int victory_condition;

    public static Scanner Scan = new Scanner(System.in);

    public static Random Rand  = new Random();
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        initializationSize(); // инициализация размерности массива
        initialisationVictoryCondition(); // инициализация условия победы, в зависимости от размера поля
        fillingMap(); // заполнение массива пустыми значениями
        renderingMap(); // вывод массива на экран
        playGame();// основной алгоритм
    }

    private static void initializationSize() {
        System.out.println("\nВведите размерность игры");
        do {
            // проверим, ввел ли пользователь число
            // если нет, то вводим, пока не введем нужно значение
            if (Scan.hasNextInt()) {
                SIZE = Scan.nextInt();
            } else {
                Scan.next();
                System.out.println("\nВведите размерность игры");
                continue;

            }

        } while (!isCorrectlySize());
        map = new char[SIZE][SIZE];
    }

    private static void initialisationVictoryCondition() {
        // исходя из условия задачи
        if (SIZE < 6) {
            victory_condition = 3;
        } else if (SIZE > 6 & SIZE < 9) {
            victory_condition = 4;
        } else {
            victory_condition = 5;
        }
    }

    private static boolean isCorrectlySize() {
        return (SIZE > 0 & SIZE < 10) ? true : false;
    }

    private static void fillingMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_NEMO;
            }
        }
    }

    private static void renderingMap() {
        printMapHeader();
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + EMPTY);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapHeader() {
        for (int i = 0; i < SIZE + 1; i++) {
            System.out.print(i + EMPTY);
        }
    }

    private static void playGame() {

        boolean win = false;
        boolean draw = false;
        String message = "";

        while (!win) {
            // ход человека
            System.out.println("Ход человека.\n");
            moveHuman();
            // определение победителя
            win = isWin(HUMAN_MOVE);
            // Определение ничьи
            draw = search_EMPTY_NEMO();

            if (!draw) {
                message = "Ничья!";
                System.out.println(message);
                System.exit(0);// выходим из приложения
            }

            if (win) {
                message = "Человек победил!";
            }

            if (!win) {

                // ход компьютера
                System.out.println("Ход компьютера.\n");
                moveComputer();
                win = isWin(COMP_MOVE);
                if (win) {
                    message = "Компьютер победил!";
                }
            }
        }
        System.out.println(message);
        System.out.println("Игра завершена!");
    }

    private static boolean search_EMPTY_NEMO() {
        boolean draw = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_NEMO) {
                    draw = true;
                    break;
                }
            }
        }
        return draw;
    }

    private static void moveHuman() {

        boolean move_correct = false; // флаг свободной ячейки
        while (!move_correct) {
            System.out.println("Введите номер строки и столбца");
            // вводим номер строки до тех пор, пока не будет введен корректный номер
            number_line = inputNumber("Введите номер строки");
            number_column = inputNumber("Введите номер столбца");

            if (map[number_line][number_column] == 'Q') {
                move_correct = true;
            } else {
                System.out.println("\nЯчейка занята. Введите корректные координаты");
            }
        }
        // заполняем ячейку выбранной координатой
        map[number_line][number_column] = HUMAN_MOVE;
        // вывод на экран
        renderingMap();
    }

    private static int inputNumber(String message) {
        int number = 0;
        do {
            System.out.println(message);
            if (Scan.hasNextInt()) {
                number = Scan.nextInt();
            } else {
                Scan.next();
                continue;
            }
        } while (!checkSize(number));
        return number - 1; // так как массив нумеруется с 0
    }

    private static boolean checkSize(int i) {
        return (i <= SIZE) ? true : false;
    }

    private static void moveComputer() {
        boolean move_correct = false; // флаг свободной ячейки
        while (!move_correct) {
            // используем функцию Random
            //number_line   = 1 + Rand.nextInt((SIZE - 1) + 1); // номер строки
            //number_column = 1 + Rand.nextInt((SIZE - 1) + 1); // номер столбца
            // используем не рандомную пару чисел, а более осмысленную
            if (checkComputer()) {
                number_line   = mas_comp[0];
                number_column = mas_comp[1];
                if (map[number_line][number_column] == 'Q') {
                    move_correct = true;
                }else{
                    number_line   = Rand.nextInt((SIZE - 1) + 1); // номер строки
                    number_column = Rand.nextInt((SIZE - 1) + 1); // номер столбца
                    // проверим, занята ли ячейка (проверка уже не нужна)
                    if (map[number_line][number_column] == EMPTY_NEMO ) {
                        move_correct = true;
                    }
                }
            }
        }
        map[number_line][number_column] = COMP_MOVE;
        // вывод результата
        renderingMap();
    }

    private static boolean checkComputer() {

        boolean check = false;

        int i = number_line;
        int j = number_column;

        // блокируем клетки, если человек почти выиграл
        if (max_counter > 1) {
            // вначале нужно определить, где пользователь установил предыдущую точку
            // если нашли,
            if (getMasPrev()) {
                // блокируем
                moveBlockHuman();
                check = true;
            }
        }
        // смотрим остальные случаи
        // смотрим на строку выше, проверка на ошибку выхода из массива
        if (!check) {
            if (check_Line(i - 1, j - 1)) {
                check = true;
            }
        }
        // смотрим на строку ниже
        if (!check) {
            if (check_Line(i + 1, j + 1)) {
                check = true;
            }
        }
        // смотрим на столбец слева
        if (!check) {
            if (check_Column(i, j - 1)) {
                check = true;
            }
        }
        // смотрим на столбец справа
        if (!check) {
            if (check_Column(i, j + 1)) {
                check = true;
                //return check;
            }
        }
        return check;
    }

    private static void moveBlockHuman() {
        // код нуждается в рефакторинге, пока сделал так
        // попытка заблокировать ходы человека
        boolean moveComputerCompleted = false;

        int prev_number_line   = mas_prev[0];
        int prev_number_column = mas_prev[1];
        // если точки лежат на одной строке
        if (number_line == prev_number_line) {
            if ((number_column + 1) < SIZE) {
                if (map[number_line][number_column + 1] == EMPTY_NEMO) {
                    map[number_line][number_column + 1] = COMP_MOVE;
                    mas_comp[0] = number_line;
                    mas_comp[1] = number_column + 1;
                    moveComputerCompleted = true;
                } else if (number_column - 1 >= 0) {
                    map[number_line][number_column - 1] = COMP_MOVE;
                    mas_comp[0] = number_line;
                    mas_comp[1] = number_column - 1;
                    moveComputerCompleted= true;
                }
            }
        }
        // если точки лежат на одном столбце
        if (number_column == prev_number_column & !moveComputerCompleted) {
            if ((number_line + 1) < SIZE) {
                if (map[number_line + 1][number_column] == EMPTY_NEMO){
                    map[number_line + 1][number_column] = COMP_MOVE;
                    mas_comp[0] = number_line + 1;
                    mas_comp[1] = number_column;
                    moveComputerCompleted = true;
                } else if ((number_line - 1) < SIZE){
                    map[number_line - 1][number_column] = COMP_MOVE;
                    mas_comp[0] = number_line - 1;
                    mas_comp[1] = number_column;
                    moveComputerCompleted = true;
                }
            }
        }
        // на главной диагонали - вверх
        if ((prev_number_line - 1) >=0 & (prev_number_column - 1) >= 0 & !moveComputerCompleted){
            if (map[prev_number_line - 1][prev_number_column - 1] == EMPTY_NEMO){
                map[prev_number_line - 1][prev_number_column - 1] = COMP_MOVE;
                mas_comp[0] = prev_number_line - 1;
                mas_comp[1] = prev_number_column - 1;
                moveComputerCompleted = true;
            }
        }
        // на главной диагонали - вниз
        if ((prev_number_line + 1) >=0 && (prev_number_column + 1) >= 0 & !moveComputerCompleted){
            if (map[prev_number_line + 1][prev_number_column + 1] == EMPTY_NEMO){
                map[prev_number_line + 1][prev_number_column + 1] = COMP_MOVE;
                mas_comp[0] = prev_number_line + 1;
                mas_comp[1] = prev_number_column + 1;
                moveComputerCompleted = true;
            }
        }
        // на побочной диагонали - вверх
        if ((prev_number_line - 1) >=0 && (prev_number_column + 1) < SIZE & !moveComputerCompleted){
            if (map[prev_number_line - 1][prev_number_column + 1] == EMPTY_NEMO){
                map[prev_number_line - 1][prev_number_column + 1] = COMP_MOVE;
                mas_comp[0] = prev_number_line - 1;
                mas_comp[1] = prev_number_column + 1;
                moveComputerCompleted = true;
            }
        }
        // на побочной диагонали - вниз
        if ((prev_number_line + 1) < SIZE && (prev_number_column - 1) >= 0 & !moveComputerCompleted){
            if (map[prev_number_line + 1][prev_number_column - 1] == EMPTY_NEMO){
                map[prev_number_line + 1][prev_number_column - 1] = COMP_MOVE;
                mas_comp[0] = prev_number_line + 1;
                mas_comp[1] = prev_number_column - 1;
                moveComputerCompleted = true;
            }
        }
    }

    private static boolean getMasPrev() {

        // получение предыдущего хода человека, чтобы понть, в какую клетку поставить блокировку
        boolean result = false;
        // перебираем последовательно точки вокруг текущей точки
        //if ((number_column - 1 >= 0) & (number_line - 1 >= 0)) {
            // слева
        if (number_column - 1 >= 0) {
            if (map[number_line][number_column - 1] == HUMAN_MOVE) {
                mas_prev[0] = number_line;
                mas_prev[1] = number_column - 1;
                result = true;
            }
        }
        // главная диагональ - вверх
        if (number_line - 1 >= 0 & number_column - 1 >= 0) {
            if (map[number_line - 1][number_column - 1] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line - 1;
                mas_prev[1] = number_column - 1;
                result = true;
            }
        }
        //сверху
        if (number_line - 1 >= 0) {
            if (map[number_line - 1][number_column] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line - 1;
                mas_prev[1] = number_column;
                result = true;
            }
        }
        // побочная диагональ - вверх
        if (number_line - 1 >=0 & number_column + 1 < SIZE) {
            if (map[number_line - 1][number_column + 1] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line - 1;
                mas_prev[1] = number_column + 1;
                result = true;
            }
        }
        // справа
        if (number_column + 1 < SIZE) {
            if (map[number_line][number_column + 1] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line;
                mas_prev[1] = number_column + 1;
                result = true;
            }
        }
        // главная диагональ - вниз
        if (number_line + 1 < SIZE & number_column + 1 < SIZE) {
            if (map[number_line + 1][number_column + 1] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line + 1;
                mas_prev[1] = number_column + 1;
                result = true;
            }
        }
        // снизу
        if (number_line + 1 < SIZE) {
            if (map[number_line + 1][number_column] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line + 1;
                mas_prev[1] = number_column;
                result = true;
            }
        }
        // побочная диагональ - вниз
        if (number_line + 1 < SIZE & number_column - 1 >= 0){
            if (map[number_line + 1][number_column - 1] == HUMAN_MOVE & !result) {
                mas_prev[0] = number_line + 1;
                mas_prev[1] = number_column - 1;
                result = true;
            }
        }
        return result;
    }

    private static boolean check_Column(int i, int j) {

        boolean check = false;

        if ((i >= 0 & i < SIZE) && (j >= 0 & j < SIZE)) {
            for (int k = i; k < SIZE; k++) {
                if (map[k][j] == 'Q') {
                    mas_comp[0] = k;
                    mas_comp[1] = i;
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    private static boolean check_Line(int i, int j) {

        boolean check = false;

        if ((i >= 0 & i < SIZE) && (j >= 0 & j < SIZE)) {
            for (int k = j; k < SIZE; k++) {
                if (map[i][k] == 'Q') {
                    mas_comp[0] = i;
                    mas_comp[1] = k;
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    private static boolean isWin(char move) {
        // координаты точки уже знаем
        // Добавим счетчик символов
        int counter = 0;
        // добавим вспомогательные переменные, нужные для искусственного интеллекта
        int counter_1 = 0;
        int counter_2 = 0;
        int counter_3 = 0;
        int counter_4 = 0;
        // добавим вспомогательные массивы, которые служат для хранения количества идущих подряд символов
        int[] mas_counter1 = new int[SIZE];
        int[] mas_counter2 = new int[SIZE];
        int[] mas_counter3 = new int[SIZE];
        int[] mas_counter4 = new int[SIZE];

        boolean rezult = false;

        // проверяем совпадения в строке
        for (int i = 0; i < SIZE; i++) {
            if (map[number_line][i] == move) {
                counter++;
            } else if (counter < 3) {
                mas_counter1[i] = counter;
                counter = 0;
            }
            // условие победы
            if (counter == victory_condition) {
                rezult = true;
            }
        }
        if (mas_counter1.length > 0) {
            counter_1 = getMaxMas(mas_counter1);
        }
        counter = 0;
        // проверяем совпадения в столбце
        for (int j = 0; j < SIZE; j++) {
            if (map[j][number_column] == move) {
                counter++;
            } else if (counter < 3) {
                mas_counter2[j] = counter;
                counter = 0;
            }
            // условие победы
            if (counter == victory_condition) {
                rezult = true;
            }
        }
        if (mas_counter2.length > 0) {
            counter_2 = getMaxMas(mas_counter2);
        }
        counter = 0;
        // проверям совпадения по главной диагонали и побочной диагонали
        int i = number_line;
        int j = number_column;
        // побочная диагональ (вверх от точки)
        while (i >= 0 & j <= number_column) {

            if (map[i][j] == move) {
                counter++;
            } else {
                mas_counter3[i] = counter;
                counter = 0;
            }
            // условие победы
            if (counter == victory_condition) {
                rezult = true;
            }
            i++;
            j++;
        }

        // побочная диагональ (вниз от точки)
        int i_1 = number_line;
        int j_1 = number_column;
        while ((i_1 < SIZE & i_1 >= 0) & (j_1 < SIZE & j_1 >= 0)) {

            if (i_1 == number_line & j_1 == number_column) {
                if (i_1 == 0 & j_1 == 0) {
                    if (map[i_1][j_1] == move) {
                        counter++;
                        i_1++;
                        j_1--;
                        continue;
                    } else if (counter < 3) {
                        mas_counter3[i_1] = counter;
                        counter = 0;
                    }
                    // условие победы
                    if (counter == victory_condition) {
                        rezult = true;
                    }
                } else {
                    i_1++;
                    j_1--;
                }
                continue;
            }

            if (map[i_1][j_1] == move) {
                counter++;
            } else {
                mas_counter3[i_1] = counter;
                counter = 0;
            }
            // условие победы
            if (counter == victory_condition) {
                rezult = true;
            }
            i_1++;
            j_1--;
        }
        if (mas_counter3.length > 0) {
            counter_3 = getMaxMas(mas_counter3);
        }
        counter = 0;

        // главная диагональ (вверх от точки)
        int i_2 = number_line;
        int j_2 = number_column;
        while (i_2 >= 0 & j_2 >= 0) {

            if (map[i_2][j_2] == move) {
                counter++;
            } else {
                mas_counter4[i_2] = counter;
                counter = 0;
            }
            // условие победы
            if (counter == victory_condition) {
                rezult = true;
            }
            i_2--;
            j_2--;
        }

        // главная диагональ (вниз от точки)
        int i_3 = number_line;
        int j_3 = number_column;
        while ((i_3 < SIZE & i_3 >= 0) & (j_3 < SIZE & j_3 >= 0)) {

            if (i_3 == number_line & j_3 == number_column) {
                if (i_3 == 0 & j_3 == 0) {
                    if (map[i_3][j_3] == move) {
                        counter++;
                        i_3++;
                        j_3--;
                        continue;
                    } else if (counter < 3) {
                        mas_counter4[i_3] = counter;
                        counter = 0;
                    }
                    // условие победы
                    if (counter == victory_condition) {
                        rezult = true;
                    }
                } else {
                    i_3++;
                    j_3--;
                }

                continue;
            }

            if (map[i_3][j_3] == move) {
                counter++;
            } else {
                mas_counter4[i_3] = counter;
                counter = 0;
            }
            // условие победы
            if (counter == victory_condition) {
                rezult = true;
            }
            i_3++;
            j_3++;
        }
        if (mas_counter4.length > 0) {
            counter_4 = getMaxMas(mas_counter4);
        }
        // получим максимальное значение из counter 1..4
        calcMaxCounter(counter_1, counter_2, counter_3, counter_4);

        return rezult;
    }

    private static int getMaxMas(int[] mas_counter1) {

        // поиск максимального числа в массиве
        int max = 0;

        for (int i = 0; i < mas_counter1.length; i++) {
            if (max <= mas_counter1[i]){
                max = mas_counter1[i];
            }
        }
        return max;
    }

    private static void calcMaxCounter(int counter_1, int counter_2, int counter_3, int counter_4) {

        // поиск максимального из 4 чисел
        int[] mas_counter = new int[4];
        // заполняем его
        mas_counter[0] = counter_1;
        mas_counter[1] = counter_2;
        mas_counter[2] = counter_3;
        mas_counter[3] = counter_4;
        // выбор максимального значения
        for (int i = 0; i < mas_counter.length; i++) {
            if (max_counter <= mas_counter[i]) {
                max_counter = mas_counter[i];
            }
        }
    }

}
