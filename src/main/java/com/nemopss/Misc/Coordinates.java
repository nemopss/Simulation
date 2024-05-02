package com.nemopss.Misc;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int hash() {
        return this.x * 37 + this.y;
    }

    public boolean equals(Coordinates coordinates) {
        if (this.x == coordinates.getX() && this.y == coordinates.getY()) {
            return true;
        }
        return false;
    }
}
