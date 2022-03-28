package com.farm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.farm.animals.Animal;

import org.junit.Test;

public class AnimalsByFoodTest {
    @Test
    public void testPrintAnimalsByFood() {
        final List<Animal> animals = new AnimalList().getAnimals();
        Map<String, List<Animal>> animalByFood = new HashMap<>();
        animalByFood = animals.stream().collect(Collectors.groupingBy(Animal::getFavoriteFood));

        assertEquals("There are 8 different food groups", 8, animalByFood.keySet().size());
        assertTrue("Foods are are assigned to keyset", animalByFood.keySet().contains("Purina ONE"));
        assertEquals("Two are eating Royal Canin", 2, animalByFood.get("Royal Canin").size());
        assertEquals("One is eating 9Lives", 1, animalByFood.get("9Lives").size());
    }
}
