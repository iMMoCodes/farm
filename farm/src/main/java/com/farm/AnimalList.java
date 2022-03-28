package com.farm;

import java.util.ArrayList;
import java.util.List;

import com.farm.animals.Animal;
import com.farm.animals.Bird;
import com.farm.animals.Cat;
import com.farm.animals.Dog;

public class AnimalList {
    private final List<Animal> animals = new ArrayList<>();

    public AnimalList() {
        animals.add(new Dog("Rex", "Royal Canin", "Tom", "Shepherd"));
        animals.add(new Dog("Max", "Purina ONE", "Jay", "Shepherd"));
        animals.add(new Dog("Tom", "Royal Canin", "Rex", "Husky"));
        animals.add(new Dog("Jay", "Purina ONE", "Max", "Husky"));
        animals.add(new Cat("Zoe", "9Lives", "Ada"));
        animals.add(new Cat("Ada", "Purina Friskies", "Zoe"));
        animals.add(new Bird("Chicken", "Meg", "Purina Layena", "Lis", true, false, 0.4));
        animals.add(new Bird("Chicken", "Lis", "Manna Pro", "Meg", true, false, 0.35));
        animals.add(new Bird("Chicken", "Emi", "Purina Layena", "Lua", false, false, 0.25));
        animals.add(new Bird("Chicken", "Lua", "Manna Pro", "Emi", false, false, 0.3));
        animals.add(new Bird("Rooster", "Bob", "Manna Pro", "", 0.5));
        animals.add(new Bird("Parrot", "Mac", "Lafeber Original", "Alf", false, true, 0.33));
        animals.add(new Bird("Parrot", "Alf", "Kaytee Fiesta", "Mac", false, false, 0.25));
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
