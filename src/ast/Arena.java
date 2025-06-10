package ast;

public class Arena extends Node {
    private final Number size;

    public Arena(Number size) {
        this.size = size;
    }

    // getters
    public Number getSize() {
        return size;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Arena && size.equals(((Arena) obj).size);
    }

    @Override
    public int hashCode() {
        return size.hashCode();
    }

    @Override
    public String toString() {
        return "Arena(" + size + ")";
    }
}
