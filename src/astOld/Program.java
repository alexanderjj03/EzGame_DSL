package astOld;

import astOld.Conditionals.Conditional;
import astOld.Encapsulators.Function;
import astOld.Entities.Entity;
import libs.Node;

import java.util.List;


public class Program extends Node {
    private Integer arenaSize;
    private List<Entity> entities; // contains the instructions for their behaviors.
    private List<Function> functions;
    // On a function call, we will ensure the function has been defined
    private Conditional winCond; // temporary, we'll need different kinds of conditionals for this
    private Conditional lossCond;

    public Program(Integer aSize, List<Entity> entities, List<Function> functions,
                   Conditional win, Conditional loss) {
        this.arenaSize = aSize;
        this.entities = entities;
        this.functions = functions;
        winCond = win;
        lossCond = loss;
    }

    public Integer getArenaSize() {
        return arenaSize;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public Conditional getWinCond() {
        return winCond;
    }

    public Conditional getLossCond() {
        return lossCond;
    }

    public void setArenaSize(Integer arenaSize) {
        this.arenaSize = arenaSize;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public void setLossCond(Conditional lossCond) {
        this.lossCond = lossCond;
    }

    public void setWinCond(Conditional winCond) {
        this.winCond = winCond;
    }

    @Override
    public void evaluate() {

    }
}
