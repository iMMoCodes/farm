package com.farm;

public class Chicken extends Animal {
    String laysEggs;
    double wingSpan;

    public Chicken(String name, String favoriteFood, String bestFriendForever, String laysEggs, double wingSpan) {
        super(name, favoriteFood, bestFriendForever);
        this.wingSpan = wingSpan;
        this.laysEggs = laysEggs;
    }

    @Override
    public String toString() {
        return "Chicken \n Name= " + name +
                "\nFavorite Food= " + favoriteFood +
                "\nBest Friend Forever= " + bestFriendForever +
                "\nLays eggs= " + laysEggs +
                "\nWingspan= " + wingSpan + "m\n";
    }

}
