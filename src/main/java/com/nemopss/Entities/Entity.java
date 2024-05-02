package com.nemopss.Entities;

import com.nemopss.Misc.Coordinates;

import java.util.Arrays;
import java.util.List;

public abstract class Entity {
    private int x;
    private int y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates getCoordinates() {
        return new Coordinates(x, y);
    }

    public void setCoordinates(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }
}
