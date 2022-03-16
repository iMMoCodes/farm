package com.farm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // < ----- Create animals ----- >
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Rex", "Royal Canin", "Tom", "Shepherd"));
        animals.add(new Dog("Max", "Purina ONE", "Jay", "Shepherd"));
        animals.add(new Dog("Tom", "Royal Canin", "Rex", "Husky"));
        animals.add(new Dog("Jay", "Purina ONE", "Max", "Husky"));
        animals.add(new Cat("Zoe", "Purina Friskies", "Ada"));
        animals.add(new Cat("Ada", "Purina Friskies", "Zoe"));
        animals.add(new Chicken("Meg", "Purina Layena", "Lis", "yes", 0.4));
        animals.add(new Chicken("Lis", "Manna Pro", "Meg", "yes", 0.35));
        animals.add(new Chicken("Emi", "Purina Layena", "Lua", "no", 0.25));
        animals.add(new Chicken("Lua", "Manna Pro", "Emi", "no", 0.3));
        animals.add(new Rooster("Bob", "Manna Pro", "", 0.5));
        animals.add(new Parrot("Mac", "Lafeber Original", "Alf", "yes", 0.33));
        animals.add(new Parrot("Alf", "Kaytee Fiesta", "Mac", "no", 0.25));

        int day = 1;
        Random random = new Random();

        // < ----- Print all animals when program starts ----- >
        System.out.println("----- Animals at farm -----");
        animals.forEach(System.out::println);

        while (day <= 10) {
            // < ----- Remove friends ----- >
            System.out.println("\n" + "----- Day-" + day + " unfriend requests ----- \n");
            for (int currentLoopIndex = 0; currentLoopIndex < animals.size(); currentLoopIndex++) {
                Animal currentAnimal = animals.get(currentLoopIndex);
                // Friendlist contains only best friend
                if (currentAnimal.getFriendList().size() <= 1) {
                    continue;
                } else {
                    int indexOfFriendToRemove = random.nextInt(currentAnimal.getFriendList().size());
                    String nameOfFriendToRemove = animals.get(currentLoopIndex).getFriendList()
                            .toArray()[indexOfFriendToRemove].toString();

                    while (nameOfFriendToRemove == currentAnimal.getBestFriendForever()) {
                        indexOfFriendToRemove = random.nextInt(currentAnimal.getFriendList().size());
                        nameOfFriendToRemove = animals.get(currentLoopIndex).getFriendList()
                                .toArray()[indexOfFriendToRemove].toString();
                    }

                    // Chance to send request
                    boolean chanceToSendRequest;
                    if (currentAnimal.getFriendList().size() <= 2) {
                        chanceToSendRequest = !(random.nextInt(10) == 0);
                    } else {
                        chanceToSendRequest = (random.nextInt(10) == 0);
                    }

                    if (chanceToSendRequest) {
                        currentAnimal.getFriendList().remove(nameOfFriendToRemove);
                        System.out.println(currentAnimal.getName() + " and " + nameOfFriendToRemove
                                + " are not friends anymore. ");
                    }

                }
            }

            // < ----- Print animals based on their food ----- >
            System.out.println("\n----- Lunch time ----- \n");
            // Group animals by food they are eating
            Map<String, List<Animal>> animalByFood = new HashMap<>();
            animalByFood = animals.stream().collect(Collectors.groupingBy(Animal::getFavoriteFood));

            for (int i = 0; i < animalByFood.size(); i++) {
                String foodName = animalByFood.keySet().toArray()[i].toString();

                String namesOfAnimalsEatingFood = animals.stream()
                        .filter(animal -> foodName.equals(animal.getFavoriteFood()))
                        .map(animal -> animal.getName())
                        .collect(Collectors.joining(" and "));

                if (namesOfAnimalsEatingFood.contains(" and ")) {
                    System.out.println(namesOfAnimalsEatingFood + " are eating " + foodName);
                } else {
                    System.out.println(namesOfAnimalsEatingFood + " is eating " + foodName);
                }
            }

            // < ----- Send friend requests ----- >
            System.out.println("\n----- Day-" + day + " friend requests ----- \n");
            for (int currentLoopIndex = 0; currentLoopIndex < animals.size(); currentLoopIndex++) {
                Animal currentAnimal = animals.get(currentLoopIndex);
                Set<String> friendListOfCurrentAnimal = currentAnimal.getFriendList();
                int indexOfFriendToAdd = random.nextInt(animals.size());
                Animal friendToAdd = animals.get(indexOfFriendToAdd);

                // Get random animal
                while (friendToAdd.getName() == currentAnimal.getName()
                        || friendListOfCurrentAnimal.contains(friendToAdd.getName())) {
                    indexOfFriendToAdd = random.nextInt(animals.size());
                    friendToAdd = animals.get(indexOfFriendToAdd);
                }

                // Chance to send request
                boolean chanceToSendRequest;
                if (friendListOfCurrentAnimal.size() <= 2) {
                    chanceToSendRequest = !(random.nextInt(10) == 0);
                } else {
                    chanceToSendRequest = (random.nextInt(10) == 0);
                }

                // Chance to accept friend request
                boolean chanceToAcceptRequest;
                if (friendToAdd.getFriendList().size() <= 2) {
                    chanceToAcceptRequest = !(random.nextInt(10) == 0);
                } else {
                    chanceToAcceptRequest = (random.nextInt(10) == 0);
                }

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

            // < ----- Table of friends ----- >
            System.out.println("\n" + "----- Day-" + day + " Friends ----- \n");
            // Create header
            System.out.printf("    ");
            for (int header = 0; header < animals.size(); header++) {
                Animal headerAnimal = animals.get(header);
                System.out.print("    " + headerAnimal.getName());
            }
            System.out.println();
            for (int i = 0; i < 98; i++) {
                System.out.print("-");
            }
            System.out.println();
            // Create table
            for (int row = 0; row < animals.size(); row++) {
                Animal animalInRow = animals.get(row);
                System.out.print(" " + animalInRow.getName() + " | ");
                for (int col = 1; col <= animals.size(); col++) {
                    Animal animalInColumn = animals.get(col - 1);
                    // \\ if own name
                    if (animalInColumn.getName().equals(animalInRow.getName())) {
                        System.out.print("  \\   |");
                        // X if friends
                    } else if (animalInColumn.friendList.contains(animalInRow.getName())) {
                        System.out.print("  X   |");
                    } else {
                        // Empty if not friends
                        System.out.print("      |");
                    }
                }
                System.out.println();
            }
            // Increase day
            day++;
        }
    }
}
