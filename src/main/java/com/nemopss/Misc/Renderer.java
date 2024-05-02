package com.nemopss.Misc;

import com.nemopss.Map.MapTable;

public class Renderer {
    public static void render(MapTable map) {
        for (int i = 0; i < map.getMapSize().getX(); i++) {
            for (int j = 0; j < map.getMapSize().getY(); j++) {
                Coordinates coordinates = new Coordinates(j, i);
                if (map.entityAt(coordinates) != null) {
                    System.out.print(map.entityAt(coordinates).toString() + " ");
                } else {
                    System.out.print("⬛ ");
                }
            }
            System.out.println();
        }
    }
}
