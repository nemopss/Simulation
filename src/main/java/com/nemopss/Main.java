package com.nemopss;

import com.nemopss.Entities.Grass;
import com.nemopss.Entities.Herbivore;
import com.nemopss.Entities.Predator;
import com.nemopss.Map.MapTable;
import com.nemopss.Misc.Coordinates;
import com.nemopss.Misc.Renderer;

public class Main {
    public static void main(String[] args) {
        MapTable map = new MapTable();
        Herbivore Jhon = new Herbivore(1, 1);
        Herbivore Vasya = new Herbivore(2, 3);
        Predator Petya = new Predator(2, 2);
        Predator Biba = new Predator(0, 0);
        map.addEntity(Jhon, Jhon.getCoordinates());
        map.addEntity(Vasya, Vasya.getCoordinates());
        map.addEntity(Petya, Petya.getCoordinates());
        map.addEntity(Biba, Biba.getCoordinates());
        map.addEntity(new Grass(5, 5), new Coordinates(5, 5));


        Renderer.render(map);

    }


}