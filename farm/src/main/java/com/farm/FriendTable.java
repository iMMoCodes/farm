package com.farm;

import java.util.List;

import com.farm.animals.Animal;

public class FriendTable {
    public static void print(int day, List<Animal> animals) {
        System.out.println("\n" + "----- Day-" + day + " Friends ----- \n");
        System.out.printf("    ");

        // Header
        for (int header = 0; header < animals.size(); header++) {
            final Animal headerAnimal = animals.get(header);
            System.out.print("    " + headerAnimal.getName());
        }
        System.out.println();

        for (int i = 0; i < 98; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Body
        for (int row = 0; row < animals.size(); row++) {
            final Animal animalInRow = animals.get(row);
            System.out.print(" " + animalInRow.getName() + " | ");
            for (int col = 1; col <= animals.size(); col++) {
                final Animal animalInColumn = animals.get(col - 1);
                // \\ if own name
                if (animalInColumn.getName().equals(animalInRow.getName())) {
                    System.out.print("  \\   |");
                    // X if friends
                } else if (animalInColumn.getFriendList().contains(animalInRow.getName())) {
                    System.out.print("  X   |");
                } else {
                    // Empty if not friends
                    System.out.print("      |");
                }
            }
            System.out.println();
        }
    }
}
