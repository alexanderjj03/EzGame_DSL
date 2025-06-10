package astOld.Encapsulators.Loop;

import astOld.Conditionals.Conditional;
import astOld.Instructions.Instruction;
import astOld.Program;

import java.util.List;

public class CondLoop extends Loop {
    private Conditional unlessCond;

    public CondLoop(Program p, List<Instruction> ins, Conditional cond) {
        super(p, ins);
        unlessCond = cond;
    }

    public Conditional getCond() {
        return unlessCond;
    }

    public void setCond(Conditional cond) {
        unlessCond = cond;
    }

    @Override
    public void evaluate() {

    }
}
