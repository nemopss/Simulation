package com.nemopss.Entities;

import com.nemopss.Map.MapTable;

public class Predator extends Creature{

    public Predator(int x, int y, MapTable map) {
        super(x, y, map);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
