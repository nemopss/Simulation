package com.nemopss.Map;

import com.nemopss.Entities.Entity;
import com.nemopss.Misc.Coordinates;

import java.util.*;

public class MapTable {
    private Map<Coordinates, Entity> map;

    public MapTable() {
        map = new HashMap<>();
    }

    public void addEntity( Entity e, Coordinates coordinates) {
        e.setCoordinates(coordinates);
        map.put(coordinates, e);
    }

    public void deleteEntity(Entity e) {
        map.remove(e.getCoordinates());
    }

    public void displayDebugMap() {
        for (Map.Entry<Coordinates, Entity> entity: map.entrySet()) {
            System.out.println(entity.getKey() + " Entity type=" + entity.getValue());
        }
    }
}
