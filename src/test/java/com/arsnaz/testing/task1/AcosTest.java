package com.arsnaz.testing.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class AcosTest {
    private final double EPS = 0.00001;

    @Test
    public void nanValueCheck() {
        Assertions.assertEquals(OwnAcos.acos(Double.NaN), Double.NaN);
    }

    @Test
    public void posInfinityValueCheck() {
        Assertions.assertEquals(OwnAcos.acos(Double.POSITIVE_INFINITY), Double.NaN);
    }

    @Test
    public void negInfinityValueCheck() {
        Assertions.assertEquals(OwnAcos.acos(Double.NEGATIVE_INFINITY), Double.NaN);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.001, -1.1, -5})
    public void negativeValuesOutOfRangeCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.98, -0.91})
    public void negativeValuesCloseToLeftBorderCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5, -0.1, -0.01})
    public void negativeValuesCloseToZeroCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 0.1, 0.01})
    public void positiveValuesCloseToZeroCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.001, 1.1, 5})
    public void positiveValuesOutOfRangeCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.91, 0.98})
    public void positiveValuesCloseToRightBorderCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -0.001, 0.001})
    public void zeroValueCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.552, -0.519, 0.31, -0.31})
    public void middlePointsCheck(double value) {
        Assertions.assertEquals(Math.acos(value), OwnAcos.acos(value), EPS);
    }

}
