package astOld.Encapsulators.Loop;

import astOld.Encapsulators.Encapsulator;
import astOld.Instructions.Instruction;
import astOld.Program;

import java.util.List;

public abstract class Loop extends Encapsulator {
    public Loop(Program p, List<Instruction> ins) {
        super(p, ins);
    }
}
