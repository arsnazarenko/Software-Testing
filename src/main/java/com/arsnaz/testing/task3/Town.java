package com.arsnaz.testing.task3;

import java.util.Objects;

public class Town extends Idea {
    private final String name;


    public Town(String name, Creator creator) {
        super(creator);
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Town name can`t be null or null-string");
        }
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
