package com.nemopss.Entities;

import com.nemopss.Misc.Coordinates;

import java.util.Arrays;
import java.util.List;

public abstract class Entity {
    private Coordinates coordinates;

    public Entity(int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
