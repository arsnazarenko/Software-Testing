package com.arsnaz.testing.task3;


public abstract class Participant {

    private final long warriorsCount;

    public Participant(long warriorsCount) {
        this.warriorsCount = warriorsCount;
    }

    public long getWarriorsCount() {
        return warriorsCount;
    }
}

