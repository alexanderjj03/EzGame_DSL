package astOld.Statement;

import astOld.Instructions.Instruction;
import libs.Node;

public class MathStatement extends Node {
    private Instruction parent; // Can be execEncapsulator
    // Option 1 (math statements)
    private MathStatement math1;
    private MathStatement math2;
    private String operator; // + - * /
    // Option 2 (variable name)
    private String globalVarName;
    // Option 3 (Numerical value)
    private Integer number;

    public MathStatement(Instruction Parent, MathStatement m1, MathStatement m2, String op,
                          String var, Integer num) {
        parent = Parent;
        math1 = m1;
        math2 = m2;
        operator = op;
        globalVarName = var;
        number = num;
    }

    public MathStatement getMath1() {
        return math1;
    }

    public MathStatement getMath2() {
        return math2;
    }

    public String getOperator() {
        return operator;
    }

    public String getGlobalVarName() {
        return globalVarName;
    }

    public Integer getNum() {
        return number;
    }

    public Instruction getParent() {
        return parent;
    }

    public void setParent(Instruction parent) {
        this.parent = parent;
        if (math1 != null) {
            math1.setParent(parent);
        }
        if (math2 != null) {
            math2.setParent(parent);
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setMath1(MathStatement math) {
        this.math1 = math;
    }

    public void setMath2(MathStatement math) {
        this.math2 = math;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setGlobalVarName(String globalVarName) {
        this.globalVarName = globalVarName;
    }

    public void setNumber(Integer num) {
        this.number = num;
    }

    public double compute() {
        if (number != null) {
            return (double) number;
        } else if (globalVarName != null) {
            try {
                return utils.getGlobalVar(globalVarName, parent);
            } catch (Error e) {
                throw new Error(e.getMessage());
            }
        } else if (operator != null) {
            double val1 = math1.compute();
            double val2 = math2.compute();
            return switch (operator) {
                case "+" -> val1 + val2;
                case "-" -> val1 - val2;
                case "*" -> val1 * val2;
                case "/" -> val1 / val2;
                default -> throw new Error("Invalid operator");
            };
        } else {
            throw new Error("Invalid math expression");
        }
    }

    @Override
    public void evaluate() {

    }
}
