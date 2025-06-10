package ast;

import java.util.List;

public class EntityBehaviourDefinition extends Definition {
    private final String name;

    public EntityBehaviourDefinition(String name, List<Instruction> instructions) {
        this.name = name;
        super.instructions = instructions;
    }

    // getters
    public String getName() {
        return name;
    }
    public void addInstruction(Instruction instruction) {instructions.add(instruction);}

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EntityBehaviourDefinition other) {
            return name.equals(other.name) && super.equals(other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + super.hashCode();
    }

    @Override
    public String toString() {
        return name + " " + super.toString();
    }
}
