package com.farm.animals;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Animal {
    private String name;
    private String favoriteFood;
    private String bestFriendForever;
    private Set<String> friendList = new HashSet<>();

    public Animal(String name, String favoriteFood, String bestFriendForever) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.bestFriendForever = bestFriendForever;
        this.friendList.add(bestFriendForever);
    }

    public static void removeFriend(int day, List<Animal> animals) {
        Random random = new Random();
        System.out.println("\n" + "----- Day-" + day + " unfriend requests ----- \n");
        for (int currentLoopIndex = 0; currentLoopIndex < animals.size(); currentLoopIndex++) {
            final Animal currentAnimal = animals.get(currentLoopIndex);
            final Set<String> friendListOfCurrentAnimal = currentAnimal.getFriendList();
            int indexOfFriendToRemove = random.nextInt(friendListOfCurrentAnimal.size());
            String nameOfFriendToRemove = friendListOfCurrentAnimal.toArray()[indexOfFriendToRemove].toString();

            // Friendlist contains only best friend
            if (friendListOfCurrentAnimal.size() <= 1) {
                continue;
            } else {
                while (nameOfFriendToRemove.equals(currentAnimal.getBestFriendForever())) {
                    indexOfFriendToRemove = random.nextInt(friendListOfCurrentAnimal.size());
                    nameOfFriendToRemove = friendListOfCurrentAnimal
                            .toArray()[indexOfFriendToRemove].toString();
                }
                // Chance to send request
                final boolean chanceToSendRequest = getChancesForRequests(friendListOfCurrentAnimal);
                if (chanceToSendRequest) {
                    friendListOfCurrentAnimal.remove(nameOfFriendToRemove);
                    for (Animal animal : animals) {
                        if (animal.getName().equals(nameOfFriendToRemove)) {
                            animal.getFriendList().remove(currentAnimal.getName());
                        }
                    }
                    System.out.println(currentAnimal.getName() + " and " + nameOfFriendToRemove
                            + " are not friends anymore. ");
                }
            }
        }
    }

    public static void addFriend(int day, List<Animal> animals) {
        Random random = new Random();
        System.out.println("\n----- Day-" + day + " friend requests ----- \n");
        for (int currentLoopIndex = 0; currentLoopIndex < animals.size(); currentLoopIndex++) {
            final Animal currentAnimal = animals.get(currentLoopIndex);
            final Set<String> friendListOfCurrentAnimal = currentAnimal.getFriendList();
            int indexOfFriendToAdd = random.nextInt(animals.size());
            Animal friendToAdd = animals.get(indexOfFriendToAdd);

            // Get random animal
            while (friendToAdd.getName().equals(currentAnimal.getName())
                    || friendListOfCurrentAnimal.contains(friendToAdd.getName())) {
                indexOfFriendToAdd = random.nextInt(animals.size());
                friendToAdd = animals.get(indexOfFriendToAdd);
            }

            // Chances for requests
            final boolean chanceToSendRequest = getChancesForRequests(friendListOfCurrentAnimal);
            final boolean chanceToAcceptRequest = getChancesForRequests(friendListOfCurrentAnimal);

            // Handle adding friend logic and messages
            if (chanceToSendRequest) {
                System.out.print(
                        currentAnimal.getName() + " is asking " + friendToAdd.getName() + " to be friends. ");
                // Requst is sent
                if (chanceToAcceptRequest) {
                    friendListOfCurrentAnimal.add(friendToAdd.getName());
                    friendToAdd.getFriendList().add(currentAnimal.getName());
                    System.out.print(
                            currentAnimal.getName() + " and " + friendToAdd.getName() + " are friends now. ");
                } else {
                    System.out.print(friendToAdd.getName() + " doesn't want to be friends. ");
                }
                // Didn't send request
            } else {
                System.out
                        .print(currentAnimal.getName() + " didn't feel like making friends today. ");
            }
            System.out.println();
        }
    }

    private static boolean getChancesForRequests(Set<String> friendListOfCurrentAnimal) {
        Random random = new Random();
        if (friendListOfCurrentAnimal.size() <= 2) {
            return random.nextInt(10) != 0;
        } else {
            return random.nextInt(10) == 0;
        }
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

    @Override
    public String toString() {
        return "\nname = " + name +
                "\nfavoriteFood = " + favoriteFood +
                "\nbestFriendForever = " + bestFriendForever +
                "\n";
    }

}
