package com.nemopss.Simulation;

import com.nemopss.Actions.InitAction;
import com.nemopss.Map.MapTable;

public class Simulation {
    MapTable map;
    InitAction initAction = new InitAction();
    public Simulation() {
        map = initAction.initMap();
    }

    public MapTable getMap() {
        return map;
    }
}
