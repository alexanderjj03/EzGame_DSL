package ast;

public interface EZGameVisitor<C,T> {
    T visit(C context, Program p);
    T visit(C context, Arena a);
    T visit(C context, BooleanNegation bn);
    T visit(C context, BooleanOperation bo);
    T visit(C context, BooleanStatement bs);
    T visit(C context, Comparison c);
    T visit(C context, EndCriteria ec);
    T visit(C context, Entity e);
    T visit(C context, EntityBehaviourDefinition ebd);
    T visit(C context, FaceInstruction fi);
    T visit(C context, ForeverLoop fl);
    T visit(C context, FunctionCall fc);
    T visit(C context, FunctionDefinition fd);
    T visit(C context, MathFactor mf);
    T visit(C context, MathStatement ms);
    T visit(C context, MathTerm mt);
    T visit(C context, MoveInstruction mi);
    T visit(C context, Number num);
    T visit(C context, OnPos op);
    T visit(C context, UnlessInstruction ui);
    T visit(C context, VarDeclInstruction vdi);
    T visit(C context, VarSetInstruction vsi);
    T visit(C context, WaitInstruction wi);
}
