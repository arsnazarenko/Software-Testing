package com.arsnaz.testing.task3;

import java.util.Objects;

public class Country extends Participant {

    private final Nation nation;

    public Country(Nation nation, long warriorsCount) {
        super(warriorsCount);
        this.nation = nation;
    }

    public Nation getNation() {
        return nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return nation == country.nation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nation);
    }
}
