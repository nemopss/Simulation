package com.nemopss.Entities;

import com.nemopss.Map.MapTable;

public class Rock extends Entity{
    public Rock(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }
}
