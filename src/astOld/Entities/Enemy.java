package astOld.Entities;

import astOld.Instructions.Instruction;

import java.util.List;

public class Enemy extends Entity {
    private List<Instruction> behaviors;
    private Integer clone;

    public Enemy(List<Integer> Start, Integer Size, Integer Health, String Direction, Integer Damage,
                 Integer Clone, List<Instruction> Behaviors) {
        super(Start, Size, Health, Direction, Damage);
        clone = Clone;
        behaviors = Behaviors;
    }

    public Integer getClone() {
        return clone;
    }

    public List<Instruction> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<Instruction> Behaviors) {
        behaviors = Behaviors;
    }

    public void setClone(Integer Clone) {
        clone = Clone;
    }

    @Override
    public void evaluate() {

    }
}
