package com.arsnaz.testing.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarTest {

    private Human human;

    @BeforeEach
    void setUp() {
        this.human = new Human(new WorldTrue());
    }

    @Test
    void runReturnsFirstCountryHaveMoreWarriors() {
        Participant f = new Country(Nation.RUSSIA, 1000);
        Participant s = new Country(Nation.USA, 100);
        War war = new War(f, s, human);
        Participant winner = war.run();
        Assertions.assertEquals(winner, f);
    }

    @Test
    void runReturnsFirstCountryForCoalitionHaveMoreWarriors() {
        Participant f = new Coalition(new Country(Nation.RUSSIA, 1000), new Country(Nation.UKRAINE, 1500));
        Participant s = new Country(Nation.USA, 2000);
        War war = new War(f, s, human);
        Participant winner = war.run();
        Assertions.assertEquals(winner, f);
    }

    @Test
    void runReturnsSecondCountryWhenHaveMoreWarriors() {
        Participant f = new Country(Nation.UKRAINE, 1500);
        Participant s = new Country(Nation.USA, 2000);
        War war = new War(f, s, human);
        Participant winner = war.run();
        Assertions.assertEquals(winner, s);
    }

    @Test
    void runReturnsNullWhenEqualWarriorsCount() {
        Participant f = new Country(Nation.RUSSIA, 2000);
        Participant s = new Country(Nation.USA, 2000);
        War war = new War(f, s, human);
        Participant winner = war.run();
        Assertions.assertNull(winner);
    }

    @Test
    void runReturnsNullForCoalitionEqualWarriorsCount() {
        Participant f = new Coalition(new Country(Nation.RUSSIA, 1000), new Country(Nation.UKRAINE, 1000));
        Participant s = new Country(Nation.USA, 2000);
        War war = new War(f, s, human);
        Participant winner = war.run();
        Assertions.assertNull(winner);
    }

    @Test
    void createWarWithNullReturnsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new War(null, null, human));
    }


}
