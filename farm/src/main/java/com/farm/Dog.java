package com.farm;

public class Dog extends Animal {
    String breed;

    public Dog(String name, String favoriteFood, String bestFriendForever, String breed) {
        super(name, favoriteFood, bestFriendForever);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog\nName= " + name +
                "\nFavorite Food= " + favoriteFood +
                "\nBest Friend Forever= " + bestFriendForever +
                "\nbreed= " + breed +
                "\n";
    }
}
