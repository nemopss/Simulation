package com.nemopss.Map;

import com.nemopss.Entities.*;

import java.util.*;
import java.util.List;

public class MapTable {
    private List<Entity> map;
    private List<Integer> mapSize;

    public MapTable() {
        map = new ArrayList<>();
        mapSize = Arrays.asList(20, 20);
        for (int i = 0; i < mapSize.get(0); i++) {
            for (int j = 0; j < mapSize.get(1); j++) {
                map.add(new Floor(j, i));
            }
        }
    }

    public void moveTo(Entity e, List<Integer> coordinates) {
        addEntity(new Floor(e.getCoordinates().get(0), e.getCoordinates().get(1)));
        e.setCoordinates(coordinates);
        addEntity(e);
    }

    public void addEntity(Entity e) {
        this.removeAt(e.getCoordinates());
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
    private List<Entity> getNeighbors(Entity entity) {
        List<Entity> neighbors = new ArrayList<>();
        int mapWidth = this.getWidth(); // Ширина карты
        int mapHeight = this.getHeigth(); // Высота карты

        // Проверяем соседей по горизонтали
        for (int dx = -1; dx <= 1; dx += 2) {
            int neighborX = entity.getCoordinates().get(0) + dx;
            if (neighborX >= 0 && neighborX < mapWidth) {
                Entity horizontalNeighbor = entityAt(Arrays.asList(neighborX, entity.getCoordinates().get(1)));
                if (horizontalNeighbor != null && !isRockOrTree(horizontalNeighbor)) {
                    neighbors.add(horizontalNeighbor);
                }
            }
        }

        // Проверяем соседей по вертикали
        for (int dy = -1; dy <= 1; dy += 2) {
            int neighborY = entity.getCoordinates().get(1) + dy;
            if (neighborY >= 0 && neighborY < mapHeight) {
                Entity verticalNeighbor = entityAt(Arrays.asList(entity.getCoordinates().get(0), neighborY));
                if (verticalNeighbor != null && !isRockOrTree(verticalNeighbor)) {
                    neighbors.add(verticalNeighbor);
                }
            }
        }

        return neighbors;
    }

    public Map<Entity, List<Entity>> getMapGraph() {
        Map<Entity, List<Entity>> graph = new HashMap<>();

        // Создаем граф на основе соседей каждой сущности в списке
        for (Entity entity : map) {
            if (entity instanceof Rock || entity instanceof Tree) {
                continue;
            }
            List<Entity> neighbors = getNeighbors(entity);
            graph.put(entity, neighbors);
        }

        return graph;
    }

    public boolean isRockOrTree(Entity e) {
        return Objects.equals(e.toString(), "\uD83E\uDEA8") || Objects.equals(e.toString(), "\uD83C\uDF33");
    }

    public void printMapGraph() {
        for (Map.Entry<Entity, List<Entity>> entry: getMapGraph().entrySet()) {
            System.out.println(entry);
        }
    }

    public int getWidth(){
        return this.mapSize.get(0);
    }

    public int getHeigth(){
        return this.mapSize.get(1);
    }

    public Herbivore getHerbivore() {
        for (Entity entity: map) {
            if (entity instanceof Herbivore) {
                return (Herbivore) entity;
            }
        }
        return null;
    }

    public Predator getPredator() {
        for (Entity entity: map) {
            if (entity instanceof Predator) {
                return (Predator) entity;
            }
        }
        return null;
    }
}
