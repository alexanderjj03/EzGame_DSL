package ast;

public class ForeverLoop extends Instruction {
    private final UnlessInstruction unless;

    public ForeverLoop(UnlessInstruction unless) {
        this.unless = unless;
    }

    public UnlessInstruction getUnless() {return unless;}

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ForeverLoop other) {
            return unless.equals(other.unless);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return unless.hashCode();
    }

    @Override
    public String toString() {
        return "forever " + unless.toString();
    }
}
