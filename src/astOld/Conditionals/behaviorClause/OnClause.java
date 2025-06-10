package astOld.Conditionals.behaviorClause;

import astOld.Entities.Entity;
import astOld.Program;

import java.util.List;

public class OnClause extends Clause {
    private Entity hostEntity;
    private List<Integer> coordinates;
    private Entity target; // either this or coordinates is null


    public OnClause(Program p, Entity e, List<Integer> coords, Entity Target) {
        super(p);
        hostEntity = e;
        coordinates = coords;
        target = Target;
    }

    public Entity getEntity() {
        return hostEntity;
    }

    public List<Integer> getCoords() {
        return coordinates;
    }

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity e) {
        target = e;
    }

    public void setEntity(Entity e) {
        hostEntity = e;
    }

    public void setCoordinates(List<Integer> coords) {
        coordinates = coords;
    }

    @Override
    public void evaluate() {

    }
}
