package ast;

import org.antlr.v4.runtime.misc.Pair;

public class MoveInstruction extends Instruction {
    private final MoveType type;
    private final Pair<Integer, Integer> coordinate;
    private final Value displacement;

    public MoveInstruction(MoveType type, Pair<Integer, Integer> coordinate, Value displacement) {
        this.type = type;
        this.coordinate = coordinate;
        this.displacement = displacement;
    }

    // getters
    public MoveType getType() {
        return type;
    }

    public Value getDisplacement() {
        return displacement;
    }

    public Pair<Integer, Integer> getCoordinate() {
        return coordinate;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MoveInstruction other) {
            return type.equals(other.type) && coordinate.equals(other.coordinate) && displacement.equals(other.displacement);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return switch (type) {
            case COORDINATE -> coordinate.hashCode() + type.hashCode();
            case DISPLACEMENT -> displacement.hashCode() + type.hashCode();
        };
    }

    @Override
    public String toString() {
        return switch (type) {
            case COORDINATE -> "move " + coordinate.toString();
            case DISPLACEMENT -> displacement.toString();
        };
    }
}
