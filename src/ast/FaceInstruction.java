package ast;

public class FaceInstruction extends Instruction {
    private final Direction direction;

    public FaceInstruction(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FaceInstruction other) {
            return direction.equals(other.direction);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return direction.hashCode();
    }

    @Override
    public String toString() {
        return "face " + direction.toString();
    }
}
