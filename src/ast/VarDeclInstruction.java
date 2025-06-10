package ast;

public class VarDeclInstruction extends Instruction {
    private final String name;
    private final Value value;

    public VarDeclInstruction(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    // getters
    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VarDeclInstruction other) {
            return name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "var " + name + " = " + value;
    }
}
