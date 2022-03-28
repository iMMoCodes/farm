package com.farm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.farm.animals.Animal;

public class AnimalsByFood {
    public static void printAnimalsByFood(List<Animal> animals) {
        System.out.println("\n----- Lunch time ----- \n");
        Map<String, List<Animal>> animalByFood = new HashMap<>();
        animalByFood = animals.stream().collect(Collectors.groupingBy(Animal::getFavoriteFood));

        for (int i = 0; i < animalByFood.size(); i++) {
            final String foodName = animalByFood.keySet().toArray()[i].toString();

            final String namesOfAnimalsEatingFood = animals.stream()
                    .filter(animal -> foodName.equals(animal.getFavoriteFood()))
                    .map(animal -> animal.getName())
                    .collect(Collectors.joining(" and "));

            if (namesOfAnimalsEatingFood.contains(" and ")) {
                System.out.println(namesOfAnimalsEatingFood + " are eating " + foodName);
            } else {
                System.out.println(namesOfAnimalsEatingFood + " is eating " + foodName);
            }
        }
    }
}
