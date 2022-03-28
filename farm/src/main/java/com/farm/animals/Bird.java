package com.farm.animals;

public class Bird extends Animal {
    private String typeOfBird;
    private boolean laysEggs;
    private boolean canSpeak;
    private double wingSpan;

    public Bird(String typeOfBird, String name, String favoriteFood, String bestFriendForever, double wingSpan) {
        super(name, favoriteFood, bestFriendForever);
        this.typeOfBird = typeOfBird;
        this.wingSpan = wingSpan;
    }

    public Bird(String typeOfBird, String name, String favoriteFood, String bestFriendForever,
            boolean laysEggs, boolean canSpeak, double wingSpan) {
        super(name, favoriteFood, bestFriendForever);
        this.typeOfBird = typeOfBird;
        this.laysEggs = laysEggs;
        this.canSpeak = canSpeak;
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        if (typeOfBird.equals("Chicken")) {
            return typeOfBird + super.toString() +
                    "laysEggs = " + laysEggs +
                    "\nwingSpan = " + wingSpan +
                    "\n";
        } else if (typeOfBird.equals("Rooster")) {
            return typeOfBird + super.toString() +
                    "wingSpan = " + wingSpan +
                    "\n";
        } else {
            return typeOfBird + super.toString() +
                    "canSpeak = " + canSpeak +
                    "\nwingSpan = " + wingSpan +
                    "\n";
        }
    }

}
