package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dinnerConstructor = new DinnerConstructor();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> constructorDishes = new ArrayList<>();

    public static void main(String[] args) {


        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dinnerConstructor.saveDishes(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        if (!dinnerConstructor.checkType(nextItem)) {
            System.out.println("Такого типа блюда нет.");
            System.out.println(" ");
        } else {
            while (!nextItem.isEmpty()) {
                constructorDishes.add(nextItem);
                nextItem = scanner.nextLine();
            }
            dinnerConstructor.getComboDishes(constructorDishes, numberOfCombos);
        }
    }
}