package astOld.Conditionals;

import astOld.Program;

public class Conjunction extends Conditional {
    private Conditional cond1;
    private Conditional cond2; // Optional
    private String type; // and/or/not

    public Conjunction(Program p, Conditional c1, Conditional c2, String kind) {
        super(p);
        cond1 = c1;
        cond2 = c2;
        type = kind;
    }

    public Conditional getCond1() {
        return cond1;
    }

    public Conditional getCond2() {
        return cond2;
    }

    public String getType() {
        return type;
    }

    public void setCond1(Conditional c1) {
        cond1 = c1;
    }

    public void setCond2(Conditional c2) {
        cond2 = c2;
    }

    public void setCond1(String kind) {
        type = kind;
    }

    @Override
    public void evaluate() {

    }
}

