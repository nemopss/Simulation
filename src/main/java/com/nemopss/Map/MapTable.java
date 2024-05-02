package com.nemopss.Map;

import com.nemopss.Entities.Entity;
import com.nemopss.Misc.Coordinates;

import java.util.*;

public class MapTable {
    private Map<Coordinates, Entity> map;
    private Coordinates mapSize;

    public MapTable() {
        map = new HashMap<>();
        mapSize = new Coordinates(10, 10);
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

    public Map<Coordinates, Entity> getMap() {
        return map;
    }


    public List<Integer> getListOfCoordinatesInHash() {
        List<Integer> hashes = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry: map.entrySet()) {
            hashes.add(entry.getKey().hash());
        }
        return hashes;
    }

    public Entity entityAt(Coordinates coordinates) {
        for (Map.Entry<Coordinates, Entity> entry: map.entrySet()) {
            if (entry.getKey().equals(coordinates)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Coordinates getMapSize() {
        return mapSize;
    }
}
