package astOld.Instructions;

import astOld.Statement.ValueStatement;
import astOld.Entities.Entity;
import astOld.Program;

public class Wait extends Instruction {
    private ValueStatement value; // number of seconds to wait
    private Integer ticks; // number of ticks to wait

    public Wait(Entity e, Program p, ExecEncapsulator exe, ValueStatement v) {
        super(e, p, exe);
        value = v;
        value.setParent(this);
        ticks = (Integer) (value.compute() * 20); // 20 ticks per second? Minecraft??
    }

    public Integer getTicks() {
        return ticks;
    }

    public ValueStatement getValue() {
        return value;
    }

    public void setTicks(Integer ticks) {
        this.ticks = ticks;
    }

    public void setValue(ValueStatement value) {
        this.value = value;
    }

    @Override
    public void evaluate() {

    }
}
