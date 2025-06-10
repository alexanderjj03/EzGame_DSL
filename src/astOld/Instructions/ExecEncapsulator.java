package astOld.Instructions;

import astOld.Conditionals.Conditional;
import astOld.Encapsulators.Encapsulator;
import astOld.Encapsulators.Unless;
import astOld.Entities.Entity;
import astOld.Program;

import java.util.HashMap;
import java.util.List;

public class ExecEncapsulator extends Instruction {
    private HashMap<String, Integer> vars; // variable name/value pairs
    private Encapsulator executed; // Only time this class would be used is for an unless.

    public ExecEncapsulator(Entity e, Program p, ExecEncapsulator exe, Encapsulator par) {
        super(e, p, exe);
        vars = new HashMap<>();
        executed = par;
        if (executed instanceof Unless) {
            Conditional c = ((Unless) executed).getCond();
            if (getParent() != null) {
                c.setParent(getParent());
                ((Unless) executed).setCond(c);
            }

            List<Instruction> instructions = executed.getInstructions();
            for (Instruction in: instructions) { // Now, we want each instruction to target the corresponding entity
                in.setEnt(e);
                in.setParent(this);
            }
            executed.setInstructions(instructions);
        }
    }

    public HashMap<String, Integer> getVars() {
        return vars;
    }

    public Encapsulator getExecuted() {
        return executed;
    }

    public void setExecuted(Encapsulator executed) {
        this.executed = executed;
    }

    public void setVars(HashMap<String, Integer> vars) {
        this.vars = vars;
    }

    @Override
    public void evaluate() {

    }
}
