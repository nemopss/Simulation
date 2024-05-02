package com.nemopss.Entities;

import com.nemopss.Map.MapTable;

public abstract class Creature extends Entity {
    private int HP;
    private int speed;


    public Creature(int x, int y) {
        super(x, y);
    }

    public abstract void makeMove();
//    public List<Coordinates> shortestPathToFood(Entity food) {
//        Queue<Coordinates> queue = new LinkedList<>();
//        Map<Coordinates, Coordinates> prev = new HashMap<>();
//        Set<Coordinates> visited = new HashSet<>();
//        Coordinates start = this.getCoordinates();
//        queue.offer(start);
//        visited.add(start);
//        MapTable map = this.getMap();
//
//        while (!queue.isEmpty()) {
//            Coordinates current = queue.poll();
//            Entity entity = map.entityAt(current);
//            if (this instanceof Herbivore && entity instanceof Grass) {
//                return reconstructPath(prev, start, current);
//            } else if (this instanceof Predator && entity instanceof Herbivore) {
//                return reconstructPath(prev, start, current);
//            }
//
//            }
//        return null;
//    }
}
