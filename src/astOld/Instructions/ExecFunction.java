package astOld.Instructions;

import astOld.Encapsulators.Encapsulator;
import astOld.Encapsulators.Function;
import astOld.Entities.Entity;
import astOld.Program;
import astOld.Statement.ValueStatement;

import java.util.HashMap;
import java.util.List;

public class ExecFunction extends ExecEncapsulator {
    private Function executedReal;

    public ExecFunction(Entity e, Program p, ExecEncapsulator exe, Encapsulator par, Function f,
                        List<Integer> args) {
        super(e, p, exe, par);
        setExecuted(null); // we need a more specific "parent" type

        List<Instruction> instructions = f.getInstructions();
        ValueStatement ret = f.getReturn();

        if (instructions != null) {
            for (Instruction in : instructions) { // Now, we want each instruction to target the corresponding entity
                in.setEnt(e);
                in.setParent(this);
            }
        }

        if (ret != null) {
            ret.setParent(this);
        }

        f.setInstructions(instructions);
        f.setReturn(ret);
        executedReal = f;
        HashMap<String, Integer> vars = new HashMap<>();

        int index = 0;
        for (String var: executedReal.getVars()) {
            vars.put(var, args.get(index));
        }
        setVars(vars);
    }

    public Function getExecutedReal() {
        return executedReal;
    }

    public void setExecutedReal(Function executedReal) {
        this.executedReal = executedReal;
    }

    public Integer returnFunc() {
        if (executedReal.getReturn() != null) {
            return executedReal.getReturn().compute();
        } else {
            throw new Error("Return expected from function with no return statement.");
        }
    }

    @Override
    public void evaluate() {

    }
}
