package ast;

public class MathTerm extends Math {
    private final MathFactor factor1;
    private final String operator;
    private final MathFactor factor2;

    public MathTerm(MathFactor factor1, String operator, MathFactor factor2) {
        this.factor1 = factor1;
        this.operator = operator;
        this.factor2 = factor2;
    }

    // getters
    public MathFactor getFactor1() {
        return factor1;
    }

    public String getOperator() {
        return operator;
    }

    public MathFactor getFactor2() {
        return factor2;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MathTerm other) {
            return factor1.equals(other.factor1) && operator.equals(other.operator) && factor2.equals(other.factor2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (operator == null) {
            return factor1.hashCode();
        } else {
            return factor1.hashCode() + operator.hashCode() + factor2.hashCode();
        }
    }

    @Override
    public String toString() {
        if (operator == null) {
            return factor1.toString();
        }
        return factor1.toString() + operator + factor2.toString();
    }
}
