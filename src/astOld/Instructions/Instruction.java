package astOld.Instructions;

import astOld.Entities.Entity;
import astOld.Program;
import libs.Node;

public abstract class Instruction extends Node {
    private Entity ent;
    private ExecEncapsulator parent; // optional
    private Program prgm;

    public Instruction(Entity e, Program p, ExecEncapsulator exe) {
        ent = e;
        parent = exe;
        prgm = p;
    }

    public Program getProgram() {
        return prgm;
    }

    public Entity getEntity() {
        return ent;
    }

    public ExecEncapsulator getParent() {
        return parent;
    }

    public void setParent(ExecEncapsulator parent) {
        this.parent = parent;
    }

    public void setEnt(Entity e) {
        ent = e;
    }

    public void setProgram(Program p) {
        prgm = p;
    }
}
