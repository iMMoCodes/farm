package com.farm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnimalTest {
    @Test
    public void testGetFriendList() {
        Animal animal = new Animal("Jerry", "Cheese", "Tom");
        assertFalse("Friendlist is not empty", animal.getFriendList().isEmpty());
        assertEquals("Friendlist length is one at the beginning", 1, animal.getFriendList().size());
        assertTrue("Friendlist contains best friend", animal.getFriendList().contains(animal.getBestFriendForever()));
        ;
    }
}
