package com.nemopss.Entities;

import java.util.Arrays;
import java.util.List;

public abstract class Entity {
    private int x;
    private int y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Entity() {

    }

    public List<Integer> getCoordinates() {
        return Arrays.asList(x, y);
    }

    public void setCoordinates(List<Integer> coordinates) {
        this.x = coordinates.get(0);
        this.y = coordinates.get(1);
    }

}
