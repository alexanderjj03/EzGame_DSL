package astOld.Instructions;

import astOld.Statement.ValueStatement;
import astOld.Entities.Entity;
import astOld.Program;

public class MutVar extends Instruction {
    private String varName;
    private ValueStatement value;
    private Integer computed;

    public MutVar(Entity e, Program p, ExecEncapsulator par, String name, ValueStatement val) {
        super(e, p, par);
        varName = name;
        value = val;
        value.setParent(this);
        computed = value.compute();
    }

    public ValueStatement getValue() {
        return value;
    }

    public void setValue(ValueStatement value) {
        this.value = value;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public Integer getComputed() {
        return computed;
    }

    public void setComputed(Integer computed) {
        this.computed = computed;
    }

    @Override
    public void evaluate() {

    } // Insert the variable's new value into parent (if it exists). If the variable is not present there,
    // check the entity for a match. If the variable is present in neither, throw an error
}
