package com.arsnaz.testing.task3;

public class Human implements Creator {
    private final WorldTrue humanTrue;
    private long ideasCount = 0;

    public Human(WorldTrue humanTrue) {
        this.humanTrue = humanTrue;
    }

    public Town createTown(String name) {
        Town d = new Town(name, this);
        humanTrue.addHumanIdea(d);
        ideasCount++;
        return d;
    }

    public Wheel createWheel(long radius) {
        Wheel w = new Wheel(radius, this);
        humanTrue.addHumanIdea(w);
        ideasCount++;
        return w;
    }

    public War createWar(Participant f, Participant s) {
        War w = new War(f, s, this);
        humanTrue.addHumanIdea(w);
        ideasCount++;
        return w;
    }

    @Override
    public long getIdeasCount() {
        return this.ideasCount;
    }

    @Override
    public WorldTrue getWorldTrue() {
        return this.humanTrue;
    }
}
