package astOld.Entities;

import libs.Node;

import java.util.HashMap;
import java.util.List;

public abstract class Entity extends Node {
    private List<Integer> start;
    private List<Integer> coordinate;
    private Integer size;
    private Integer health;
    private String direction;
    private Integer damage;
    private HashMap<String, Integer> vars; // variable name/value pairs

    public Entity(List<Integer> Start, Integer Size, Integer Health, String Direction, Integer Damage) {
        start = Start;
        coordinate = Start;
        size = Size;
        health = Health;
        direction = Direction;
        damage = Damage;
        vars = new HashMap<>();
    }

    public List<Integer> getStart() {
        return start;
    }

    public List<Integer> getCoordinate() {
        return coordinate;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getSize() {
        return size;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getDamage() {
        return damage;
    }

    public HashMap<String, Integer> getVars() {
        return vars;
    }

    public void setVars(HashMap<String, Integer> vars) {
        this.vars = vars;
    }

    public void setCoordinate(List<Integer> Coordinate) {
        coordinate = Coordinate;
    }

    public void setSize(Integer Size) {
        size = Size;
    }

    public void setHealth(Integer Health) {
        health = Health;
    }

    public void setDirection(String Direction) {
        direction = Direction;
    }

    public void setDamage(Integer Damage) {
        damage = Damage;
    }
}
