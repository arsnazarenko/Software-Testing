package com.arsnaz.testing.task3;

import java.util.ArrayList;

public class WorldTrue {
    private final ArrayList<Idea> humanIdeas = new ArrayList<>();
    private final ArrayList<Idea> dolphinIdeas = new ArrayList<>();



    public void addDolphinIdea(Idea idea) {
        this.dolphinIdeas.add(idea);
    }

    public long getDolphinIdeasCount() {
        return this.dolphinIdeas.size();
    }

    public void addHumanIdea(Idea idea) {
        this.humanIdeas.add(idea);
    }

    public long getHumanIdeasCount() {
        return this.humanIdeas.size();
    }

    public int getTrue() {
        return Integer.compare(humanIdeas.size(), dolphinIdeas.size());
    }
}
