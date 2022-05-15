package com.arsnaz.testing.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WheelTest {

    @Test
    void wheelReturnExceptionNegativeRadius() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Wheel(-1, new Human(new WorldTrue())));
    }

}
