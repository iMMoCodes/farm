package com.farm;

public class Cat extends Animal {

    public Cat(String name, String favoriteFood, String bestFriendForever) {
        super(name, favoriteFood, bestFriendForever);

    }

    @Override
    public String toString() {
        return "Cat \nName= " + name +
                "\nFavorite Food= " + favoriteFood +
                "\n Best Friend Forever= " + bestFriendForever +
                "\n";
    }

}
