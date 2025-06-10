package astOld.Instructions;

import astOld.Statement.ValueStatement;
import astOld.Entities.Entity;
import astOld.Program;

import java.util.List;

public class Move extends Instruction {
    // Option 1: Value statement
    private ValueStatement value;
    // Option 2: Random
    private Boolean random;
    // Option 3: Coordinates
    private List<Integer> coords;

    public Move(Entity e, Program p, ExecEncapsulator exe, ValueStatement v, Boolean r, List<Integer> coordinates) {
        super(e, p, exe);
        value = v;
        value.setParent(this);
        random = r;
        coords = coordinates;
    }

    public ValueStatement getValue() {
        return value;
    }

    public void setValue(ValueStatement value) {
        this.value = value;
    }

    public Boolean getRandom() {
        return random;
    }

    public void setRandom(Boolean random) {
        this.random = random;
    }

    public List<Integer> getCoords() {
        return coords;
    }

    public void setCoords(List<Integer> coords) {
        this.coords = coords;
    }

    @Override
    public void evaluate() {

    }
}
