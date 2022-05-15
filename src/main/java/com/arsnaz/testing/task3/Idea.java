package com.arsnaz.testing.task3;

import java.util.Date;
import java.util.Objects;

public abstract class Idea {
    private final Date creationTime = new Date();
    private final Creator creator;

    public Idea(Creator creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Idea idea = (Idea) o;
        return Objects.equals(creationTime, idea.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationTime);
    }
}
