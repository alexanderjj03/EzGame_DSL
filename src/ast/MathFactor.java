package ast;

public class MathFactor extends Math {
    private final MathFactorType type;
    private final Number num;
    private final String variable;
    private final MathStatement statement;

    public MathFactor(MathFactorType type, Number num, String variable, MathStatement statement) {
        this.type = type;
        this.num = num;
        this.variable = variable;
        this.statement = statement;
    }

    // getters
    public MathFactorType getType() {
        return type;
    }

    public Number getNum() {
        return num;
    }

    public String getVariable() {
        return variable;
    }

    public MathStatement getStatement() {
        return statement;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MathFactor other) {
            return switch (type) {
                case NUM -> num.equals(other.num);
                case VARIABLE -> variable.equals(other.variable);
                case STATEMENT -> statement.equals(other.statement);
            };
        }
        return false;
    }

    @Override
    public int hashCode() {
        return switch (type) {
            case NUM -> num.hashCode() + type.hashCode();
            case VARIABLE -> variable.hashCode() + type.hashCode();
            case STATEMENT -> statement.hashCode() + type.hashCode();
        };
    }

    @Override
    public String toString() {
        return switch (type) {
            case NUM -> num.toString();
            case VARIABLE -> variable;
            case STATEMENT -> "(" + statement.toString() + ")";
        };
    }
}
