package astOld.Entities;

import astOld.Instructions.Instruction;

import java.util.List;

public class Obstacle extends Entity {
    private List<Instruction> behaviors;

    public Obstacle(List<Integer> Start, Integer Size, Integer Health, String Direction, Integer Damage,
                    List<Instruction> Behaviors) {
        super(Start, Size, Health, Direction, Damage);
        behaviors = Behaviors;
    }

    public List<Instruction> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<Instruction> Behaviors) {
        behaviors = Behaviors;
    }

    @Override
    public void evaluate() {

    }
}
