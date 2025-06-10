package ast;

import java.util.List;

public class Program extends Node {
    private final Arena arena;
    private final List<Entity> entities;
    private final List<Definition> behaviours;
    private final EndCriteria endCriteria;

    public Program(Arena arena, List<Entity> entities, List<Definition> behaviours, EndCriteria endCriteria) {
        this.arena = arena;
        this.entities = entities;
        this.behaviours = behaviours;
        this.endCriteria = endCriteria;
    }

    // getters
    public Arena getArena() {
        return arena;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Definition> getBehaviours() {
        return behaviours;
    }

    public EndCriteria getEndCriteria() {
        return endCriteria;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Program other) {
            return arena.equals(other.arena) && entities.equals(other.entities) && behaviours.equals(other.behaviours) && endCriteria.equals(other.endCriteria);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return arena.hashCode() + entities.hashCode() + behaviours.hashCode() + endCriteria.hashCode();
    }

    @Override
    public String toString() {
        return arena + "\n" + entities + "\n" + behaviours + "\n" + endCriteria;
    }
}
