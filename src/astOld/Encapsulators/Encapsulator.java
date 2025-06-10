package astOld.Encapsulators;

import astOld.Instructions.Instruction;
import astOld.Program;
import libs.Node;

import java.util.List;

// Encapsulates instructions within
public abstract class Encapsulator extends Node {
    private Program prgm;
    private List<Instruction> instructions;
    private Instruction curInst;

    public Encapsulator(Program p, List<Instruction> ins) {
        instructions = ins;
        prgm = p;
        curInst = null;
    }

    public Program getProgram() {
        return prgm;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setCurInst(Instruction curInst) {
        this.curInst = curInst;
    }

    public Instruction getCurInst() {
        return curInst;
    }

    public void setInstructions(List<Instruction> ins) {
        if (this instanceof Function) {
            if (ins != null) {
                for (Instruction in: ins) { // This function can be called by multiple entities' behaviors
                    in.setEnt(null);
                }
            }
        }
        instructions = ins;
    }

    public void setProgram(Program p) {
        prgm = p;
    }
}
