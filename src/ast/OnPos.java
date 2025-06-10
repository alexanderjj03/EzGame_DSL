package ast;

import org.antlr.v4.runtime.misc.Pair;

public class OnPos extends BooleanClause {
    private final OnPosType type;
    private final Pair<Integer, Integer> coordinate;
    private final String entityName;

    public OnPos(OnPosType type, Pair<Integer, Integer> coordinate, String entityName) {
        this.type = type;
        this.coordinate = coordinate;
        this.entityName = entityName;
        super.clauseType = BooleanClauseType.ONPOS;
    }

    // getters
    public OnPosType getType() {
        return type;
    }

    public Pair<Integer, Integer> getCoordinate() {
        return coordinate;
    }

    public String getEntityName() {
        return entityName;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OnPos other) {
            return type.equals(other.type) && coordinate.equals(other.coordinate) && entityName.equals(other.entityName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (coordinate != null) {
            return type.hashCode() + coordinate.hashCode();
        } else {
            return type.hashCode() + entityName.hashCode();
        }
    }

    @Override
    public String toString() {
        return switch (type) {
            case COORDINATE -> "on pos " + coordinate.toString();
            case ENTITY -> "on pos " + entityName;
        };
    }
}
