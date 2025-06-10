package ast;

public class BooleanStatement extends Boolean {
    private final BooleanType type;
    private final BooleanOperation operation;
    private final BooleanNegation negation;
    private final BooleanClause clause;

    public BooleanStatement(BooleanType type, BooleanOperation operation, BooleanNegation negation, BooleanClause clause) {
        this.type = type;
        this.operation = operation;
        this.negation = negation;
        this.clause = clause;
    }

    // getters
    public BooleanType getType() {
        return type;
    }

    public BooleanOperation getOperation() {
        return operation;
    }

    public BooleanNegation getNegation() {
        return negation;
    }

    public BooleanClause getClause() {
        return clause;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BooleanStatement other) {
            return switch (type) {
                case CLAUSE -> clause.equals(other.clause);
                case OPERATION -> operation.equals(other.operation);
                case NEGATION -> negation.equals(other.negation);
            };
        }
        return false;
    }

    @Override
    public int hashCode() {
        return switch (type) {
            case CLAUSE -> clause.hashCode();
            case OPERATION -> operation.hashCode();
            case NEGATION -> negation.hashCode();
        };
    }

    @Override
    public String toString() {
        return switch (type) {
            case CLAUSE -> clause.toString();
            case OPERATION -> "(" + operation.toString() + ")";
            case NEGATION -> "(" + negation.toString() + ")";
        };
    }
}
