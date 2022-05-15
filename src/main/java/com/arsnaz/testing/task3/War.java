package com.arsnaz.testing.task3;

import java.util.Objects;

public class War extends Idea {

    private final Participant first;
    private final Participant second;

    public Participant run() {
        if (first.getWarriorsCount() > second.getWarriorsCount()) {
            return first;
        } else if (first.getWarriorsCount() < second.getWarriorsCount()) {
            return second;
        } else {
            return null;
        }
    }

    public War(Participant first, Participant second, Creator creator) {
        super(creator);
        if (first == null || second == null) {
            throw new IllegalArgumentException("participant is null");
        }
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        War war = (War) o;
        return Objects.equals(first, war.first) && Objects.equals(second, war.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
