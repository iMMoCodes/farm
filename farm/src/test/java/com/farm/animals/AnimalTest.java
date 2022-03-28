package com.farm.animals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.farm.AnimalList;

import org.junit.Test;

public class AnimalTest {
    final List<Animal> animals = new AnimalList().getAnimals();

    @Test
    public void testGetBestFriendForever() {
        assertEquals("Rex's best friend is Tom", "Tom", animals.get(0).getBestFriendForever());
        assertEquals("Zoe's best friend is Ada", "Ada", animals.get(4).getBestFriendForever());
    }

    @Test
    public void testGetFavoriteFood() {
        assertEquals("Rex's favorite food is Royal Canin", "Royal Canin", animals.get(0).getFavoriteFood());
        assertEquals("Zoe's favorite food is 9Lives", "9Lives", animals.get(4).getFavoriteFood());
    }

    @Test
    public void testGetFriendList() {
        assertEquals("Length of friendlist at beginning is 1", 1, animals.get(0).getFriendList().size());
        assertEquals("Alf's friendlist at the beginning also works", 1,
                animals.get(12).getFriendList().size());
        assertTrue("Rex's best friend is Tom", animals.get(0).getFriendList().contains("Tom"));
    }

    @Test
    public void testGetName() {
        assertEquals("Rex's getName gives Rex", "Rex", animals.get(0).getName());
        assertEquals("Alf's getName gives Alf", "Alf", animals.get(12).getName());
    }

    @Test
    public void testRemoveFriend() {
        Random random = new Random();
        final Animal currentAnimal = animals.get(0);
        currentAnimal.getFriendList().add("Zoe");
        animals.get(4).getFriendList().add("Rex");
        assertEquals("Rex's friendlist is now 2 long", 2, currentAnimal.getFriendList().size());
        assertEquals("Zoe's friendlist is now 2 long", 2, animals.get(4).getFriendList().size());
        final Set<String> friendListOfCurrentAnimal = currentAnimal.getFriendList();
        int indexOfFriendToRemove = random.nextInt(friendListOfCurrentAnimal.size());
        String nameOfFriendToRemove = friendListOfCurrentAnimal.toArray()[indexOfFriendToRemove].toString();

        while (nameOfFriendToRemove.equals(currentAnimal.getBestFriendForever())) {
            indexOfFriendToRemove = random.nextInt(friendListOfCurrentAnimal.size());
            nameOfFriendToRemove = friendListOfCurrentAnimal
                    .toArray()[indexOfFriendToRemove].toString();
        }
        assertFalse("Doesn't remove Rex", nameOfFriendToRemove.equals("Rex"));
        assertFalse("Doesn't remove Tom", nameOfFriendToRemove.equals("Tom"));
        assertEquals("Zoe", nameOfFriendToRemove);
        friendListOfCurrentAnimal.remove(nameOfFriendToRemove);
        for (Animal animal : animals) {
            if (animal.getName().equals(nameOfFriendToRemove)) {
                animal.getFriendList().remove(currentAnimal.getName());
            }
        }
        assertEquals("Zoe is removed from Rex's friendlist", 1, currentAnimal.getFriendList().size());
        assertEquals("Rex is also removed from Zoe's friendlist ", 1, animals.get(4).getFriendList().size());
    }

    @Test
    public void testAddFriend() {
        Random random = new Random();
        final Animal currentAnimal = animals.get(0);
        final Set<String> friendListOfCurrentAnimal = currentAnimal.getFriendList();
        int indexOfFriendToAdd = random.nextInt(animals.size());
        Animal friendToAdd = animals.get(indexOfFriendToAdd);

        while (friendToAdd.getName().equals(currentAnimal.getName())
                || friendListOfCurrentAnimal.contains(friendToAdd.getName())) {
            indexOfFriendToAdd = random.nextInt(animals.size());
            friendToAdd = animals.get(indexOfFriendToAdd);
        }
        assertFalse("Friends name to add is not Rex", friendToAdd.getName().equals("Rex"));
        friendListOfCurrentAnimal.add(friendToAdd.getName());
        assertEquals("Length of Rex's friendlist is now 2", 2, currentAnimal.getFriendList().size());
        assertTrue("Animals name is added to Rex's friendlist",
                currentAnimal.getFriendList().contains(friendToAdd.getName()));
        friendToAdd.getFriendList().add(currentAnimal.getName());
        assertEquals("Length of another animals friendlist is now 2", 2, friendToAdd.getFriendList().size());
        assertTrue("Rex's name is added to another animals friendlist", friendToAdd.getFriendList().contains("Rex"));
    }
}
