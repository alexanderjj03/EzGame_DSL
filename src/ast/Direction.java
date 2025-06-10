package ast;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public String toString() {
        return name().toUpperCase();
    }
}

