package astOld.Conditionals;

import astOld.Conditionals.behaviorClause.ComparisonClause;
import astOld.Instructions.Instruction;
import astOld.Program;
import astOld.Statement.ValueStatement;
import libs.Node;

public abstract class Conditional extends Node {
    private Program prgm;
    private Instruction parent;

    public Conditional(Program p) {
        prgm = p;
        parent = null;
    }

    // Updates the current conditional and all its "children"
    public void setParent(Instruction parent) {
        this.parent = parent;
        if (this instanceof Conjunction) {
            Conditional c1 = ((Conjunction) this).getCond1();
            Conditional c2 = ((Conjunction) this).getCond2();
            c1.setParent(parent);
            ((Conjunction) this).setCond1(c1);
            if (c2 != null) {
                c2.setParent(parent);
                ((Conjunction) this).setCond2(c2);
            }
        } else if (this instanceof ComparisonClause) {
            ValueStatement v1 = ((ComparisonClause) this).getValue1();
            ValueStatement v2 = ((ComparisonClause) this).getValue2();
            v1.setParent(parent);
            v2.setParent(parent);
            ((ComparisonClause) this).setValue1(v1);
            ((ComparisonClause) this).setValue2(v2);
        }
    }

    public Instruction getParent() {
        return parent;
    }

    public Program getProgram() {
        return prgm;
    }

    public void setProgram(Program p) {
        prgm = p;
    }
}
