package parser;

import ast.*;
import ast.Number;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class ParseToASTVisitor extends EZGameParserBaseVisitor<Node> {
    @Override
    public Program visitProgram(EZGameParser.ProgramContext ctx) {
        EZGameParser.Arena_definitionContext arenaDefinitionContext = ctx.arena_definition();
        Arena arena = (Arena) arenaDefinitionContext.accept(this);

        List<Entity> entities = new ArrayList<>();
        EZGameParser.Entity_definitionContext entityDefinitionContext = ctx.entity_definition();
        for (EZGameParser.Entity_declarationContext entityDeclaration : entityDefinitionContext.entity_declaration() ) {
            entities.add((Entity) entityDeclaration.accept(this));
        }

        List<Definition> behaviours = new ArrayList<>();
        EZGameParser.Behavior_definitionContext behaviorDefinitionContext = ctx.behavior_definition();
        for (EZGameParser.InstructionContext behaviour : behaviorDefinitionContext.instruction() ) {
            behaviours.add((Definition) behaviour.accept(this));
        }

        EZGameParser.End_definitionContext endDefinitionContext = ctx.end_definition();
        EndCriteria endCriteria = (EndCriteria) endDefinitionContext.accept(this);

        return new Program(arena, entities, behaviours, endCriteria);
    }

    @Override
    public Arena visitArena_definition(EZGameParser.Arena_definitionContext ctx) {
        EZGameParser.Size_attributeContext sizeAttributeContext = ctx.size_attribute();
        Number size = new Number(Integer.parseInt(sizeAttributeContext.NUM().getText()));

        return new Arena(size);
    }
    
    @Override
    public Entity visitEntity_declaration(EZGameParser.Entity_declarationContext ctx) {
        // Get entity name
        String name = ctx.TEXT().getText();

        // Get entity type
        EZGameParser.Entity_typeContext typeContext = ctx.entity_type();
        EntityType type;
        if (typeContext.PLAYER_TYPE() != null) {
            type = EntityType.PLAYER;
        } else if (typeContext.ENEMY_TYPE() != null) {
            type = EntityType.ENEMY;
        } else if (typeContext.COLLECTABLE_TYPE() != null) {
            type = EntityType.COLLECTABLE;
        } else {
            type = EntityType.OBSTACLE;
        }

        // Get entity attributes
        Pair<Integer, Integer> start = new Pair<>(0, 0);
        Integer size = 1;
        Integer health = 1;
        Integer damage = 0;
        Direction direction = Direction.RIGHT;
        for (EZGameParser.Entity_attributeContext attributeContext : ctx.entity_attribute() ) {
            EZGameParser.Start_attributeContext startAttributeContext = attributeContext.start_attribute();
            if (startAttributeContext != null) {
                EZGameParser.Coordinate_valueContext coordinateValueContext = startAttributeContext.coordinate_value();
                EZGameParser.CoordinateContext coordinateContext = coordinateValueContext.coordinate();
                Integer x = Integer.parseInt(coordinateContext.NUM(0).getText());
                Integer y = Integer.parseInt(coordinateContext.NUM(1).getText());
                start = new Pair<>(x, y);
            }

            EZGameParser.Size_attributeContext sizeAttributeContext = attributeContext.size_attribute();
            if (sizeAttributeContext != null) {
                size = Integer.parseInt(sizeAttributeContext.NUM().getText());
            }

            EZGameParser.Health_attributeContext healthAttributeContext = attributeContext.health_attribute();
            if (healthAttributeContext != null) {
                health = Integer.parseInt(healthAttributeContext.NUM().getText());
            }

            EZGameParser.Direction_attributeContext directionAttributeContext = attributeContext.direction_attribute();
            if (directionAttributeContext != null) {
                EZGameParser.Direction_typeContext directionTypeContext = directionAttributeContext.direction_type();
                if (directionTypeContext.UP() != null) {
                    direction = Direction.UP;
                } else if (directionTypeContext.DOWN() != null) {
                    direction = Direction.DOWN;
                } else if (directionTypeContext.LEFT() != null) {
                    direction = Direction.LEFT;
                } else if (directionTypeContext.RIGHT() != null) {
                    direction = Direction.RIGHT;
                }
            }

            EZGameParser.Damage_attributeContext damageAttributeContext = attributeContext.damage_attribute();
            if (damageAttributeContext != null) {
                damage = Integer.parseInt(damageAttributeContext.NUM().getText());
            }
        }

        return new Entity(name, type, start, size, health, direction, damage);
    }

    // Returns an entity behaviour definition if a given instruction is an entity behaviour definition
    // Else, returns a function definition
    @Override
    public Definition visitInstruction(EZGameParser.InstructionContext ctx) {
        EZGameParser.Entity_instructionContext entityInstructionContext = ctx.entity_instruction();
        if (entityInstructionContext != null) {
            return (EntityBehaviourDefinition) entityInstructionContext.accept(this);
        } else {
            EZGameParser.Function_definitionContext functionDefinitionContext = ctx.function_definition();
            return (FunctionDefinition) functionDefinitionContext.accept(this);
        }
    }

    @Override
    public Instruction visitInstruction_code(EZGameParser.Instruction_codeContext ctx) {
        EZGameParser.Function_instructionContext functionInstructionContext = ctx.function_instruction();

        if (functionInstructionContext != null) {
            // Handle function call
            String name = functionInstructionContext.TEXT().getText();
            List<Value> arguments = new ArrayList<>();

            for (EZGameParser.Math_expressionContext mathExpressionContext : functionInstructionContext.math_expression()) {
                MathStatement mathStatement = (MathStatement) mathExpressionContext.accept(this);
                arguments.add(mathStatement);
            }

            return new FunctionCall(name, arguments);
        } else {
            EZGameParser.Function_codeContext functionCodeContext = ctx.function_code();
            return (Instruction) functionCodeContext.accept(this);
        }
    }

    @Override
    public Instruction visitFunction_code(EZGameParser.Function_codeContext ctx) {
        EZGameParser.Variable_definitionContext variableDefinitionContext = ctx.variable_definition();
        EZGameParser.Variable_mutationContext variableMutationContext = ctx.variable_mutation();
        EZGameParser.Forever_loop_instructionContext foreverLoopInstructionContext = ctx.forever_loop_instruction();
        EZGameParser.Unless_instructionContext unlessInstructionContext = ctx.unless_instruction();
        EZGameParser.Move_instructionContext moveInstructionContext = ctx.move_instruction();
        EZGameParser.Face_instructionContext faceInstructionContext = ctx.face_instruction();
        EZGameParser.Wait_instructionContext waitInstructionContext = ctx.wait_instruction();

        if (variableDefinitionContext != null) {
            return (Instruction) variableDefinitionContext.accept(this);
        } else if (variableMutationContext != null) {
            return (Instruction) variableMutationContext.accept(this);
        } else if (foreverLoopInstructionContext != null) {
            return (Instruction) foreverLoopInstructionContext.accept(this);
        } else if (unlessInstructionContext != null) {
            return (Instruction) unlessInstructionContext.accept(this);
        } else if (moveInstructionContext != null) {
            return (Instruction) moveInstructionContext.accept(this);
        } else if (faceInstructionContext != null) {
            return (Instruction) faceInstructionContext.accept(this);
        } else if (waitInstructionContext != null) {
            return (Instruction) waitInstructionContext.accept(this);
        } else {
            return null;
        }
    }

    @Override
    public Instruction visitVariable_definition(EZGameParser.Variable_definitionContext ctx) {
        String name = ctx.TEXT().getText();
        EZGameParser.Variable_valueContext variableValueContext = ctx.variable_value();
        Value value = (Value) variableValueContext.accept(this);

        return new VarDeclInstruction(name, value);
    }

    @Override
    public Instruction visitVariable_mutation(EZGameParser.Variable_mutationContext ctx) {
        String name = ctx.TEXT().getText();
        EZGameParser.Variable_valueContext variableValueContext = ctx.variable_value();
        Value value = (Value) variableValueContext.accept(this);

        return new VarSetInstruction(name, value);
    }

    @Override
    public ForeverLoop visitForever_loop_instruction(EZGameParser.Forever_loop_instructionContext ctx) {
        return new ForeverLoop((UnlessInstruction) ctx.unless_instruction().accept(this));
    }

    @Override
    public UnlessInstruction visitUnless_instruction(EZGameParser.Unless_instructionContext ctx) {
        List<Instruction> instructions = new ArrayList<>();
        for (EZGameParser.Function_codeContext functionCtx : ctx.function_code()) {
            Instruction instruction = (Instruction) functionCtx.accept(this);
            instructions.add(instruction);
        }

        return new UnlessInstruction((BooleanStatement) ctx.boolean_statement().accept(this), instructions);
    }

    @Override
    public Value visitVariable_value(EZGameParser.Variable_valueContext ctx) {
        EZGameParser.Math_expressionContext mathExpressionContext = ctx.math_expression();
        return (MathStatement) mathExpressionContext.accept(this);
    }

    @Override
    public Definition visitFunction_definition(EZGameParser.Function_definitionContext ctx) {
        String name = ctx.TEXT(0).getText();
        List<String> parameters = new ArrayList<>();
        List<Instruction> instructions = new ArrayList<>();

        for (int i = 1; i < ctx.TEXT().size() ; i++) {
            parameters.add(ctx.TEXT(i).getText());
        }

        for (EZGameParser.Function_codeContext functionCodeContext : ctx.function_code()) {
            Instruction instruction = (Instruction) functionCodeContext.accept(this);
            instructions.add(instruction);
        }

        return new FunctionDefinition(name, parameters, instructions);
    }

    @Override
    public Definition visitEntity_instruction(EZGameParser.Entity_instructionContext ctx) {
        String name = ctx.TEXT().getText();
        List<Instruction> instructions = new ArrayList<>();
        for (EZGameParser.Instruction_codeContext instructionCodeContext : ctx.instruction_code() ) {
            Instruction instruction = (Instruction) instructionCodeContext.accept(this);
            instructions.add(instruction);
        }

        return new EntityBehaviourDefinition(name, instructions);
    }

    @Override
    public MoveInstruction visitMove_instruction(EZGameParser.Move_instructionContext ctx) {
        return (MoveInstruction) ctx.move_type().accept(this);
    }

    @Override
    public MoveInstruction visitMove_type(EZGameParser.Move_typeContext ctx) {
        if (ctx.coordinate_value() != null) {
            EZGameParser.Coordinate_valueContext coordValueCtx = ctx.coordinate_value();
            EZGameParser.CoordinateContext coordCtx = coordValueCtx.coordinate();
            Integer x = Integer.parseInt(coordCtx.NUM(0).getText());
            Integer y = Integer.parseInt(coordCtx.NUM(1).getText());
            return new MoveInstruction(MoveType.COORDINATE, new Pair<>(x,y), null);
        } else {
            return new MoveInstruction(MoveType.DISPLACEMENT, null, (Value) ctx.math_expression().accept(this));
        }
    }

    @Override
    public FaceInstruction visitFace_instruction(EZGameParser.Face_instructionContext ctx) {
        Direction dir;
        EZGameParser.Direction_typeContext dirCtx = ctx.direction_type();
        if (dirCtx.UP() != null) {
            dir = Direction.UP;
        } else if (dirCtx.DOWN() != null) {
            dir = Direction.DOWN;
        } else if (dirCtx.LEFT() != null) {
            dir = Direction.LEFT;
        } else {
            dir = Direction.RIGHT;
        }

        return new FaceInstruction(dir);
    }

    @Override
    public WaitInstruction visitWait_instruction(EZGameParser.Wait_instructionContext ctx) {
        return new WaitInstruction((Value) ctx.math_expression().accept(this));
    }

    @Override
    public FunctionCall visitFunction_instruction(EZGameParser.Function_instructionContext ctx) {
        List<Value> arguments = new ArrayList<>();
        for (EZGameParser.Math_expressionContext mathCtx : ctx.math_expression()) {
            arguments.add((Value) mathCtx.accept(this));
        }

        return new FunctionCall(ctx.TEXT().getText(), arguments);
    }

    @Override
    public BooleanStatement visitBoolean_statement(EZGameParser.Boolean_statementContext ctx) {
        if (ctx.boolean_clause() != null) {
            return new BooleanStatement(BooleanType.CLAUSE, null, null, (BooleanClause) ctx.boolean_clause().accept(this));
        } else if (ctx.boolean_conjuction() != null) {
            return new BooleanStatement(BooleanType.OPERATION, (BooleanOperation) ctx.boolean_conjuction().accept(this), null, null);
        } else {
            return new BooleanStatement(BooleanType.NEGATION, null, (BooleanNegation) ctx.boolean_negation().accept(this), null);
        }
    }

    @Override
    public BooleanOperation visitBoolean_conjuction(EZGameParser.Boolean_conjuctionContext ctx) {
        EZGameParser.Conjuction_opContext opCtx = ctx.conjuction_op();
        return new BooleanOperation((BooleanStatement) ctx.boolean_statement(0).accept(this), opCtx.AND() != null ? "AND" : "OR", (BooleanStatement) ctx.boolean_statement(1).accept(this));
    }

    @Override
    public BooleanNegation visitBoolean_negation(EZGameParser.Boolean_negationContext ctx) {
        return new BooleanNegation((BooleanStatement) ctx.boolean_statement().accept(this));
    }

    @Override
    public BooleanClause visitBoolean_clause(EZGameParser.Boolean_clauseContext ctx) {
        if (ctx.comparison_clause() != null) {
            return (BooleanClause) ctx.comparison_clause().accept(this);
        } else {
            return (BooleanClause) ctx.on_clause().accept(this);
        }
    }
    
    @Override
    public Node visitComparison_clause(EZGameParser.Comparison_clauseContext ctx) {
        return new Comparison((MathStatement) ctx.math_expression(0).accept(this), ctx.comparison_operator().getText(), (MathStatement) ctx.math_expression(1).accept(this));
    }

    @Override
    public Node visitOn_clause(EZGameParser.On_clauseContext ctx) {
        EZGameParser.CoordinateContext coordCtx = ctx.coordinate();
        Integer x = Integer.parseInt(coordCtx.NUM(0).getText());
        Integer y = Integer.parseInt(coordCtx.NUM(1).getText());
        return new OnPos(OnPosType.COORDINATE, new Pair<>(x, y), null);
    }
    
    @Override
    public EndCriteria visitEnd_definition(EZGameParser.End_definitionContext ctx) {
        String winEntityName = null;
        EndCriteriaType winType = null;
        Integer winValue = null;
        String loseEntityName = null;
        EndCriteriaType loseType = null;
        Integer loseValue = null;

        if (ctx.win_instruction() != null) {
            EZGameParser.End_statementContext endCtx = ctx.win_instruction().end_statement();
            winEntityName = endCtx.TEXT().getText();
            winType = endCtx.end_attribute().AMOUNT() != null ? EndCriteriaType.AMOUNT : EndCriteriaType.HEALTH;
            winValue = Integer.parseInt(endCtx.NUM().getText());
        }
        if (ctx.lose_instruction() != null) {
            EZGameParser.End_statementContext endCtx = ctx.lose_instruction().end_statement();
            loseEntityName = endCtx.TEXT().getText();
            loseType = endCtx.end_attribute().AMOUNT() != null ? EndCriteriaType.AMOUNT : EndCriteriaType.HEALTH;
            loseValue = Integer.parseInt(endCtx.NUM().getText());
        }

        return new EndCriteria(winEntityName, winType, winValue, loseEntityName, loseType, loseValue);
    }

    @Override
    public MathStatement visitMath_expression(EZGameParser.Math_expressionContext ctx) {
        if (ctx.math_expression_operation().isEmpty()) {
            return new MathStatement((MathTerm) ctx.math_term().accept(this), null, null);
        }

        MathTerm term = null;
        for (int i = ctx.math_expression_operation().size() - 1; i > 0; i--) {
            if (i == ctx.math_expression_operation().size() - 1) {
                term = (MathTerm) ctx.math_expression_operation(i).math_term().accept(this);
            }
            EZGameParser.Math_expression_operationContext opCtx = ctx.math_expression_operation(i);
            term = new MathTerm(new MathFactor(MathFactorType.STATEMENT, null, null, new MathStatement((MathTerm) ctx.math_expression_operation(i-1).math_term().accept(this), opCtx.ADD() != null ? opCtx.ADD().getText() : opCtx.SUB().getText(), term)), null, null);
        }

        EZGameParser.Math_expression_operationContext opCtx = ctx.math_expression_operation(0);
        return new MathStatement((MathTerm) ctx.math_term().accept(this), opCtx.ADD() != null ? opCtx.ADD().getText() : opCtx.SUB().getText(), term != null ? term : (MathTerm) opCtx.math_term().accept(this));
    }
    
    @Override
    public MathTerm visitMath_term(EZGameParser.Math_termContext ctx) {
        if (ctx.math_term_operation().isEmpty()) {
            return new MathTerm((MathFactor) ctx.math_factor().accept(this), null, null);
        }

        MathFactor factor = null;
        for (int i = ctx.math_term_operation().size() - 1; i > 0; i--) {
            if (i == ctx.math_term_operation().size() - 1) {
                factor = (MathFactor) ctx.math_term_operation(i).math_factor().accept(this);
            }
            EZGameParser.Math_term_operationContext opCtx = ctx.math_term_operation(i);
            factor = new MathFactor(MathFactorType.STATEMENT, null, null, new MathStatement(new MathTerm((MathFactor) ctx.math_term_operation(i - 1).math_factor().accept(this), opCtx.DIV() != null ? opCtx.DIV().getText() : opCtx.MUL().getText(), factor), null, null));
        }

        EZGameParser.Math_term_operationContext opCtx = ctx.math_term_operation(0);
        return new MathTerm((MathFactor) ctx.math_factor().accept(this), opCtx.DIV() != null ? opCtx.DIV().getText() : opCtx.MUL().getText(), factor != null ? factor : (MathFactor) opCtx.math_factor().accept(this));
    }

    @Override
    public MathFactor visitMath_factor(EZGameParser.Math_factorContext ctx) {
        if (ctx.math_expression() != null) {
            return new MathFactor(MathFactorType.STATEMENT, null, null, (MathStatement) ctx.math_expression().accept(this));
        } else if (ctx.NUM() != null) {
            return new MathFactor(MathFactorType.NUM, new Number(Integer.parseInt(ctx.NUM().getText())), null, null);
        } else {
            return new MathFactor(MathFactorType.VARIABLE, null, ctx.TEXT().getText(), null);
        }
    }
}
