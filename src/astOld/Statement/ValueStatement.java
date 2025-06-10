package astOld.Statement;

import astOld.Instructions.ExecEncapsulator;
import astOld.Instructions.ExecFunction;
import astOld.Instructions.Instruction;
import libs.Node;

public class ValueStatement extends Node {
    private Instruction parent; // Can be execEncapsulator
    // Option 1 (math statement)
    private MathStatement math;
    // Option 2 (variable name)
    private String globalVarName;
    // Option 3 (function execution)
    private ExecFunction fResult;

    public ValueStatement(Instruction Parent, MathStatement m, String var, ExecFunction f) {
        parent = Parent;
        math = m;
        globalVarName = var;
        fResult = f;
        if (parent != null) {
            if (parent instanceof ExecEncapsulator) {
                fResult.setParent((ExecEncapsulator) parent);
            } else {
                fResult.setParent(parent.getParent());
            }
        }
    }

    public MathStatement getMath() {
        return math;
    }

    public String getGlobalVarName() {
        return globalVarName;
    }

    public ExecFunction getfResult() {
        return fResult;
    }

    public Instruction getParent() {
        return parent;
    }

    public void setParent(Instruction parent) {
        this.parent = parent;
        if (math != null) {
            math.setParent(parent);
        }
    }

    public void setMath(MathStatement math) {
        this.math = math;
    }

    public void setGlobalVarName(String globalVarName) {
        this.globalVarName = globalVarName;
    }

    public void setfResult(ExecFunction fResult) {
        this.fResult = fResult;
    }

    public Integer compute() {
        if (math != null) {
            return (int) math.compute();
        } else if (globalVarName != null) {
            try {
                return utils.getGlobalVar(globalVarName, parent);
            } catch (Error e) {
                throw new Error(e.getMessage());
            }
        } else if (fResult != null) {
            fResult.evaluate();
            return fResult.returnFunc();
        } else {
            throw new Error("Invalid value statement: Nothing to compute");
        }
    }

    @Override
    public void evaluate() {

    }
}
