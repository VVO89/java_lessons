package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int n = 3; // число попыток

    public static void main(String[] args) {
        //1 задание
        playGame1(n);
        // 2 задание
        playGame2();
    }

    public static void playGame1(int n) {

        while (n > 0) {

            // Загадаем число от 0 до 9
            Random rand = new Random();
            int x = rand.nextInt(10);

            // Пользователь вводит любое число, от 0 до 9 (интервал)
            int d = getNumberFromScanner("Введите число от 0 до 9", 0, 9);

            n = n - 1;
            if (x == d) {
                System.out.println("Вы выиграли! Игра окончена!");
                n = 0;
                playGame1(n);
                break;
            } else {
                if (n == 0) {
                    System.out.println("Вы проиграли! Игра окончена!");
                    System.exit(0);

                } else {
                    System.out.printf("Вы проиграли! Сыграем еще (Да,Нет)? Осталось %d попыток %n", n);
                    // тут используем ответ от пользователя.
                    Scanner Sc = new Scanner(System.in);
                    String answer = Sc.next();

                    switch (answer) {
                        case "Да":
                            playGame1(n);
                            break;
                        case "Нет":
                            System.out.println("Вы проиграли! Игра окончена!");
                            n = 0;
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Вы проиграли! Игра окончена!");
                            n = 0;
                            System.exit(0);
                            break;
                    }
                }
            }
        }
    }

    private static int getNumberFromScanner(String message, int min, int max) {

        boolean this_Number = false;
        int x = 0;

        while (this_Number == false) {
            System.out.println(message);

            Scanner Scan = new Scanner(System.in);

            if (Scan.hasNextInt()) {
                x = Scan.nextInt();
                this_Number = true;
                break;
            }
        }

        return x;
    }

    private static void playGame2() {

        String x_String;

        String[] words = createWords();
        // компьтер загадывает слово
        int length_words = words.length;

        Random rand = new Random();
        int x = rand.nextInt(length_words);
        x_String = words[x]; // слово, которое загадал компьютер

        playGame2_1(x_String, false);

    }

    private static String[] createWords() {
        String[] mas = {"apple", "orange", "lemon",
                "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut",
                "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        return mas;
    }

    private static void playGame2_1(String str_random, boolean result) {

        while (result == false) {
            System.out.println("Угадайте слово:");
            Scanner Sc = new Scanner(System.in);
            String str_user = Sc.next().toLowerCase(); // в нижний регистр

            // проводим посимвольное сравнение двух строк
            char[] char_str_random = str_random.toCharArray();
            char[] char_str_user = str_user.toCharArray();

            String str_result = "";

            int char_star_random_length = char_str_random.length;
            int char_star_user_length = char_str_user.length;

            if (char_star_random_length >= char_star_user_length) {
                strCompare(str_result, char_str_user, char_str_random, str_random);
            } else {
                strCompare(str_result, char_str_random, char_str_user, str_random);
            }

        }

    }

    private static void strCompare(String str_result, char[] mas1, char[] mas2, String str_random) {

        for (int i = 0; i < mas1.length; i++) {
            str_result += (mas1[i] == mas2[i]) ? mas1[i] : '#';
        }

        int diff = (mas1.length - mas2.length > 0) ? mas1.length - mas2.length : mas2.length - mas1.length;

        if (diff > 0) {
            while (diff > 0) {
                str_result += '#';
                diff--;
            }
        }

        // поиск символа #
        if (str_result.lastIndexOf("#") == -1) {
            System.out.println(str_result);
            System.out.println("Ты выиграл!");
            System.exit(0); // выход из программы
        } else {
            System.out.println(str_result + "##############");
            System.out.println("Не угадали!");
            playGame2_1(str_random, false);
        }
    }

}
