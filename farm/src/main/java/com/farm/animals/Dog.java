package com.farm.animals;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, String favoriteFood, String bestFriendForever, String breed) {
        super(name, favoriteFood, bestFriendForever);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog" + super.toString() +
                "breed = " + breed +
                "\n";
    }
}
