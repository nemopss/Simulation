package com.nemopss.Entities;

public class Herbivore extends Creature{

    public Herbivore(int x, int y){
        super(x, y);
    }
    @Override
    public void makeMove() {

    }

    @Override
    public String toString(){
        return "\uD83D\uDC11";
    }
}
