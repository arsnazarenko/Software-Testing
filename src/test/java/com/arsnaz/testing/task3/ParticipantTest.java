package com.arsnaz.testing.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    public void warriorsCountOfCoalitionEqualSumOfWarriors() {
        long count1 = 1000, count2 = 1000, count3 = 1000;
        Participant coal = new Coalition(
                new Country(Nation.USA, count1),
                new Country(Nation.RUSSIA, count2),
                new Country(Nation.JAPAN, count3));
        Assertions.assertEquals(coal.getWarriorsCount(), count1 + count2 + count3);
    }
}
