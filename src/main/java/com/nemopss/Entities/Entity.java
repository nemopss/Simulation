package com.nemopss.Entities;

import com.nemopss.Map.MapTable;
import com.nemopss.Misc.Coordinates;

import java.util.Arrays;
import java.util.List;

public abstract class Entity {
    private Coordinates coordinates;
    private MapTable map;

    public Entity(int x, int y, MapTable map) {
        this.coordinates = new Coordinates(x, y);
        this.map = map;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public MapTable getMap() {
        return map;
    }
}
