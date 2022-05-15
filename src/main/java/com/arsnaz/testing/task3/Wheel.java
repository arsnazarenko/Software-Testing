package com.arsnaz.testing.task3;

public class Wheel extends Idea {

    private final long radius;


    public Wheel(long radius, Creator creator) {
        super(creator);
        if (radius < 0) {
            throw new IllegalArgumentException("radius must be more than zero");
        }
        this.radius = radius;
    }

    public long getRadius() {
        return radius;
    }
}
