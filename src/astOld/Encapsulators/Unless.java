package astOld.Encapsulators;

import astOld.Conditionals.Conditional;
import astOld.Instructions.Instruction;
import astOld.Program;

import java.util.List;

public class Unless extends Encapsulator {
    private Conditional unlessCond;

    public Unless(Program p, List<Instruction> ins, Conditional cond) {
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
