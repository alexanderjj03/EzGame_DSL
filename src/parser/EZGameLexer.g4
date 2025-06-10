lexer grammar EZGameLexer;

// (DEFAULT_MODE)

// START DECLARATIONS
ARENA_START        : 'ARENA:' ;
ENTITIES_START     : 'ENTITIES:' ;
BEHAVIOUR_START    : 'BEHAVIOUR:' ;
END_CRITERIA_START : 'END_CRITERIA:' ;

// MATH
ADD                :  '+'  ;
SUB                :  '-'  ;
MUL                :  '*'  ;
DIV                :  '/'  ;

// CONDITIONALS
UNLESS             : 'unless' ;
OR                 : 'or' ;
AND                : 'and' ;
NOT                : 'not' ;
LESS_THAN          : '<' ;
GREATER_THAN       : '>' ;
LEQ                : '<=' ;
GEQ                : '>=' ;
EQUALS             : WS 'equals' WS ;

// ENTITIES
PLAYER_TYPE        :  'player' WS -> mode(TEXT_MODE) ;
ENEMY_TYPE         :  'enemy' WS -> mode(TEXT_MODE) ;
OBSTABLE_TYPE      :  'obstacle' WS -> mode(TEXT_MODE) ;
COLLECTABLE_TYPE   :  'collectable' WS -> mode(TEXT_MODE) ;
START              :  'start'  ;
HEALTH             :  'health' ;
SIZE               :  'size' ;
DAMAGE             :  'damage'  ;
DIRECTION          :  'direction' ;
ENTITY             :  'entity' WS -> mode(TEXT_MODE) ;
AMOUNT             :  'amount' ;

// MUTABLE VARIABLES
VAR                : 'var' WS -> mode(TEXT_MODE) ;
SET                : 'set' WS -> mode(TEXT_MODE) ;
EQ                 : '=' ;

// FUNCTIONS
FUNCTION_DEC       : 'function' WS -> mode(TEXT_MODE) ;
FOREVER            : 'forever' WS ;
MOVE               : 'move' WS ;
FACE               : 'face' WS ;
WAIT               : 'wait' WS ;
SEC                : 'sec' ;
ON                 : 'on' WS ;
POS                : 'pos' WS ;
CALL               : 'call' WS -> mode(TEXT_MODE);

// END CRITERIA
WIN_START          : 'win:' ;
LOSE_START         : 'lose:' ;

// BUILT-IN VALUES
UP                 :  'up' ;
DOWN               :  'down' ;
LEFT               :  'left' ;
RIGHT              :  'right' ;

// GENERAL
DEFINE             :  'define' WS ;
OPEN_BRACE         :  '('  ;
CLOSE_BRACE        :  ')'  ;
OPEN_CURLY_BRACE   :  '{'  ;
CLOSE_CURLY_BRACE  :  '}'  ;
COLON              :  ':'  ;
SEMI_COLON         :  ';'  ;
COMMA              :  ','  ;
NUM                : [0] | [1-9][0-9]*;
WS                 : [ \r\n\t]+ -> skip ;

mode TEXT_MODE ;
TEXT               : [a-zA-Z][a-zA-Z0-9_]* -> mode(DEFAULT_MODE);
TWS                : WS -> skip ;