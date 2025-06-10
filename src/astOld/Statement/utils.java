package astOld.Statement;

import astOld.Entities.Entity;
import astOld.Instructions.ExecEncapsulator;
import astOld.Instructions.Instruction;

public class utils {
    // Find variable within current scope. Start with parent instruction then backtrace until Entity object.
    // There's definitely a more efficient way to do this (and im not positive it works but lets see!)
    public static Integer getGlobalVar(String varName, Instruction parent) throws Error {
        Instruction current = parent;
        if (current instanceof ExecEncapsulator) {
            Integer value = ((ExecEncapsulator) current).getVars().get(varName);
            if (value != null) {
                return value;
            }
        }

        if (parent.getParent() != null) {
            current = parent.getParent();
            while (current != null) {
                Integer value = ((ExecEncapsulator) current).getVars().get(varName);
                if (value != null) {
                    return value;
                }

                if (current.getParent() != null) {
                    current = current.getParent();
                } else {
                    break;
                }
            }
        }

        Entity base = current.getEntity();
        Integer value = base.getVars().get(varName);
        if (value != null) {
            return value;
        }
        throw new Error("Invalid referenced variable within current scope");
    }
}
