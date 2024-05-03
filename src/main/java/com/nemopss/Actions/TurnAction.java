package com.nemopss.Actions;

import com.nemopss.Entities.Entity;
import com.nemopss.Entities.Herbivore;
import com.nemopss.Entities.Predator;
import com.nemopss.Map.MapTable;
import com.nemopss.Misc.Renderer;
import java.util.ArrayList;
import java.util.List;

public class TurnAction extends Action {
    public void moveCreatures(MapTable map) {
        List<Entity> entities = new ArrayList<>(map.getMap()); // Создаем копию коллекции
        for (Entity e : entities) {
            if (e instanceof Herbivore) {
                ((Herbivore) e).makeMove(map);
            } else if (e instanceof Predator) {
                ((Predator) e).makeMove(map);
            }
        }
    }


    public void renderMap(MapTable map) {
        Renderer.render(map);
    }
}
