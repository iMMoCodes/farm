package com.farm;

public class Rooster extends Animal {
    double wingSpan;

    public Rooster(String name, String favoriteFood, String bestFriendForever, double wingSpan) {
        super(name, favoriteFood, bestFriendForever);
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        return "Chicken \nName= " + name +
                "\nFavorite Food= " + favoriteFood +
                "\nWingspan= " + wingSpan + "m\n";
    }

}
