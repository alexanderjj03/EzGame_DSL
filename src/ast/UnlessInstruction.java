package ast;

import java.util.List;

public class UnlessInstruction extends Instruction {
    private final BooleanStatement booleanStatement;
    private final List<Instruction> instructions;

    public UnlessInstruction(BooleanStatement booleanStatement, List<Instruction> instructions) {
        this.booleanStatement = booleanStatement;
        this.instructions = instructions;
    }

    public void addInstruction(Instruction instruction) {instructions.add(instruction);}

    // getters
    public List<Instruction> getInstructions() {
        return instructions;
    }

    public BooleanStatement getBooleanStatement() {
        return booleanStatement;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UnlessInstruction other) {
            return booleanStatement.equals(other.booleanStatement) && instructions.equals(other.instructions);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return booleanStatement.hashCode() + instructions.hashCode();
    }

    @Override
    public String toString() {
        return "unless " + booleanStatement + " {\n" + instructions.toString() + "\n}";
    }
}
