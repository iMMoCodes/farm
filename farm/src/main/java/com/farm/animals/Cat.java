package com.farm.animals;

public class Cat extends Animal {

    public Cat(String name, String favoriteFood, String bestFriendForever) {
        super(name, favoriteFood, bestFriendForever);
    }

    @Override
    public String toString() {
        return "Cat" + super.toString();
    }

}
