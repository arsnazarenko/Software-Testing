package com.arsnaz.testing.task3;

public class Dolphin implements Creator {

    private final WorldTrue dolphinTrue;
    private long ideasCount = 0;

    public Dolphin(WorldTrue dolphinTrue) {
        this.dolphinTrue = dolphinTrue;
    }


    public Action createAction(String descr) {
        Action a = new Action(descr, this);
        dolphinTrue.addDolphinIdea(a);
        ideasCount++;
        return a;
    }

    @Override
    public long getIdeasCount() {
        return this.ideasCount;
    }

    @Override
    public WorldTrue getWorldTrue() {
        return this.dolphinTrue;
    }
}
