package com.arsnaz.testing.task3;

import java.util.Objects;

public class Action extends Idea {

    private final String descr;

    public Action(String descr, Creator creator) {
        super(creator);
        this.descr = descr;
    }

}
