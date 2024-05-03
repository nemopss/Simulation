package com.nemopss.Entities;


import com.nemopss.Map.MapTable;

import java.util.List;

public class Predator extends Creature {

    public Predator(int x, int y) {
        super(x, y);
        speed = 2;
    }

    public Predator() {
        speed = 2;
    }

    @Override
    public void makeMove(MapTable map) {
        List<List<Integer>> path = this.findFood(map.getMapGraph());
        if (path.isEmpty()) {
            return;
        }
        map.moveTo(this, path.get(Math.min(this.getSpeed() - 1, path.size() - 1)));
    }

    private int getSpeed() {
        return this.speed;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
