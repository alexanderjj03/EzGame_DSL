package ast;

public class MathStatement extends Math {
    private final MathTerm term1;
    private final String operator;
    private final MathTerm term2;

    public MathStatement(MathTerm term1, String operator, MathTerm term2) {
        this.term1 = term1;
        this.operator = operator;
        this.term2 = term2;
    }
    
    // getters 
    public MathTerm getTerm1() {
        return term1;
    }

    public String getOperator() {
        return operator;
    }

    public MathTerm getTerm2() {
        return term2;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MathStatement other) {
            return term1.equals(other.term1) && operator.equals(other.operator) && term2.equals(other.term2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (operator == null) {
            return term1.hashCode();
        } else {
            return term1.hashCode() + operator.hashCode() + term2.hashCode();
        }
    }

    @Override
    public String toString() {
        if (operator == null) {
            return term1.toString();
        }
        return term1.toString() + " " + operator + " " + term2.toString();
    }
}
