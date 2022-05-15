package com.arsnaz.testing.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorldTrueTest {
    private WorldTrue worldTrue;
    private Human h;
    private Dolphin d;

    @BeforeEach
    void setUp() {
        this.worldTrue = new WorldTrue();
        this.d = new Dolphin(worldTrue);
        this.h = new Human(worldTrue);
    }

    @Test
    void getTrueReturnsOneWhenHumansHaveMoreIdeas() {
        h.createTown("Spb");
        h.createWheel(20);
        h.createTown("Serov");
        h.createTown("Msc");
        d.createAction("swim");
        Assertions.assertEquals(1, worldTrue.getTrue());
    }

    @Test
    void getTrueReturnZeroEqualIdeasCount() {
        h.createTown("Spb");
        h.createTown("Serov");
        d.createAction("swim");
        d.createAction("chill");
        Assertions.assertEquals(0, worldTrue.getTrue());
    }

    @Test
    void getTrueReturnsMinusOneWhenDolphinsHaveMoreIdeas() {
        h.createTown("Spb");
        h.createTown("Serov");
        d.createAction("swim");
        d.createAction("fun");
        d.createAction("chill");
        Assertions.assertEquals(-1, worldTrue.getTrue());
    }


}
