package astOld.Encapsulators;

import astOld.Statement.ValueStatement;
import astOld.Instructions.Instruction;
import astOld.Program;

import java.util.List;

public class Function extends Encapsulator {
    private List<String> variables; // stores arguments (at first) and any defined variables' names within
    // Option 1: Return
    private ValueStatement returnVal; // Return value (optional)

    public Function(Program p, List<Instruction> ins, List<String> args, ValueStatement ret) {
        super(p, ins);
        variables = args;

        if (ins != null) {
            for (Instruction in: ins) { // This function can be called by multiple entities' behaviors
                in.setEnt(null);
            }
        }

        setInstructions(ins);
        returnVal = ret;
    }

    public List<String> getVars() {
        return variables;
    }

    public ValueStatement getReturn() {
        return returnVal;
    }

    public void setReturn(ValueStatement str) {
        returnVal = str;
    }

    public void setVars(List<String> vars) {
        variables = vars;
    }

    @Override
    public void evaluate() {

    }
}
