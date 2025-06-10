package astOld.Encapsulators.Loop;

import astOld.Instructions.Instruction;
import astOld.Program;

import java.util.List;

public class RepeatXLoop extends Loop {
    private Integer timesToRepeat; // straightforward

    public RepeatXLoop(Program p, List<Instruction> ins, Integer times) {
        super(p, ins);
        timesToRepeat = times;
    }

    public Integer getTimes() {
        return timesToRepeat;
    }

    public void setCond(Integer times) {
        timesToRepeat = times;
    }
    @Override
    public void evaluate() {

    }
}
