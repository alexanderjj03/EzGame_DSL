package ast;

public class BooleanNegation extends Boolean {
    private final BooleanStatement statement;

    public BooleanNegation(BooleanStatement statement) {
        this.statement = statement;
    }

    // getters
    public BooleanStatement getStatement() {
        return statement;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BooleanNegation && statement.equals(((BooleanNegation) obj).statement);
    }

    @Override
    public int hashCode() {
        return statement.hashCode();
    }

    @Override
    public String toString() {
        return "not " + statement.toString();
    }
}
