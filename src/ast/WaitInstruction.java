package ast;

public class WaitInstruction extends Instruction {
    private final Value seconds;

    public WaitInstruction(Value seconds) {
        this.seconds = seconds;
    }

    // getters
    public Value getSeconds() {
        return seconds;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WaitInstruction other) {
            return seconds.equals(other.seconds);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return seconds.hashCode();
    }

    @Override
    public String toString() {
        return "wait " + seconds.toString() + "sec";
    }
}
