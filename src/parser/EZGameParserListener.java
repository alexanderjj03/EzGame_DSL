// Generated from /Users/alexanderjacobson/Dropbox/UBC/yr 4/CPSC 410/Group1Project1/src/parser/EZGameParser.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EZGameParser}.
 */
public interface EZGameParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EZGameParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EZGameParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EZGameParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#arena_definition}.
	 * @param ctx the parse tree
	 */
	void enterArena_definition(EZGameParser.Arena_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#arena_definition}.
	 * @param ctx the parse tree
	 */
	void exitArena_definition(EZGameParser.Arena_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#entity_definition}.
	 * @param ctx the parse tree
	 */
	void enterEntity_definition(EZGameParser.Entity_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#entity_definition}.
	 * @param ctx the parse tree
	 */
	void exitEntity_definition(EZGameParser.Entity_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#entity_declaration}.
	 * @param ctx the parse tree
	 */
	void enterEntity_declaration(EZGameParser.Entity_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#entity_declaration}.
	 * @param ctx the parse tree
	 */
	void exitEntity_declaration(EZGameParser.Entity_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#entity_type}.
	 * @param ctx the parse tree
	 */
	void enterEntity_type(EZGameParser.Entity_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#entity_type}.
	 * @param ctx the parse tree
	 */
	void exitEntity_type(EZGameParser.Entity_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#entity_attribute}.
	 * @param ctx the parse tree
	 */
	void enterEntity_attribute(EZGameParser.Entity_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#entity_attribute}.
	 * @param ctx the parse tree
	 */
	void exitEntity_attribute(EZGameParser.Entity_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#start_attribute}.
	 * @param ctx the parse tree
	 */
	void enterStart_attribute(EZGameParser.Start_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#start_attribute}.
	 * @param ctx the parse tree
	 */
	void exitStart_attribute(EZGameParser.Start_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#coordinate_value}.
	 * @param ctx the parse tree
	 */
	void enterCoordinate_value(EZGameParser.Coordinate_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#coordinate_value}.
	 * @param ctx the parse tree
	 */
	void exitCoordinate_value(EZGameParser.Coordinate_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void enterCoordinate(EZGameParser.CoordinateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#coordinate}.
	 * @param ctx the parse tree
	 */
	void exitCoordinate(EZGameParser.CoordinateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#health_attribute}.
	 * @param ctx the parse tree
	 */
	void enterHealth_attribute(EZGameParser.Health_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#health_attribute}.
	 * @param ctx the parse tree
	 */
	void exitHealth_attribute(EZGameParser.Health_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#size_attribute}.
	 * @param ctx the parse tree
	 */
	void enterSize_attribute(EZGameParser.Size_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#size_attribute}.
	 * @param ctx the parse tree
	 */
	void exitSize_attribute(EZGameParser.Size_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#direction_attribute}.
	 * @param ctx the parse tree
	 */
	void enterDirection_attribute(EZGameParser.Direction_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#direction_attribute}.
	 * @param ctx the parse tree
	 */
	void exitDirection_attribute(EZGameParser.Direction_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#direction_type}.
	 * @param ctx the parse tree
	 */
	void enterDirection_type(EZGameParser.Direction_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#direction_type}.
	 * @param ctx the parse tree
	 */
	void exitDirection_type(EZGameParser.Direction_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#damage_attribute}.
	 * @param ctx the parse tree
	 */
	void enterDamage_attribute(EZGameParser.Damage_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#damage_attribute}.
	 * @param ctx the parse tree
	 */
	void exitDamage_attribute(EZGameParser.Damage_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#behavior_definition}.
	 * @param ctx the parse tree
	 */
	void enterBehavior_definition(EZGameParser.Behavior_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#behavior_definition}.
	 * @param ctx the parse tree
	 */
	void exitBehavior_definition(EZGameParser.Behavior_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(EZGameParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(EZGameParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void enterVariable_definition(EZGameParser.Variable_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void exitVariable_definition(EZGameParser.Variable_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#variable_mutation}.
	 * @param ctx the parse tree
	 */
	void enterVariable_mutation(EZGameParser.Variable_mutationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#variable_mutation}.
	 * @param ctx the parse tree
	 */
	void exitVariable_mutation(EZGameParser.Variable_mutationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#variable_value}.
	 * @param ctx the parse tree
	 */
	void enterVariable_value(EZGameParser.Variable_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#variable_value}.
	 * @param ctx the parse tree
	 */
	void exitVariable_value(EZGameParser.Variable_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(EZGameParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(EZGameParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#function_code}.
	 * @param ctx the parse tree
	 */
	void enterFunction_code(EZGameParser.Function_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#function_code}.
	 * @param ctx the parse tree
	 */
	void exitFunction_code(EZGameParser.Function_codeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#forever_loop_instruction}.
	 * @param ctx the parse tree
	 */
	void enterForever_loop_instruction(EZGameParser.Forever_loop_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#forever_loop_instruction}.
	 * @param ctx the parse tree
	 */
	void exitForever_loop_instruction(EZGameParser.Forever_loop_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#entity_instruction}.
	 * @param ctx the parse tree
	 */
	void enterEntity_instruction(EZGameParser.Entity_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#entity_instruction}.
	 * @param ctx the parse tree
	 */
	void exitEntity_instruction(EZGameParser.Entity_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#instruction_code}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_code(EZGameParser.Instruction_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#instruction_code}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_code(EZGameParser.Instruction_codeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#move_instruction}.
	 * @param ctx the parse tree
	 */
	void enterMove_instruction(EZGameParser.Move_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#move_instruction}.
	 * @param ctx the parse tree
	 */
	void exitMove_instruction(EZGameParser.Move_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#move_type}.
	 * @param ctx the parse tree
	 */
	void enterMove_type(EZGameParser.Move_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#move_type}.
	 * @param ctx the parse tree
	 */
	void exitMove_type(EZGameParser.Move_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#face_instruction}.
	 * @param ctx the parse tree
	 */
	void enterFace_instruction(EZGameParser.Face_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#face_instruction}.
	 * @param ctx the parse tree
	 */
	void exitFace_instruction(EZGameParser.Face_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#wait_instruction}.
	 * @param ctx the parse tree
	 */
	void enterWait_instruction(EZGameParser.Wait_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#wait_instruction}.
	 * @param ctx the parse tree
	 */
	void exitWait_instruction(EZGameParser.Wait_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#value_statement}.
	 * @param ctx the parse tree
	 */
	void enterValue_statement(EZGameParser.Value_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#value_statement}.
	 * @param ctx the parse tree
	 */
	void exitValue_statement(EZGameParser.Value_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#function_instruction}.
	 * @param ctx the parse tree
	 */
	void enterFunction_instruction(EZGameParser.Function_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#function_instruction}.
	 * @param ctx the parse tree
	 */
	void exitFunction_instruction(EZGameParser.Function_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#unless_instruction}.
	 * @param ctx the parse tree
	 */
	void enterUnless_instruction(EZGameParser.Unless_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#unless_instruction}.
	 * @param ctx the parse tree
	 */
	void exitUnless_instruction(EZGameParser.Unless_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#boolean_statement}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_statement(EZGameParser.Boolean_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#boolean_statement}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_statement(EZGameParser.Boolean_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#boolean_conjuction}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_conjuction(EZGameParser.Boolean_conjuctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#boolean_conjuction}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_conjuction(EZGameParser.Boolean_conjuctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#conjuction_op}.
	 * @param ctx the parse tree
	 */
	void enterConjuction_op(EZGameParser.Conjuction_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#conjuction_op}.
	 * @param ctx the parse tree
	 */
	void exitConjuction_op(EZGameParser.Conjuction_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#boolean_negation}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_negation(EZGameParser.Boolean_negationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#boolean_negation}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_negation(EZGameParser.Boolean_negationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#boolean_clause}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_clause(EZGameParser.Boolean_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#boolean_clause}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_clause(EZGameParser.Boolean_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#comparison_clause}.
	 * @param ctx the parse tree
	 */
	void enterComparison_clause(EZGameParser.Comparison_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#comparison_clause}.
	 * @param ctx the parse tree
	 */
	void exitComparison_clause(EZGameParser.Comparison_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator(EZGameParser.Comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator(EZGameParser.Comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#on_clause}.
	 * @param ctx the parse tree
	 */
	void enterOn_clause(EZGameParser.On_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#on_clause}.
	 * @param ctx the parse tree
	 */
	void exitOn_clause(EZGameParser.On_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#end_definition}.
	 * @param ctx the parse tree
	 */
	void enterEnd_definition(EZGameParser.End_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#end_definition}.
	 * @param ctx the parse tree
	 */
	void exitEnd_definition(EZGameParser.End_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#win_instruction}.
	 * @param ctx the parse tree
	 */
	void enterWin_instruction(EZGameParser.Win_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#win_instruction}.
	 * @param ctx the parse tree
	 */
	void exitWin_instruction(EZGameParser.Win_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#lose_instruction}.
	 * @param ctx the parse tree
	 */
	void enterLose_instruction(EZGameParser.Lose_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#lose_instruction}.
	 * @param ctx the parse tree
	 */
	void exitLose_instruction(EZGameParser.Lose_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#end_statement}.
	 * @param ctx the parse tree
	 */
	void enterEnd_statement(EZGameParser.End_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#end_statement}.
	 * @param ctx the parse tree
	 */
	void exitEnd_statement(EZGameParser.End_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#end_attribute}.
	 * @param ctx the parse tree
	 */
	void enterEnd_attribute(EZGameParser.End_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#end_attribute}.
	 * @param ctx the parse tree
	 */
	void exitEnd_attribute(EZGameParser.End_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#math_expression}.
	 * @param ctx the parse tree
	 */
	void enterMath_expression(EZGameParser.Math_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#math_expression}.
	 * @param ctx the parse tree
	 */
	void exitMath_expression(EZGameParser.Math_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#math_expression_operation}.
	 * @param ctx the parse tree
	 */
	void enterMath_expression_operation(EZGameParser.Math_expression_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#math_expression_operation}.
	 * @param ctx the parse tree
	 */
	void exitMath_expression_operation(EZGameParser.Math_expression_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#math_term}.
	 * @param ctx the parse tree
	 */
	void enterMath_term(EZGameParser.Math_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#math_term}.
	 * @param ctx the parse tree
	 */
	void exitMath_term(EZGameParser.Math_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#math_term_operation}.
	 * @param ctx the parse tree
	 */
	void enterMath_term_operation(EZGameParser.Math_term_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#math_term_operation}.
	 * @param ctx the parse tree
	 */
	void exitMath_term_operation(EZGameParser.Math_term_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZGameParser#math_factor}.
	 * @param ctx the parse tree
	 */
	void enterMath_factor(EZGameParser.Math_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZGameParser#math_factor}.
	 * @param ctx the parse tree
	 */
	void exitMath_factor(EZGameParser.Math_factorContext ctx);
}