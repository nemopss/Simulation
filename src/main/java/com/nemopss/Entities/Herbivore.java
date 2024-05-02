package com.nemopss.Entities;

import com.nemopss.Map.MapTable;

public class Herbivore extends Creature{

    public Herbivore(int x, int y, MapTable map){
        super(x, y, map);
    }
    @Override
    public void makeMove() {

    }

    @Override
    public String toString(){
        return "\uD83D\uDC11";
    }
}
