package ast;

public class Variable extends Value {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    // getters
    public String getName() {
        return name;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        // TODO
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable other) {
            return name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
    }
