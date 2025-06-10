package astOld.Instructions;

import astOld.Entities.Entity;
import astOld.Program;

public class Face extends Instruction {
    private String direction; // Up down left right
    public Face(Entity e, Program p, ExecEncapsulator exe) {
        super(e, p, exe);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public void evaluate() {

    }
}
