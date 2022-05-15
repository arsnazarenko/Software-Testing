package com.arsnaz.testing.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HumanTest {

    private Human human;

    @BeforeEach
    void setUp() {
        this.human = new Human(new WorldTrue());
    }


    @Test
    public void getIdeasCountReturnsOne() {
        human.createWheel(132);
        Assertions.assertEquals(human.getIdeasCount(), 1);
    }

    @Test
    public void newTownCreated() {
        Idea town = human.createTown("Spb");
        Assertions.assertEquals(town, new Town("Spb", human));
    }


    @Test
    public void newWarCreated() {
        Participant f = new Coalition(new Country(Nation.RUSSIA, 1000), new Country(Nation.UKRAINE, 1500));
        Participant s = new Country(Nation.USA, 2000);
        Idea war = human.createWar(f, s);
        Assertions.assertEquals(war, new War(f, s, human));
    }

    @Test
    public void newWheelCreated() {
        Idea idea = human.createWheel(12);
        Assertions.assertEquals(idea, new Wheel(12, human));
    }

}
