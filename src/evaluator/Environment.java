package evaluator;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private final Map<String, Integer> environment = new HashMap<>();
    private final Map<Integer, Integer> memory = new HashMap<>();
    private Environment parent;
    private int memptr = 0;

    private Integer getFreshLocation() {
        Integer loc = memptr;
        memptr += 1;
        return loc;
    }

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public void declare(String name, Integer val) {
        Integer loc = getFreshLocation();
        environment.put(name, loc);
        memory.put(loc, val);
    }

    public void setVar(String name, Integer val) {
        if (environment.containsKey(name)) {
            Integer loc = environment.get(name);
            memory.put(loc, val);
        } else if (parent != null) {
            parent.setVar(name, val);
        } else {
            throw new Error("Referenced variable has not been initialized");
        }
    }

    public Integer getVar(String name) {
        if (environment.containsKey(name)) {
            return memory.get(environment.get(name));
        } else if (parent != null) {
            return parent.getVar(name);
        }

        // DEAL WITH IT
        return null;
    }

    public Integer getSize() {
        return environment.size();
    }

    public Environment getParent() {
        return parent;
    }

}
