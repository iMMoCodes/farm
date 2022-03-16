package com.farm;

public class Parrot extends Animal {
    String canSpeak;
    double wingSpan;

    public Parrot(String name, String favoriteFood, String bestFriendForever, String canSpeak, double wingSpan) {
        super(name, favoriteFood, bestFriendForever);
        this.canSpeak = canSpeak;
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        return "Chicken \nName= " + name +
                "\nFavorite Food= " + favoriteFood +
                "\nBest Friend Forever= " + bestFriendForever +
                "\nCan speak= " + canSpeak +
                "\nWingspan= " + wingSpan + "m\n";
    }
}
