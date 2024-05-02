package com.nemopss.Map;

import com.nemopss.Entities.Entity;
import com.nemopss.Entities.Floor;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MapTable {
    private List<Entity> map;
    private List<Integer> mapSize;

    public MapTable() {
        map = new ArrayList<>();
        mapSize = Arrays.asList(10, 10);
        for (int i = 0; i < mapSize.get(0); i++) {
            for (int j = 0; j < mapSize.get(1); j++) {
                map.add(new Floor(j, i));
            }
        }
    }

    public void addEntity(Entity e) {
        if (entityAt(e.getCoordinates()) instanceof Floor) {
            this.removeAt(e.getCoordinates());
        }
        map.add(e);
    }

    public void removeAt(List<Integer> coordinates) {
        map.removeIf(e -> e.getCoordinates().equals(coordinates));
    }
    public void removeEntity(Entity e) {
        map.remove(e);
        map.add(new Floor(e.getCoordinates().get(0), e.getCoordinates().get(1)));
    }

    public void displayDebugMap() {
        for (Entity entity: map) {
            System.out.println(entity.getCoordinates() + ", Entity type=" + entity);
        }
    }

    public List<Entity> getMap() {
        return map;
    }

    public Entity entityAt(List<Integer> coordinates) {
        for (Entity entity: map) {
            if (entity.getCoordinates().equals(coordinates)) {
                return entity;
            }
        }
        return null;
    }

    public List<Integer> getMapSize() {
        return mapSize;
    }

    public void remove() {

    }
}
