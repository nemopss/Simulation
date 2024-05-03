package com.nemopss.Actions;

import com.nemopss.Entities.*;
import com.nemopss.Map.MapTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class InitAction extends Action {
    private MapTable map;

    public MapTable initMap() {
        map = new MapTable();

        HashMap<Integer, Integer> pool = createMapObjectPool();
        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntitiesToAdd = pool.get(i);
            for (int j = 0; j < amountOfEntitiesToAdd; j++) {
                switch (i) {
                    case 0:
                        map.addEntity(assignRandomCoordinates(new Grass()));
                        break;
                    case 1:
                        map.addEntity(assignRandomCoordinates(new Herbivore()));
                        break;
                    case 2:
                        map.addEntity(assignRandomCoordinates(new Predator()));
                        break;
                    case 3:
                        map.addEntity(assignRandomCoordinates(new Rock()));
                        break;
                    case 4:
                        map.addEntity(assignRandomCoordinates(new Tree()));
                        break;
                    default:
                        break;
                }
            }
        }
        return map;
    }

    private HashMap<Integer, Integer> createMapObjectPool() {
        HashMap<Integer, Integer> pool = new HashMap<>();
        int mapArea = map.getWidth() * map.getHeigth();

        int amountOfGrass = mapArea / 3;
        pool.put(0, amountOfGrass);
        int amountOfHerbivores = amountOfGrass / 5;
        pool.put(1, amountOfHerbivores);
        int amountOfPredators = amountOfHerbivores / 10;
        pool.put(2, amountOfPredators);
        int amountOfStationary = mapArea / 10;
        pool.put(3, amountOfStationary);
        pool.put(4, amountOfStationary);

        return pool;
    }

    private Entity assignRandomCoordinates(Entity e) {
        int maxY = map.getHeigth();
        int maxX = map.getWidth();
        Random random = new Random();
        e.setCoordinates(Arrays.asList(random.nextInt(maxX), random.nextInt(maxY)));
        return e;
    }
}
