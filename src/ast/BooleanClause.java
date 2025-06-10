package ast;

public abstract class BooleanClause extends Boolean {
    protected BooleanClauseType clauseType;

    BooleanClause() {}

    // getters
    public BooleanClauseType getClauseType() {
        return clauseType;
    }
}
