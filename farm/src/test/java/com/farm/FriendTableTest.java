package com.farm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.farm.animals.Animal;

import org.junit.Test;

public class FriendTableTest {
    @Test
    public void testPrint() {
        final List<Animal> animals = new AnimalList().getAnimals();
        assertTrue("First animal is Rex", animals.get(0).getName().equals("Rex"));
        assertTrue("Second animal is Max", animals.get(1).getName().equals("Max"));
    }
}
