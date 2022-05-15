package com.arsnaz.testing.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TownTest {


    @Test
    void createTownWithNullReturnsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Town(null, new Human(new WorldTrue())));
    }


    @Test
    void createTownWithNullStringReturnsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Town("", new Human(new WorldTrue())));
    }



}
