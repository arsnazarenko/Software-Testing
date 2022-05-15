package com.arsnaz.testing.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DolphinTest {

    private Dolphin dolphin;

    @BeforeEach
    void setUp() {

        this.dolphin = new Dolphin(new WorldTrue());
    }

    @Test
    void getIdeasCountReturnsOneAfter() {
        dolphin.createAction("swim");
        Assertions.assertEquals(dolphin.getIdeasCount(), 1);
    }


    @Test
    void getIdeasCountReturnZero() {
        Assertions.assertEquals(dolphin.getIdeasCount(),0);
    }




}
