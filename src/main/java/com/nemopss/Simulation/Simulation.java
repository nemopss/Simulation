package com.nemopss.Simulation;

import com.nemopss.Actions.InitAction;
import com.nemopss.Actions.TurnAction;
import com.nemopss.Map.MapTable;

public class Simulation {
    MapTable map;
    InitAction initAction = new InitAction();
    TurnAction turnAction = new TurnAction();
    public Simulation() {
    }

    public void startSimulation() throws InterruptedException {
        map = initAction.initMap();
        while (true) {
            nextTurn();

            Thread.sleep(1000);
        }
    }
    public void nextTurn() {
        turnAction.moveCreatures(map);
        turnAction.renderMap(map);
    }
}
