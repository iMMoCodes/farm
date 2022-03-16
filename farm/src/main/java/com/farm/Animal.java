package com.farm;

import java.util.HashSet;
import java.util.Set;

public class Animal {
    String name;
    String favoriteFood;
    String bestFriendForever;
    Set<String> friendList = new HashSet<>();

    public Animal(String name, String favoriteFood, String bestFriendForever) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.bestFriendForever = bestFriendForever;
        this.friendList.add(bestFriendForever);
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getBestFriendForever() {
        return bestFriendForever;
    }

    public Set<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(Set<String> friendList) {
        this.friendList = friendList;
    }

}
