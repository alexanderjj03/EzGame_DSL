package astOld.Instructions;

import astOld.Conditionals.Conditional;
import astOld.Encapsulators.Encapsulator;
import astOld.Encapsulators.Loop.CondLoop;
import astOld.Encapsulators.Loop.Loop;
import astOld.Entities.Entity;
import astOld.Program;

import java.util.List;

public class ExecLoop extends ExecEncapsulator {
    private Loop executedReal;

    public ExecLoop(Entity e, Program p, ExecEncapsulator exe, Encapsulator par, Loop l) {
        super(e, p, exe, par);
        setExecuted(null); // we need a more specific "parent" type

        executedReal = l;
        List<Instruction> instructions = executedReal.getInstructions();
        for (Instruction in: instructions) { // Now, we want each instruction to target the corresponding entity
            in.setEnt(e);
            in.setParent(this);
        }
        executedReal.setInstructions(instructions);

        if (executedReal instanceof CondLoop) {
            Conditional c = ((CondLoop) executedReal).getCond();
            if (getParent() != null) {
                c.setParent(getParent());
                ((CondLoop) executedReal).setCond(c);
            }
        }
    }

    public Loop getExecutedReal() {
        return executedReal;
    }

    public void setExecutedReal(Loop executedReal) {
        this.executedReal = executedReal;
    }

    @Override
    public void evaluate() {

    }
// Maintains the necessary variable values/current instruction/etc for the execution of a loop.
// Evaluate executes the loop
}

