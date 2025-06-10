// Generated from /Users/alexanderjacobson/Dropbox/UBC/yr 4/CPSC 410/Group1Project1/src/parser/EZGameParser.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EZGameParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EZGameParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EZGameParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EZGameParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#arena_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArena_definition(EZGameParser.Arena_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#entity_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_definition(EZGameParser.Entity_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#entity_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_declaration(EZGameParser.Entity_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#entity_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_type(EZGameParser.Entity_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#entity_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_attribute(EZGameParser.Entity_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#start_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_attribute(EZGameParser.Start_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#coordinate_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinate_value(EZGameParser.Coordinate_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#coordinate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinate(EZGameParser.CoordinateContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#health_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHealth_attribute(EZGameParser.Health_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#size_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize_attribute(EZGameParser.Size_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#direction_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection_attribute(EZGameParser.Direction_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#direction_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection_type(EZGameParser.Direction_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#damage_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDamage_attribute(EZGameParser.Damage_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#behavior_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior_definition(EZGameParser.Behavior_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(EZGameParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#variable_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_definition(EZGameParser.Variable_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#variable_mutation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_mutation(EZGameParser.Variable_mutationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#variable_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_value(EZGameParser.Variable_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(EZGameParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#function_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_code(EZGameParser.Function_codeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#forever_loop_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForever_loop_instruction(EZGameParser.Forever_loop_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#entity_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_instruction(EZGameParser.Entity_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#instruction_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_code(EZGameParser.Instruction_codeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#move_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove_instruction(EZGameParser.Move_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#move_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove_type(EZGameParser.Move_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#face_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFace_instruction(EZGameParser.Face_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#wait_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWait_instruction(EZGameParser.Wait_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#value_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_statement(EZGameParser.Value_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#function_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_instruction(EZGameParser.Function_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#unless_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnless_instruction(EZGameParser.Unless_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#boolean_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_statement(EZGameParser.Boolean_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#boolean_conjuction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_conjuction(EZGameParser.Boolean_conjuctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#conjuction_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjuction_op(EZGameParser.Conjuction_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#boolean_negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_negation(EZGameParser.Boolean_negationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#boolean_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_clause(EZGameParser.Boolean_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#comparison_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_clause(EZGameParser.Comparison_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operator(EZGameParser.Comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#on_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn_clause(EZGameParser.On_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#end_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_definition(EZGameParser.End_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#win_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWin_instruction(EZGameParser.Win_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#lose_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLose_instruction(EZGameParser.Lose_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#end_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_statement(EZGameParser.End_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#end_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_attribute(EZGameParser.End_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#math_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_expression(EZGameParser.Math_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#math_expression_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_expression_operation(EZGameParser.Math_expression_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#math_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_term(EZGameParser.Math_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#math_term_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_term_operation(EZGameParser.Math_term_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZGameParser#math_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_factor(EZGameParser.Math_factorContext ctx);
}