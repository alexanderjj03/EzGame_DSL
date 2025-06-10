package astOld.Entities;

import java.util.List;

public class Player extends Entity {

    public Player(List<Integer> Start, Integer Size, Integer Health, String Direction, Integer Damage) {
        super(Start, Size, Health, Direction, Damage);
    }

    @Override
    public void evaluate() {

    }
}
