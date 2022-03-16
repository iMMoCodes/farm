package com.farm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalTest {
    @Test
    public void testGetFriendList() {
        Animal animal = new Animal("Jerry", "Cheese", "Tom");
        assertEquals("Friendlist length is one at the beginning", 1, animal.getFriendList().size());
        ;
    }
}
