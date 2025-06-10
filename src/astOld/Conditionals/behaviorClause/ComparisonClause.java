package astOld.Conditionals.behaviorClause;

import astOld.Statement.ValueStatement;
import astOld.Program;

public class ComparisonClause extends Clause {
    private String operation;
    private ValueStatement value1;
    private ValueStatement value2;

    public ComparisonClause(Program p, String op, ValueStatement v1, ValueStatement v2) {
        super(p);
        operation = op;
        value1 = v1;
        value2 = v2;
    }

    public String getOperation() {
        return operation;
    }

    public ValueStatement getValue1() {
        return value1;
    }

    public ValueStatement getValue2() {
        return value2;
    }

    public void setValue1(ValueStatement v) {
        value1 = v;
    }

    public void setValue2(ValueStatement v) {
        value2 = v;
    }

    public void setOperation(String op) {
        operation = op;
    }

    @Override
    public void evaluate() {

    }
}
