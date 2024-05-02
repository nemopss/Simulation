package com.nemopss;

import com.nemopss.Entities.*;
import com.nemopss.Map.MapTable;
import com.nemopss.Misc.Renderer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MapTable map = new MapTable();
        Herbivore Jhon = new Herbivore(1, 1);
        Herbivore Vasya = new Herbivore(2, 3);
        Predator Petya = new Predator(2, 2);
        Predator Biba = new Predator(0, 0);
        Predator Leha = new Predator(4, 5);
        map.addEntity(Jhon);
        map.addEntity(Vasya);
        map.addEntity(Petya);
        map.addEntity(Biba);
        map.addEntity(new Grass(5, 5));
        map.addEntity(new Rock(4, 4));
        map.addEntity(new Rock(4, 3));
        map.addEntity(new Rock(4, 2));
        map.addEntity(new Tree(3, 5));
        map.addEntity(new Rock(4, 6));
        map.addEntity(Leha);
       // map.removeEntity(Biba);
       // map.removeEntity(Petya);
       // map.displayDebugMap();

        map.printMapGraph();
        List<List<Integer>> path = Vasya.findFood(map.getMapGraph());
        path.remove(0);
        path.remove(path.size() - 1);
        Renderer.renderWithHighlightedPath(map, path);


    }


}