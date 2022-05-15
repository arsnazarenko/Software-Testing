package com.arsnaz.testing.task3;

import java.util.Arrays;
import java.util.List;

public class Coalition extends Participant {

    private final List<Participant> countries;

    public Coalition(Participant... countries) {
        super(Arrays.stream(countries).map(Participant::getWarriorsCount).reduce(0L, Long::sum));
        this.countries = Arrays.asList(countries);
    }

    public List<Participant> getCountries() {
        return countries;
    }
}
