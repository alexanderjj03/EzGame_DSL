package ast;


public class Comparison extends BooleanClause {
    private final MathStatement mathStatement1;
    private final String operator;
    private final MathStatement mathStatement2;

    public Comparison(MathStatement mathStatement1, String operator, MathStatement mathStatement2) {
        this.mathStatement1 = mathStatement1;
        this.operator = operator;
        this.mathStatement2 = mathStatement2;
        super.clauseType = BooleanClauseType.COMPARISON;
    }

    // getters
    public MathStatement getMathStatement1() {
        return mathStatement1;
    }

    public String getOperator() {
        return operator;
    }

    public MathStatement getMathStatement2() {
        return mathStatement2;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Comparison other) {
            return operator.equals(other.operator) && mathStatement1.equals(other.mathStatement1) && mathStatement2.equals(other.mathStatement2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return mathStatement1.hashCode() + operator.hashCode() + mathStatement2.hashCode();
    }

    @Override
    public String toString() {
        if (operator == null) {
            return mathStatement1.toString();
        }
        return mathStatement1.toString() + " " + operator + " " + mathStatement2.toString();
    }
}
