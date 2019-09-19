package com.bigdata.lambdasnaction.chap6;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.bigdata.lambdasnaction.chap6.Dish.dishTags;
import static java.util.stream.Collectors.*;
import static com.bigdata.lambdasnaction.chap6.Dish.menu;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/9/17 18:31
 * @ Version 1.0
 */
public class Grouping {
    enum CaloricLevel { DIET, NORMAL, FAT };
    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Dishes names grouped by type: " + groupDishNamesByType());
        System.out.println("Dishes names grouped by type: " + groupDishesByCaloricLevel());
        System.out.println("Dishes names grouped by type: " + countDishesInGroups());
        System.out.println("Dishes names grouped by type: " + mostCaloricDishesByType());
        System.out.println("Dishes names grouped by type: " + mostCaloricDishesByTypeWithoutOprionals());
        System.out.println("Dishes names grouped by type: " + sumCaloriesByType());
        System.out.println("Dishes names grouped by type: " + caloricLevelsByType());

    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType(){
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    private static Map<Dish.Type, List<String>> groupDishNamesByType(){
        return menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));
    }

    private static Map<Dish.Type, Long> countDishesInGroups() {
        return menu.stream().collect(groupingBy(Dish::getType, counting()));
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }

    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOprionals() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(
                                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                                Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT; },
                        toSet() )));
    }
}
