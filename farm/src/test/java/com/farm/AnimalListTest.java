package com.farm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.farm.animals.Animal;

import org.junit.Test;

public class AnimalListTest {
    @Test
    public void testGetAnimals() {
        final List<Animal> animals = new AnimalList().getAnimals();

        assertFalse("Friendlist is not empty", animals.get(0).getFriendList().isEmpty());
        assertEquals("Animals are added correctly to the animals list", 13, animals.size());
        assertTrue("Friendlist contains best friend",
                animals.get(0).getFriendList().contains(animals.get(0).getBestFriendForever()));
    }
}
