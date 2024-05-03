package com.nemopss;

import com.nemopss.Misc.Renderer;
import com.nemopss.Simulation.Simulation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10){
            Simulation simulation = new Simulation();
            List<List<Integer>> path = simulation.getMap().getPredator().findFood(simulation.getMap().getMapGraph());
            path.remove(path.size() - 1);
            Renderer.renderWithHighlightedPath(simulation.getMap(), path);
            System.out.println("\n");
            i++;
        }
    }
}