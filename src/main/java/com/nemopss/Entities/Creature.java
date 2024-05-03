package com.nemopss.Entities;

import com.nemopss.Map.MapTable;

import java.util.*;

public abstract class Creature extends Entity {
    protected int speed;


    public Creature(int x, int y) {
        super(x, y);
    }

    public Creature() {
    }

    public abstract void makeMove(MapTable map);

    public List<List<Integer>> findFood(Map<Entity, List<Entity>> graph) {
        Queue<Entity> queue = new LinkedList<>();
        Map<Entity, Entity> prev = new HashMap<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Entity current = queue.poll();
            if (this instanceof Herbivore && current instanceof Grass) {
                return reconstructPath(prev, this, current);
            }
            if (this instanceof Predator && current instanceof Herbivore) {
                return reconstructPath(prev, this, current);
            }

            List<Entity> neighbors = graph.get(current);
            if (neighbors != null) {
                for (Entity neighbor : neighbors) {
                    if (!prev.containsKey(neighbor)) {
                        queue.offer(neighbor);
                        prev.put(neighbor, current);
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    private List<List<Integer>> reconstructPath(Map<Entity, Entity> prev, Entity start, Entity target) {
        List<List<Integer>> path = new ArrayList<>();
        Entity current = target;
        while (!current.equals(start)) {
            List<Integer> coordinates = new ArrayList<>();
            coordinates.add(0, current.getCoordinates().get(0));
            coordinates.add(1, current.getCoordinates().get(1));
            path.add(0, coordinates);
            current = prev.get(current);
        }
        List<Integer> startCoordinates = new ArrayList<>();
        startCoordinates.add(0, start.getCoordinates().get(0));
        startCoordinates.add(1, start.getCoordinates().get(1));
        path.add(0, startCoordinates);
        path.remove(0);
        return path;
    }
}
