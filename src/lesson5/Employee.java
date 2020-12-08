package lesson5;

public class Employee {

    private String initials; // инициалы
    private String email;    // EMAIL
    private String number;   // телефонный номер
    private double salary;   // зарплата
    private int age;         // возраст

    // конструктор класса
    public Employee(String initials, String email, String number, double salary, int age) {
        this.initials = initials;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    // получение возраста для анализа
    public int getAge() {
        return age;
    }

    // печать информации о сотрудниках
    public void print_Employee() {
        System.out.printf("Инициалы: %s; %nEMAIL: %s; %nТелефонный номер: %s; %nЗарплата: %s; %nВозраст: %s;%n"
                , initials, email, number, salary, age);
    }

}
