package ast;

import java.util.List;

public class FunctionCall extends Instruction {
    private final String name;
    private final List<Value> arguments;

    public FunctionCall(String name, List<Value> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    // getters
    public String getName() {
        return name;
    }

    public List<Value> getArguments() {
        return arguments;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FunctionCall other) {
            return name.equals(other.name) && arguments.equals(other.arguments);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + arguments.hashCode();
    }

    @Override
    public String toString() {
        return name + "(" + arguments + ")";
    }
}
