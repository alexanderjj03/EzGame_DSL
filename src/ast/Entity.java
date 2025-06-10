package ast;

import org.antlr.v4.runtime.misc.Pair;

public class Entity extends Node {

    private final String name;
    private final EntityType type;
    private final Pair<Integer, Integer> start;
    private final Integer size;
    private final Integer health;
    private final Direction direction;
    private final Integer damage;

    public Entity(String name, EntityType type, Pair<Integer, Integer> start, Integer size, Integer health, Direction direction, Integer damage) {
        this.name = name;
        this.type = type;
        this.start = start;
        this.size = size;
        this.health = health;
        this.direction = direction;
        this.damage = damage;
    }

    // getters
    public String getName() {
        return name;
    }

    public EntityType getType() {
        return type;
    }

    public Pair<Integer, Integer> getStart() {
        return start;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getHealth() {
        return health;
    }

    public Direction getDirection() {
        return direction;
    }

    public Integer getDamage() {
        return damage;
    }

    @Override
    public <C, T> T accept(C context, EZGameVisitor<C, T> visitor) {
        return visitor.visit(context, this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Entity && name.equals(((Entity) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Entity: " + name + " (" + type + ", " + start + ", " + size + ", " + health + ", " + direction + ", " + damage + ")";
    }
}
