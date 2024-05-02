package com.nemopss.Entities;

public abstract class Creature extends Entity {
    private int HP;
    private int speed;

    public abstract void makeMove();
}
