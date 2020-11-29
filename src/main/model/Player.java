package main.model;


import main.RockScissorsPaper;

public abstract class Player {
    protected static int id = 0;
    public RockScissorsPaper rockScissorsPaper;
    protected String name;


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Player.id = id;
    }

    public RockScissorsPaper getRockScissorsPaper() {
        return rockScissorsPaper;
    }

    public void setRockScissorsPaper(RockScissorsPaper rockScissorsPaper) {
        this.rockScissorsPaper = rockScissorsPaper;
    }

    public String getName(){
        return name;
    }
}
