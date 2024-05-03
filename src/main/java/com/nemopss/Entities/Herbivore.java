package com.nemopss.Entities;

import com.nemopss.Map.MapTable;

import java.util.List;

public class Herbivore extends Creature {


    public Herbivore(int x, int y) {
        super(x, y);
        speed = 1;
    }

    public Herbivore() {
        speed = 1;
    }

    @Override
    public void makeMove(MapTable map) {
        List<List<Integer>> path = this.findFood(map.getMapGraph());
        if (path.isEmpty()) {
            return;
        }
        map.moveTo(this, path.get(Math.min(this.getSpeed() - 1, path.size() - 1)));
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC11";
    }
}
