package ast;

import java.util.List;

public class FunctionDefinition extends Definition {
    private final String name;
    private final List<String> parameters;

    public FunctionDefinition(String name, List<String> parameters, List<Instruction> instructions) {
        this.name = name;
        this.parameters = parameters;
        super.instructions = instructions;
    }

    // getters
    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FunctionDefinition other) {
            return name.equals(other.name) && parameters.equals(other.parameters) && super.equals(other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + parameters.hashCode() + super.hashCode();
    }

    @Override
    public String toString() {
        return "function " + name + " (" + parameters + ") " + super.toString();
    }
}
