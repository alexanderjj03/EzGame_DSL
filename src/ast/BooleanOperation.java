package ast;

public class BooleanOperation extends Boolean {
    private final BooleanStatement statement1;
    private final String operator;
    private final BooleanStatement statement2;

    public BooleanOperation(BooleanStatement statement1, String operator, BooleanStatement statement2) {
        this.statement1 = statement1;
        this.operator = operator;
        this.statement2 = statement2;
    }

    // getters
    public BooleanStatement getStatement1() {
        return statement1;
    }

    public String getOperator() {
        return operator;
    }

    public BooleanStatement getStatement2() {
        return statement2;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BooleanOperation other) {
            return statement1.equals(other.statement1) && operator.equals(other.operator) && statement2.equals(other.statement2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return statement1.hashCode() + operator.hashCode() + statement2.hashCode();
    }

    @Override
    public String toString() {
        return statement1.toString() + " " + operator + " " + statement2.toString();
    }
}
