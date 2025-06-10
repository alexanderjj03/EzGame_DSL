package ast;

import java.util.List;

public abstract class Definition extends Node {
    protected List<Instruction> instructions;

    public Definition() {}

    // getters
    public List<Instruction> getInstructions() {
        return instructions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Definition other) {
            return instructions.equals(other.instructions);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return instructions.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Instruction i : instructions) {
            sb.append(i.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
