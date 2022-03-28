package com.farm;

import java.util.List;

import com.farm.animals.Animal;

public class App {
    public static void main(String[] args) {
        final List<Animal> animals = new AnimalList().getAnimals();
        int day = 1;

        System.out.println("----- Animals at farm -----");
        animals.forEach(System.out::println);

        while (day <= 10) {
            Animal.removeFriend(day, animals);
            AnimalsByFood.printAnimalsByFood(animals);
            Animal.addFriend(day, animals);
            FriendTable.print(day, animals);
            day++;
        }
    }
}
