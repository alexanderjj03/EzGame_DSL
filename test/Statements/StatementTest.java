package Statements;

import astOld.Encapsulators.Function;
import astOld.Entities.Enemy;
import astOld.Instructions.DefineVar;
import astOld.Instructions.ExecFunction;
import astOld.Instructions.Instruction;
import astOld.Program;
import astOld.Statement.MathStatement;
import astOld.Statement.ValueStatement;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatementTest {
    private MathStatement m1;
    private MathStatement m2;
    private MathStatement m3;
    private MathStatement m4;
    private MathStatement m5;
    private MathStatement m6;
    private MathStatement m7;
    private ValueStatement v1;
    private ValueStatement v2;
    private ValueStatement v3;
    private ValueStatement v4;
    private Instruction i1;
    private Enemy e1;
    private Function f;
    private ExecFunction execf;
    private Program p;

    @Before
    public void before() {
        p = new Program(20, null, null, null, null);
        e1 = new Enemy(new ArrayList<>(Arrays.asList(15, 15)), 4, 10, "up",
                2, 1, null);

        HashMap<String, Integer> vars = new HashMap<>();
        vars.put("foo", 5);
        vars.put("bar", 2);
        e1.setVars(vars);

        f = new Function(p, null, new ArrayList<>(Arrays.asList("poofle")), null);

        m1 = new MathStatement(null, null, null, null, null, 6);
        m2 = new MathStatement(null, null, null, null, "poofle", null);
        m3 = new MathStatement(null, null, null, null, "foo", null);
        m4 = new MathStatement(null, m1, m2, "+", null, null);
        m5 = new MathStatement(null, null, null, null, "barf", null);
        m6 = new MathStatement(null, m3, m5, "*", null, null);
        m7 = new MathStatement(null, m4, m6, "+", null, null);

        v1 = new ValueStatement(null, m4, null, null);
        v2 = new ValueStatement(null, m6, null, null);
        v3 = new ValueStatement(null, null, "bar", null);

        f.setReturn(v1);
        execf = new ExecFunction(e1, p, null, null, f, new ArrayList<>(Arrays.asList(7)));

        v4 = new ValueStatement(null, null, null, execf);
        i1 = new DefineVar(e1, p, null, "rabf", v4);

        e1.setBehaviors(new ArrayList<>(Arrays.asList(execf, i1)));
        p.setFunctions(new ArrayList<>(Arrays.asList(f)));
        p.setEntities(new ArrayList<>(Arrays.asList(e1)));
    }

    // Variable tracing: 6 plus "poofle" variable, then a situation that should fail
    @Test
    public void FunctionReturnTest() {
        Integer result = execf.returnFunc();
        assert(result == 13);

        f.setReturn(v2); // Referencing variable outside of current scope, should produce error
        execf = new ExecFunction(e1, p, null, null, f, new ArrayList<>(Arrays.asList(7)));

        try {
            result = execf.returnFunc();
            assert(false);
        } catch (Error e) {
            assert(true);
        }
    }

    // Referencing variables across relevant scopes
    @Test
    public void acrossScopes() {
        f.setReturn(v2);
        execf = new ExecFunction(e1, p, null, null, f, new ArrayList<>(Arrays.asList(7)));
        HashMap<String, Integer> vars = execf.getVars();
        vars.put("barf", 69); // simulates variable definition
        execf.setVars(vars);

        Integer result = execf.returnFunc();
        assert(result == 345);
    }

    // Sorta combining the first two tests with a more complex valueStatement
    @Test
    public void puttingTogether() {
        f.setReturn(new ValueStatement(null, m7, null, null));
        execf = new ExecFunction(e1, p, null, null, f, new ArrayList<>(Arrays.asList(7)));
        HashMap<String, Integer> vars = execf.getVars();
        vars.put("barf", 69); // simulates variable definition
        execf.setVars(vars);

        Integer result = execf.returnFunc();
        assert(result == 358);
    }

    @Test
    public void ValueStatement1() {
        f.setReturn(v3);
        execf = new ExecFunction(e1, p, null, null, f, new ArrayList<>(Arrays.asList(7)));

        Integer result = execf.returnFunc();
        assert(result == 2);
    }

    @Test
    public void ValueStatement2() {
        Integer result = ((DefineVar) i1).getComputed();
        assert(result == 13);
    }
}
