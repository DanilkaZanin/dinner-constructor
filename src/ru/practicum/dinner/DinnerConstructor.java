package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {
    private final HashMap<String, ArrayList<String>> menu;

    public DinnerConstructor() {
        menu = new HashMap<>();
    }

    /**
     * Проверка на существующее имя блюда.
     */
    private boolean doesTheDishExist(String type, String name) {
        for (String i : menu.get(type)) {
            if (i.equals(name))
                return true;
        }
        return false;
    }

    /**
     * Добавление нового блюда
     */
    public void addNewDish(String type, String dishName) {
        //если тип меню существует
        //я не очень понимаю, почему лучше делать так?
        if (doesTheTypeExist(type)) {
            //если такое блюдо уже есть
            if (doesTheDishExist(type, dishName))
                System.out.println("Блюдо уже добавлено в список!");
            else
                menu.get(type).add(dishName);
        } else {
            //тоже не очень понятно
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(type, dishes);
        }
    }

    /**
     * Проверка на существование типа
     */
    public boolean doesTheTypeExist(String type) {
        return menu.containsKey(type);
    }

    /**
     * Генерация комбинаций блюд
     */
    public ArrayList<ArrayList<String>> getDishCombos(int numberOfCombos, ArrayList<String> types) {
        ArrayList<ArrayList<String>> dishCombos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();

            for (String type : types) {
                ArrayList<String> dishes = menu.get(type);
                combo.add(dishes.get(random.nextInt(dishes.size())));
            }

            dishCombos.add(combo);
        }


        return dishCombos;
    }

}
