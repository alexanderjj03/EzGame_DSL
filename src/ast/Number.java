package ast;

import java.util.Objects;

public class Number extends Value {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    // getters
    public int getNumber() {
        return number;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Number) {
            return number == ((Number) obj).number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
