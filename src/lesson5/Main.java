package lesson5;

public class Main {

    public static void main(String[] args) {

        // создаем массив сотрудников - 5 элементов
        Employee[] persArray = new Employee[5];

        persArray[0] = new Employee("VVO", "VVO@mail.ru", "123", 1000, 28);
        persArray[1] = new Employee("SVO", "SVO@mail.ru", "456", 2000, 29);
        persArray[2] = new Employee("KVO", "KVO@mail.ru", "789", 3000, 42);
        persArray[3] = new Employee("MMM", "MMM@mail.ru", "434", 4000, 43);
        persArray[4] = new Employee("GGG", "GGG@mail.ru", "573", 5000, 32);

        for (int i = 0; i < persArray.length; i++) {
            // получаем возраст, так как поля приватные
            int pers_age = persArray[i].getAge();

            // в результате информация будет выведена только по двум сотрудникам (42 и 43 года)
            if (pers_age >= 40) {
                persArray[i].print_Employee();
                System.out.println();
            }
        }
    }
}
