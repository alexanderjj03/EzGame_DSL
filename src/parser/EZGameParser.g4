parser grammar EZGameParser;
options { tokenVocab = EZGameLexer; }

// Grammar
program: arena_definition entity_definition behavior_definition end_definition EOF;

arena_definition: ARENA_START size_attribute ;

entity_definition: ENTITIES_START entity_declaration+ ;
entity_declaration: DEFINE entity_type TEXT OPEN_CURLY_BRACE entity_attribute* CLOSE_CURLY_BRACE ;
entity_type: PLAYER_TYPE | ENEMY_TYPE | OBSTABLE_TYPE | COLLECTABLE_TYPE ;

entity_attribute: start_attribute
                | size_attribute
                | health_attribute
                | direction_attribute
                | damage_attribute ;
start_attribute: START EQ coordinate_value SEMI_COLON ;
coordinate_value: coordinate ;
coordinate: NUM COMMA NUM ;
health_attribute: HEALTH EQ NUM SEMI_COLON ;
size_attribute: SIZE EQ NUM SEMI_COLON ;
direction_attribute: DIRECTION EQ direction_type SEMI_COLON ;
direction_type : UP | DOWN | LEFT | RIGHT ;
damage_attribute: DAMAGE EQ NUM SEMI_COLON ;

behavior_definition: BEHAVIOUR_START instruction* ;
instruction: function_definition | entity_instruction ;

variable_definition: VAR TEXT EQ variable_value SEMI_COLON ;
variable_mutation: SET TEXT EQ variable_value SEMI_COLON ;
variable_value: math_expression ;

function_definition: DEFINE FUNCTION_DEC TEXT OPEN_BRACE ( VAR TEXT (COMMA VAR TEXT)*)? CLOSE_BRACE OPEN_CURLY_BRACE function_code* CLOSE_CURLY_BRACE ;
function_code: forever_loop_instruction
             | move_instruction
             | face_instruction
             | wait_instruction
             | variable_mutation
             | unless_instruction
             | variable_definition ;

forever_loop_instruction: FOREVER unless_instruction ;

entity_instruction: ENTITY TEXT OPEN_CURLY_BRACE instruction_code* CLOSE_CURLY_BRACE ;
instruction_code: function_code | function_instruction ;

move_instruction: MOVE move_type SEMI_COLON ;
move_type: math_expression | coordinate_value ;
face_instruction: FACE direction_type SEMI_COLON ;
wait_instruction: WAIT math_expression SEC SEMI_COLON ;
value_statement: (VAR TEXT) | NUM ;
function_instruction: CALL TEXT OPEN_BRACE (math_expression (COMMA math_expression)*)? CLOSE_BRACE SEMI_COLON ;

unless_instruction: UNLESS boolean_statement OPEN_CURLY_BRACE function_code* CLOSE_CURLY_BRACE ;
boolean_statement: OPEN_BRACE (boolean_clause | boolean_conjuction | boolean_negation) CLOSE_BRACE;
boolean_conjuction: boolean_statement conjuction_op boolean_statement ;
conjuction_op: OR | AND ;
boolean_negation: NOT boolean_statement ;
boolean_clause: comparison_clause
              | on_clause ;

comparison_clause: math_expression comparison_operator math_expression ;
comparison_operator: LESS_THAN | GREATER_THAN | LEQ | GEQ | EQUALS ;
on_clause: ON POS coordinate ;

end_definition: END_CRITERIA_START ((win_instruction lose_instruction?) | (lose_instruction win_instruction?));
win_instruction: WIN_START end_statement SEMI_COLON ;
lose_instruction: LOSE_START end_statement SEMI_COLON ;

end_statement: VAR TEXT end_attribute EQUALS NUM;
end_attribute: AMOUNT | HEALTH ;


math_expression: math_term math_expression_operation* ;
math_expression_operation: (ADD | SUB) math_term ;
math_term:       math_factor math_term_operation* ;
math_term_operation: (MUL | DIV) math_factor ;
math_factor:     OPEN_BRACE math_expression CLOSE_BRACE
               | NUM
               | VAR TEXT ;
