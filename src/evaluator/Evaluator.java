package evaluator;

import Errors.ArenaTooLargeError;
import Errors.DuplicatePlayerDefinedError;
import Errors.EntityStartOutOfBounds;
import Errors.InvalidEntityError;
import ast.Number;
import ast.*;
import game.InstructionNode;
import game.InstructionType;
import gamemaker.EZGameBuilder;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Evaluator implements EZGameVisitor<EZGameBuilder, Integer> {
    private final Map<String, FunctionDefinition> funcMap = new HashMap<>();
    private final Map<String, game.Direction> entityDirMap = new HashMap<>();
    private final Map<String, Pair<Integer, Integer>> entityPosMap = new HashMap<>();
    private int memptr = 0;
    private String currEntity;
    private Environment currEnvironment;

    private Integer getFreshLocation() {
        Integer loc = memptr;
        memptr += 1;
        return loc;
    }

    public Evaluator() {
        // Start with a global scope
        currEnvironment = new Environment(null);
    }

    @Override
    public Integer visit(EZGameBuilder context, Program p) {
        System.out.println("Called Visit Program");
        p.getArena().accept(context, this);
        for (Entity entity : p.getEntities()) {
            entity.accept(context, this);
        }
        for (Definition definition : p.getBehaviours()) {
            definition.accept(context, this);
        }
        p.getEndCriteria().accept(context, this);
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, Arena a) {
        System.out.println("Evaluate: Arena");
        if (a.getSize().getNumber() > 50) {
            throw new ArenaTooLargeError("Arena is too large, set a size that is less than or equal to 50");
        }
        context.addArena(a.getSize().getNumber(), a.getSize().getNumber(), 25);
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, BooleanNegation bn) {
        try {
            Integer curr = bn.getStatement().accept(context, this);
            return (curr == 0) ? 1 : 0;
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    @Override
    public Integer visit(EZGameBuilder context, BooleanOperation bo) {
        try {
            Integer firstStatement = bo.getStatement1().accept(context, this);
            try {
                Integer secondStatement = bo.getStatement2().accept(context, this);
                String operator = bo.getOperator();
                if (operator.equals("or")) {
                    return (firstStatement | secondStatement);
                } else if (operator.equals("and")) {
                    return (firstStatement & secondStatement);
                }
            } catch (Error e1) {
                throw new Error("Boolean Statement 2: " + e1.getMessage());
            }
        } catch (Error e) {
            throw new Error("Boolean Statement 1: " + e.getMessage());
        }
        throw new Error("Invalid boolean operation type");
    }

    @Override
    public Integer visit(EZGameBuilder context, BooleanStatement bs) {
        BooleanType booleanType = bs.getType();
        try {
            switch (booleanType) {
                case OPERATION -> {
                    return bs.getOperation().accept(context, this);
                }
                case CLAUSE -> {
                    return bs.getClause().accept(context, this);
                }
                case NEGATION -> {
                    return bs.getNegation().accept(context, this);
                }
            }
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
        throw new Error("Invalid boolean statement type");
    }

    @Override
    public Integer visit(EZGameBuilder context, Comparison c) {
        try {
            Integer mathStatement1 = c.getMathStatement1().accept(context, this);
            try {
                Integer mathStatement2 = c.getMathStatement2().accept(context, this);
                if (mathStatement1 == null) {
                    throw new Error("Variable " + c.getMathStatement1().getTerm1() + " is null");
                } else if (mathStatement2 == null) {
                    throw new Error("Variable " + c.getMathStatement1().getTerm1() + " is null");
                }
                String operator = c.getOperator();
                return switch (operator) {
                    case "<" -> mathStatement1 < mathStatement2 ? 1 : 0;
                    case ">" -> mathStatement1 > mathStatement2 ? 1 : 0;
                    case "<=" -> mathStatement1 <= mathStatement2 ? 1 : 0;
                    case " equals " -> mathStatement1.equals(mathStatement2) ? 1 : 0;
                    default -> throw new Error("Invalid operator:" + operator);
                };
            } catch (Error e1) {
                throw new Error("Math Statement 2: " + e1.getMessage());
            }
        } catch (Error e) {
            throw new Error("Math Statement 1: " + e.getMessage());
        }
    }

    @Override
    public Integer visit(EZGameBuilder context, EndCriteria ec) {
        String winName = ec.getWinEntityName();
        EndCriteriaType winType = ec.getWinType();
        Integer winVal = ec.getWinValue();
        String loseName = ec.getLoseEntityName();
        EndCriteriaType loseType = ec.getLoseType();
        Integer loseVal = ec.getLoseValue();

        context.addEndCriteria(new game.EndCriteria(winName, winType, winVal, loseName, loseType, loseVal));
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, Entity e) {
        System.out.println("Evaluate: Add Entity");
        this.entityDirMap.put(e.getName(), game.Direction.valueOf(e.getDirection().name()));
        this.entityPosMap.put(e.getName(), e.getStart());

        // In our program # cols = # rows
        Integer arenaHeightAndWidth = context.build().getCols();

        if (context.build().getPlayer() != null && e.getType() == EntityType.PLAYER) {
            throw new DuplicatePlayerDefinedError();
        }

        if (e.getStart().a > arenaHeightAndWidth || e.getStart().b > arenaHeightAndWidth) {
            throw new EntityStartOutOfBounds("Entity " + e.getName() + " has start coordinates out of bounds");
        }


        EntityType type = e.getType();
        switch (type) {
            case PLAYER -> {
                context.addPlayerEntity(e.getName(),
                        e.getStart().a, e.getStart().b, e.getHealth(), e.getSize());
            }
            case ENEMY -> {
                context.addEnemyEntity(e.getName(), e.getStart().a, e.getStart().b,
                        e.getHealth(), e.getDamage(), game.Direction.valueOf(e.getDirection().name()), e.getSize());
            }
            case COLLECTABLE -> {
                context.addCollectableEntity(e.getName(), e.getStart().a,
                        e.getStart().b, game.Direction.valueOf(e.getDirection().name()), 1, e.getSize());
            }
            case OBSTACLE -> {
                context.addObstacleEntity(e.getName(), e.getStart().a,
                        e.getStart().b, game.Direction.valueOf(e.getDirection().name()), e.getSize());
            }
            default -> throw new Error("Invalid entity type: " + type);
        }

        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, EntityBehaviourDefinition ebd) {
        currEnvironment = new Environment(currEnvironment);
        if (!entityDirMap.containsKey(ebd.getName())) {
            throw new InvalidEntityError("The entity " + ebd.getName() + " has not been defined");
        }
        this.currEntity = ebd.getName();
        for (Instruction instruction : ebd.getInstructions()) {
            try {
                instruction.accept(context, this);
            } catch (Error e) {
                throw new Error(e.getMessage());
            }
        }
        currEnvironment = currEnvironment.getParent();
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, FaceInstruction fi) {
        try {
            game.Direction direction = game.Direction.valueOf(fi.getDirection().name());
            entityDirMap.replace(currEntity, direction);
            context.addBehaviour(currEntity, new InstructionNode(InstructionType.FACE, direction));
            return null;
        } catch (Error e) {
            throw new Error("Invalid direction in face instruction");
        }
    }

    @Override
    public Integer visit(EZGameBuilder context, ForeverLoop fl) {
        UnlessInstruction unless = fl.getUnless();
        int count = 1;
        Integer currCond = unless.accept(context, this);

        while (currCond == 0) {
            count++;
            currCond = unless.accept(context, this);
            if (count == 1000000) {
                throw new Error("Maximum loop repetions reached");
            }
        }

        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, FunctionCall fc) {
        if (!funcMap.containsKey(fc.getName())) {
            // Deal with it
        }
        FunctionDefinition fd = funcMap.get(fc.getName());
        currEnvironment = new Environment(currEnvironment);

        List<String> parameters = fd.getParameters();
        List<Value> arguments = fc.getArguments();
        // We prob need to check if they have the same number of arguments
        // TODO: add arguments

        if (parameters.size() != arguments.size()) {
            // DEAL WITH IT
            return null;
        }

        for (int i = 0; i < parameters.size(); i++) {
            currEnvironment.declare(parameters.get(i), arguments.get(i).accept(context, this));
        }

        for (Instruction instruction : fd.getInstructions()) {
            instruction.accept(context, this);
        }

        currEnvironment = currEnvironment.getParent();

        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, FunctionDefinition fd) {
        funcMap.put(fd.getName(), fd);
        // End Until called
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, MathFactor mf) {
        MathFactorType type = mf.getType();
        try {
            switch (type) {
                case NUM -> {
                    return mf.getNum().accept(context, this);
                }
                case VARIABLE -> {
                    String varName = mf.getVariable();
                    return currEnvironment.getVar(varName);
                }
                case STATEMENT -> {
                    return mf.getStatement().accept(context, this);
                }
            }
        } catch (Error e) {
            throw new Error(e.getMessage());
        }

        throw new Error("Invalid math factor type (can only be numerical, a variable, or a math statement)");
    }

    @Override
    public Integer visit(EZGameBuilder context, MathStatement ms) {
        String operator = ms.getOperator();
        try {
            Integer firstTerm = ms.getTerm1().accept(context, this);
            if (operator == null) {
                return firstTerm;
            }
            Integer secondTerm = ms.getTerm2().accept(context, this);
            System.out.println("Operator: " + operator);
            switch (operator) {
                case "+" -> {
                    return firstTerm + secondTerm;
                }
                case "-" -> {
                    return firstTerm - secondTerm;
                }
                case "*" -> {
                    return firstTerm * secondTerm;
                }
                case "/" -> {
                    if (secondTerm == 0) {
                        throw new Error("Cannot divide by 0");
                    }
                    return firstTerm / secondTerm;
                }
                default -> throw new Error("Invalid math operator, can only be +-/*");
            }
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    @Override
    public Integer visit(EZGameBuilder context, MathTerm mt) {
        String operator = mt.getOperator();
        try {
            Integer firstFactor = mt.getFactor1().accept(context, this);
            if (operator == null) {
                return firstFactor;
            }
            Integer secondFactor = mt.getFactor2().accept(context, this);

            switch (operator) {
                case "+" -> {
                    return firstFactor + secondFactor;
                }
                case "-" -> {
                    return firstFactor - secondFactor;
                }
                case "*" -> {
                    return firstFactor * secondFactor;
                }
                case "/" -> {
                    if (secondFactor == 0) {
                        throw new Error("Cannot divide by 0");
                    }
                    return firstFactor / secondFactor;
                }
                default -> throw new Error("Invalid math operator, can only be +-/*");
            }
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    @Override
    public Integer visit(EZGameBuilder context, MoveInstruction mi) {
        MoveType type = mi.getType();
        switch (type) {
            case COORDINATE -> {
                Pair<Integer, Integer> coordinate = mi.getCoordinate();
                entityPosMap.replace(currEntity, coordinate);
                context.addBehaviour(currEntity, new InstructionNode(InstructionType.MOVE_COORD, coordinate.a, coordinate.b));
            }
            case DISPLACEMENT -> {
                try {
                    Integer moveAmount = mi.getDisplacement().accept(context, this);

                    if (entityDirMap.containsKey(currEntity) && entityPosMap.containsKey(currEntity)) {
                        Pair<Integer, Integer> coordinate = entityPosMap.get(currEntity);
                        Integer x = coordinate.a;
                        Integer y = coordinate.b;
                        if (entityDirMap.get(currEntity) == game.Direction.UP) {
                            entityPosMap.replace(currEntity, new Pair<>(x, y + moveAmount));
                        } else if (entityDirMap.get(currEntity) == game.Direction.DOWN) {
                            entityPosMap.replace(currEntity, new Pair<>(x, y - moveAmount));
                        } else if (entityDirMap.get(currEntity) == game.Direction.LEFT) {
                            entityPosMap.replace(currEntity, new Pair<>(x - moveAmount, y));
                        } else {
                            entityPosMap.replace(currEntity, new Pair<>(x + moveAmount, y));
                        }
                    } else {
                        // oopsies
                    }
                    for (int i = 0; i < moveAmount; i++) {
                        context.addBehaviour(currEntity, new InstructionNode(InstructionType.MOVE_DISP, 1));
                    }
                } catch (Error e) {
                    throw new Error("Move amount can't be computed: " + e.getMessage());
                }
            }
            default -> throw new Error("Invalid move instruction type");
        }
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, Number num) {
        return num.getNumber();
    }

    @Override
    public Integer visit(EZGameBuilder context, OnPos op) {
        Pair<Integer, Integer> coordinate = op.getCoordinate();

        if (entityPosMap.containsKey(currEntity)) {
            Pair<Integer, Integer> entityCoordinate = entityPosMap.get(currEntity);
            if (Objects.equals(entityCoordinate.a, coordinate.a) && Objects.equals(entityCoordinate.b, coordinate.b)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // oopsies
        }

        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, UnlessInstruction ui) {
        try {
            Integer result = ui.getBooleanStatement().accept(context, this);
            // TODO: We gotta think of dynamic stuff too
            if (result == 0) {
                currEnvironment = new Environment(currEnvironment);
                for (Instruction instruction : ui.getInstructions()) {
                    instruction.accept(context, this);
                }
                currEnvironment = currEnvironment.getParent();
            }
            return result;
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    @Override
    public Integer visit(EZGameBuilder context, VarDeclInstruction vdi) {
        currEnvironment.declare(vdi.getName(), vdi.getValue().accept(context, this));
        System.out.println("GET DECLARED VALUE:" + currEnvironment.getVar(vdi.getName()));
        System.out.println("SIZE OF MEMORY" + currEnvironment.getSize());
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, VarSetInstruction vsi) {
        currEnvironment.setVar(vsi.getName(), vsi.getValue().accept(context, this));
        System.out.println("GET SET VALUE:" + currEnvironment.getVar(vsi.getName()));
        return null;
    }

    @Override
    public Integer visit(EZGameBuilder context, WaitInstruction wi) {
        try {
            Integer waitVal = wi.getSeconds().accept(context, this);
            context.addBehaviour(currEntity, new InstructionNode(InstructionType.WAIT, waitVal));
            return null;
        } catch (Error e) {
            throw new Error(e.getMessage());
        }
    }

    public Environment getEnvironment() {
        return currEnvironment;
    }
}
