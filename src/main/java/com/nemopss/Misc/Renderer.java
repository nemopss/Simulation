package com.nemopss.Misc;

import com.nemopss.Map.MapTable;

import java.util.Arrays;
import java.util.List;

public class Renderer {
    public static void render(MapTable map) {
        for (int i = 0; i < map.getMapSize().get(0); i++) {
            for (int j = 0; j < map.getMapSize().get(1); j++) {
                List<Integer> coordinates = Arrays.asList(j, i);
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
