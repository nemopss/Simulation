package com.nemopss.Entities;

public abstract class Creature extends Entity {
    private int HP;
    private int speed;

    public Creature(int x, int y) {
        super(x, y);
    }

    public abstract void makeMove();
    public void findFood(Entity food) {

    };
}
