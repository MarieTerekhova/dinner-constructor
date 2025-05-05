package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private static final Random random = new Random();
    HashMap<String, ArrayList<String>> saveDishes = new HashMap<>();


    public void saveDishes(String dishType, String dishName) {
        ArrayList<String> dishes = saveDishes.getOrDefault(dishType, new ArrayList<>());
        dishes.add(dishName);
        saveDishes.put(dishType, dishes);
    }

    public boolean checkType(String nextItem) {
        return saveDishes.containsKey(nextItem);
    }


    public void getComboDishes(ArrayList<String> dishes, int numberOfCombos) {

        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));

            for (String dishesCombo : dishes) {
                ArrayList<String> resultCombo = saveDishes.get(dishesCombo);
                System.out.println(resultCombo.get(random.nextInt(resultCombo.size())));
            }
        }
    }



}
