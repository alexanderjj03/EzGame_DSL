// Generated from /Users/alexanderjacobson/Dropbox/UBC/yr 4/CPSC 410/Group1Project1/src/parser/EZGameParser.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EZGameParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARENA_START=1, ENTITIES_START=2, BEHAVIOUR_START=3, END_CRITERIA_START=4, 
		ADD=5, SUB=6, MUL=7, DIV=8, UNLESS=9, OR=10, AND=11, NOT=12, LESS_THAN=13, 
		GREATER_THAN=14, LEQ=15, GEQ=16, EQUALS=17, PLAYER_TYPE=18, ENEMY_TYPE=19, 
		OBSTABLE_TYPE=20, COLLECTABLE_TYPE=21, START=22, HEALTH=23, SIZE=24, DAMAGE=25, 
		DIRECTION=26, ENTITY=27, AMOUNT=28, VAR=29, SET=30, EQ=31, FUNCTION_DEC=32, 
		FOREVER=33, MOVE=34, FACE=35, WAIT=36, SEC=37, ON=38, POS=39, CALL=40, 
		WIN_START=41, LOSE_START=42, UP=43, DOWN=44, LEFT=45, RIGHT=46, DEFINE=47, 
		OPEN_BRACE=48, CLOSE_BRACE=49, OPEN_CURLY_BRACE=50, CLOSE_CURLY_BRACE=51, 
		COLON=52, SEMI_COLON=53, COMMA=54, NUM=55, WS=56, TEXT=57, TWS=58;
	public static final int
		RULE_program = 0, RULE_arena_definition = 1, RULE_entity_definition = 2, 
		RULE_entity_declaration = 3, RULE_entity_type = 4, RULE_entity_attribute = 5, 
		RULE_start_attribute = 6, RULE_coordinate_value = 7, RULE_coordinate = 8, 
		RULE_health_attribute = 9, RULE_size_attribute = 10, RULE_direction_attribute = 11, 
		RULE_direction_type = 12, RULE_damage_attribute = 13, RULE_behavior_definition = 14, 
		RULE_instruction = 15, RULE_variable_definition = 16, RULE_variable_mutation = 17, 
		RULE_variable_value = 18, RULE_function_definition = 19, RULE_function_code = 20, 
		RULE_forever_loop_instruction = 21, RULE_entity_instruction = 22, RULE_instruction_code = 23, 
		RULE_move_instruction = 24, RULE_move_type = 25, RULE_face_instruction = 26, 
		RULE_wait_instruction = 27, RULE_value_statement = 28, RULE_function_instruction = 29, 
		RULE_unless_instruction = 30, RULE_boolean_statement = 31, RULE_boolean_conjuction = 32, 
		RULE_conjuction_op = 33, RULE_boolean_negation = 34, RULE_boolean_clause = 35, 
		RULE_comparison_clause = 36, RULE_comparison_operator = 37, RULE_on_clause = 38, 
		RULE_end_definition = 39, RULE_win_instruction = 40, RULE_lose_instruction = 41, 
		RULE_end_statement = 42, RULE_end_attribute = 43, RULE_math_expression = 44, 
		RULE_math_expression_operation = 45, RULE_math_term = 46, RULE_math_term_operation = 47, 
		RULE_math_factor = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "arena_definition", "entity_definition", "entity_declaration", 
			"entity_type", "entity_attribute", "start_attribute", "coordinate_value", 
			"coordinate", "health_attribute", "size_attribute", "direction_attribute", 
			"direction_type", "damage_attribute", "behavior_definition", "instruction", 
			"variable_definition", "variable_mutation", "variable_value", "function_definition", 
			"function_code", "forever_loop_instruction", "entity_instruction", "instruction_code", 
			"move_instruction", "move_type", "face_instruction", "wait_instruction", 
			"value_statement", "function_instruction", "unless_instruction", "boolean_statement", 
			"boolean_conjuction", "conjuction_op", "boolean_negation", "boolean_clause", 
			"comparison_clause", "comparison_operator", "on_clause", "end_definition", 
			"win_instruction", "lose_instruction", "end_statement", "end_attribute", 
			"math_expression", "math_expression_operation", "math_term", "math_term_operation", 
			"math_factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ARENA:'", "'ENTITIES:'", "'BEHAVIOUR:'", "'END_CRITERIA:'", "'+'", 
			"'-'", "'*'", "'/'", "'unless'", "'or'", "'and'", "'not'", "'<'", "'>'", 
			"'<='", "'>='", null, null, null, null, null, "'start'", "'health'", 
			"'size'", "'damage'", "'direction'", null, "'amount'", null, null, "'='", 
			null, null, null, null, null, "'sec'", null, null, null, "'win:'", "'lose:'", 
			"'up'", "'down'", "'left'", "'right'", null, "'('", "')'", "'{'", "'}'", 
			"':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ARENA_START", "ENTITIES_START", "BEHAVIOUR_START", "END_CRITERIA_START", 
			"ADD", "SUB", "MUL", "DIV", "UNLESS", "OR", "AND", "NOT", "LESS_THAN", 
			"GREATER_THAN", "LEQ", "GEQ", "EQUALS", "PLAYER_TYPE", "ENEMY_TYPE", 
			"OBSTABLE_TYPE", "COLLECTABLE_TYPE", "START", "HEALTH", "SIZE", "DAMAGE", 
			"DIRECTION", "ENTITY", "AMOUNT", "VAR", "SET", "EQ", "FUNCTION_DEC", 
			"FOREVER", "MOVE", "FACE", "WAIT", "SEC", "ON", "POS", "CALL", "WIN_START", 
			"LOSE_START", "UP", "DOWN", "LEFT", "RIGHT", "DEFINE", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_CURLY_BRACE", "CLOSE_CURLY_BRACE", "COLON", "SEMI_COLON", 
			"COMMA", "NUM", "WS", "TEXT", "TWS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EZGameParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EZGameParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Arena_definitionContext arena_definition() {
			return getRuleContext(Arena_definitionContext.class,0);
		}
		public Entity_definitionContext entity_definition() {
			return getRuleContext(Entity_definitionContext.class,0);
		}
		public Behavior_definitionContext behavior_definition() {
			return getRuleContext(Behavior_definitionContext.class,0);
		}
		public End_definitionContext end_definition() {
			return getRuleContext(End_definitionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(EZGameParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			arena_definition();
			setState(99);
			entity_definition();
			setState(100);
			behavior_definition();
			setState(101);
			end_definition();
			setState(102);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arena_definitionContext extends ParserRuleContext {
		public TerminalNode ARENA_START() { return getToken(EZGameParser.ARENA_START, 0); }
		public Size_attributeContext size_attribute() {
			return getRuleContext(Size_attributeContext.class,0);
		}
		public Arena_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arena_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterArena_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitArena_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitArena_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arena_definitionContext arena_definition() throws RecognitionException {
		Arena_definitionContext _localctx = new Arena_definitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_arena_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ARENA_START);
			setState(105);
			size_attribute();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entity_definitionContext extends ParserRuleContext {
		public TerminalNode ENTITIES_START() { return getToken(EZGameParser.ENTITIES_START, 0); }
		public List<Entity_declarationContext> entity_declaration() {
			return getRuleContexts(Entity_declarationContext.class);
		}
		public Entity_declarationContext entity_declaration(int i) {
			return getRuleContext(Entity_declarationContext.class,i);
		}
		public Entity_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEntity_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEntity_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEntity_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_definitionContext entity_definition() throws RecognitionException {
		Entity_definitionContext _localctx = new Entity_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_entity_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ENTITIES_START);
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				entity_declaration();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entity_declarationContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(EZGameParser.DEFINE, 0); }
		public Entity_typeContext entity_type() {
			return getRuleContext(Entity_typeContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(EZGameParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(EZGameParser.CLOSE_CURLY_BRACE, 0); }
		public List<Entity_attributeContext> entity_attribute() {
			return getRuleContexts(Entity_attributeContext.class);
		}
		public Entity_attributeContext entity_attribute(int i) {
			return getRuleContext(Entity_attributeContext.class,i);
		}
		public Entity_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEntity_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEntity_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEntity_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_declarationContext entity_declaration() throws RecognitionException {
		Entity_declarationContext _localctx = new Entity_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_entity_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(DEFINE);
			setState(114);
			entity_type();
			setState(115);
			match(TEXT);
			setState(116);
			match(OPEN_CURLY_BRACE);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130023424L) != 0)) {
				{
				{
				setState(117);
				entity_attribute();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entity_typeContext extends ParserRuleContext {
		public TerminalNode PLAYER_TYPE() { return getToken(EZGameParser.PLAYER_TYPE, 0); }
		public TerminalNode ENEMY_TYPE() { return getToken(EZGameParser.ENEMY_TYPE, 0); }
		public TerminalNode OBSTABLE_TYPE() { return getToken(EZGameParser.OBSTABLE_TYPE, 0); }
		public TerminalNode COLLECTABLE_TYPE() { return getToken(EZGameParser.COLLECTABLE_TYPE, 0); }
		public Entity_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEntity_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEntity_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEntity_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_typeContext entity_type() throws RecognitionException {
		Entity_typeContext _localctx = new Entity_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entity_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entity_attributeContext extends ParserRuleContext {
		public Start_attributeContext start_attribute() {
			return getRuleContext(Start_attributeContext.class,0);
		}
		public Size_attributeContext size_attribute() {
			return getRuleContext(Size_attributeContext.class,0);
		}
		public Health_attributeContext health_attribute() {
			return getRuleContext(Health_attributeContext.class,0);
		}
		public Direction_attributeContext direction_attribute() {
			return getRuleContext(Direction_attributeContext.class,0);
		}
		public Damage_attributeContext damage_attribute() {
			return getRuleContext(Damage_attributeContext.class,0);
		}
		public Entity_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEntity_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEntity_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEntity_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_attributeContext entity_attribute() throws RecognitionException {
		Entity_attributeContext _localctx = new Entity_attributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_entity_attribute);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				start_attribute();
				}
				break;
			case SIZE:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				size_attribute();
				}
				break;
			case HEALTH:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				health_attribute();
				}
				break;
			case DIRECTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				direction_attribute();
				}
				break;
			case DAMAGE:
				enterOuterAlt(_localctx, 5);
				{
				setState(131);
				damage_attribute();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Start_attributeContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(EZGameParser.START, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public Coordinate_valueContext coordinate_value() {
			return getRuleContext(Coordinate_valueContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Start_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterStart_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitStart_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitStart_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_attributeContext start_attribute() throws RecognitionException {
		Start_attributeContext _localctx = new Start_attributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_start_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(START);
			setState(135);
			match(EQ);
			setState(136);
			coordinate_value();
			setState(137);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Coordinate_valueContext extends ParserRuleContext {
		public CoordinateContext coordinate() {
			return getRuleContext(CoordinateContext.class,0);
		}
		public Coordinate_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinate_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterCoordinate_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitCoordinate_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitCoordinate_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Coordinate_valueContext coordinate_value() throws RecognitionException {
		Coordinate_valueContext _localctx = new Coordinate_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_coordinate_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			coordinate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoordinateContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(EZGameParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(EZGameParser.NUM, i);
		}
		public TerminalNode COMMA() { return getToken(EZGameParser.COMMA, 0); }
		public CoordinateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterCoordinate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitCoordinate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitCoordinate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordinateContext coordinate() throws RecognitionException {
		CoordinateContext _localctx = new CoordinateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_coordinate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(NUM);
			setState(142);
			match(COMMA);
			setState(143);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Health_attributeContext extends ParserRuleContext {
		public TerminalNode HEALTH() { return getToken(EZGameParser.HEALTH, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public TerminalNode NUM() { return getToken(EZGameParser.NUM, 0); }
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Health_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_health_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterHealth_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitHealth_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitHealth_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Health_attributeContext health_attribute() throws RecognitionException {
		Health_attributeContext _localctx = new Health_attributeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_health_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(HEALTH);
			setState(146);
			match(EQ);
			setState(147);
			match(NUM);
			setState(148);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Size_attributeContext extends ParserRuleContext {
		public TerminalNode SIZE() { return getToken(EZGameParser.SIZE, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public TerminalNode NUM() { return getToken(EZGameParser.NUM, 0); }
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Size_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterSize_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitSize_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitSize_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Size_attributeContext size_attribute() throws RecognitionException {
		Size_attributeContext _localctx = new Size_attributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_size_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(SIZE);
			setState(151);
			match(EQ);
			setState(152);
			match(NUM);
			setState(153);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Direction_attributeContext extends ParserRuleContext {
		public TerminalNode DIRECTION() { return getToken(EZGameParser.DIRECTION, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public Direction_typeContext direction_type() {
			return getRuleContext(Direction_typeContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Direction_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterDirection_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitDirection_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitDirection_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Direction_attributeContext direction_attribute() throws RecognitionException {
		Direction_attributeContext _localctx = new Direction_attributeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_direction_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(DIRECTION);
			setState(156);
			match(EQ);
			setState(157);
			direction_type();
			setState(158);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Direction_typeContext extends ParserRuleContext {
		public TerminalNode UP() { return getToken(EZGameParser.UP, 0); }
		public TerminalNode DOWN() { return getToken(EZGameParser.DOWN, 0); }
		public TerminalNode LEFT() { return getToken(EZGameParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(EZGameParser.RIGHT, 0); }
		public Direction_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterDirection_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitDirection_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitDirection_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Direction_typeContext direction_type() throws RecognitionException {
		Direction_typeContext _localctx = new Direction_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_direction_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131941395333120L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Damage_attributeContext extends ParserRuleContext {
		public TerminalNode DAMAGE() { return getToken(EZGameParser.DAMAGE, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public TerminalNode NUM() { return getToken(EZGameParser.NUM, 0); }
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Damage_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_damage_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterDamage_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitDamage_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitDamage_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Damage_attributeContext damage_attribute() throws RecognitionException {
		Damage_attributeContext _localctx = new Damage_attributeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_damage_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(DAMAGE);
			setState(163);
			match(EQ);
			setState(164);
			match(NUM);
			setState(165);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Behavior_definitionContext extends ParserRuleContext {
		public TerminalNode BEHAVIOUR_START() { return getToken(EZGameParser.BEHAVIOUR_START, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Behavior_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behavior_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterBehavior_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitBehavior_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitBehavior_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Behavior_definitionContext behavior_definition() throws RecognitionException {
		Behavior_definitionContext _localctx = new Behavior_definitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_behavior_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(BEHAVIOUR_START);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ENTITY || _la==DEFINE) {
				{
				{
				setState(168);
				instruction();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public Entity_instructionContext entity_instruction() {
			return getRuleContext(Entity_instructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instruction);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				function_definition();
				}
				break;
			case ENTITY:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				entity_instruction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_definitionContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(EZGameParser.VAR, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public Variable_valueContext variable_value() {
			return getRuleContext(Variable_valueContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterVariable_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitVariable_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitVariable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variable_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(VAR);
			setState(179);
			match(TEXT);
			setState(180);
			match(EQ);
			setState(181);
			variable_value();
			setState(182);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_mutationContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(EZGameParser.SET, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public TerminalNode EQ() { return getToken(EZGameParser.EQ, 0); }
		public Variable_valueContext variable_value() {
			return getRuleContext(Variable_valueContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Variable_mutationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_mutation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterVariable_mutation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitVariable_mutation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitVariable_mutation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_mutationContext variable_mutation() throws RecognitionException {
		Variable_mutationContext _localctx = new Variable_mutationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variable_mutation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(SET);
			setState(185);
			match(TEXT);
			setState(186);
			match(EQ);
			setState(187);
			variable_value();
			setState(188);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_valueContext extends ParserRuleContext {
		public Math_expressionContext math_expression() {
			return getRuleContext(Math_expressionContext.class,0);
		}
		public Variable_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterVariable_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitVariable_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitVariable_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_valueContext variable_value() throws RecognitionException {
		Variable_valueContext _localctx = new Variable_valueContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variable_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			math_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(EZGameParser.DEFINE, 0); }
		public TerminalNode FUNCTION_DEC() { return getToken(EZGameParser.FUNCTION_DEC, 0); }
		public List<TerminalNode> TEXT() { return getTokens(EZGameParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(EZGameParser.TEXT, i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(EZGameParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(EZGameParser.CLOSE_BRACE, 0); }
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(EZGameParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(EZGameParser.CLOSE_CURLY_BRACE, 0); }
		public List<TerminalNode> VAR() { return getTokens(EZGameParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(EZGameParser.VAR, i);
		}
		public List<Function_codeContext> function_code() {
			return getRuleContexts(Function_codeContext.class);
		}
		public Function_codeContext function_code(int i) {
			return getRuleContext(Function_codeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EZGameParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EZGameParser.COMMA, i);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitFunction_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(DEFINE);
			setState(193);
			match(FUNCTION_DEC);
			setState(194);
			match(TEXT);
			setState(195);
			match(OPEN_BRACE);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(196);
				match(VAR);
				setState(197);
				match(TEXT);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(199);
					match(VAR);
					setState(200);
					match(TEXT);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(208);
			match(CLOSE_BRACE);
			setState(209);
			match(OPEN_CURLY_BRACE);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130459632128L) != 0)) {
				{
				{
				setState(210);
				function_code();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_codeContext extends ParserRuleContext {
		public Forever_loop_instructionContext forever_loop_instruction() {
			return getRuleContext(Forever_loop_instructionContext.class,0);
		}
		public Move_instructionContext move_instruction() {
			return getRuleContext(Move_instructionContext.class,0);
		}
		public Face_instructionContext face_instruction() {
			return getRuleContext(Face_instructionContext.class,0);
		}
		public Wait_instructionContext wait_instruction() {
			return getRuleContext(Wait_instructionContext.class,0);
		}
		public Variable_mutationContext variable_mutation() {
			return getRuleContext(Variable_mutationContext.class,0);
		}
		public Unless_instructionContext unless_instruction() {
			return getRuleContext(Unless_instructionContext.class,0);
		}
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public Function_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterFunction_code(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitFunction_code(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitFunction_code(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_codeContext function_code() throws RecognitionException {
		Function_codeContext _localctx = new Function_codeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_function_code);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOREVER:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				forever_loop_instruction();
				}
				break;
			case MOVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				move_instruction();
				}
				break;
			case FACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				face_instruction();
				}
				break;
			case WAIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				wait_instruction();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				variable_mutation();
				}
				break;
			case UNLESS:
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				unless_instruction();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				variable_definition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Forever_loop_instructionContext extends ParserRuleContext {
		public TerminalNode FOREVER() { return getToken(EZGameParser.FOREVER, 0); }
		public Unless_instructionContext unless_instruction() {
			return getRuleContext(Unless_instructionContext.class,0);
		}
		public Forever_loop_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forever_loop_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterForever_loop_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitForever_loop_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitForever_loop_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Forever_loop_instructionContext forever_loop_instruction() throws RecognitionException {
		Forever_loop_instructionContext _localctx = new Forever_loop_instructionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forever_loop_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(FOREVER);
			setState(228);
			unless_instruction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entity_instructionContext extends ParserRuleContext {
		public TerminalNode ENTITY() { return getToken(EZGameParser.ENTITY, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(EZGameParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(EZGameParser.CLOSE_CURLY_BRACE, 0); }
		public List<Instruction_codeContext> instruction_code() {
			return getRuleContexts(Instruction_codeContext.class);
		}
		public Instruction_codeContext instruction_code(int i) {
			return getRuleContext(Instruction_codeContext.class,i);
		}
		public Entity_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEntity_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEntity_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEntity_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_instructionContext entity_instruction() throws RecognitionException {
		Entity_instructionContext _localctx = new Entity_instructionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_entity_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ENTITY);
			setState(231);
			match(TEXT);
			setState(232);
			match(OPEN_CURLY_BRACE);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1229971259904L) != 0)) {
				{
				{
				setState(233);
				instruction_code();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Instruction_codeContext extends ParserRuleContext {
		public Function_codeContext function_code() {
			return getRuleContext(Function_codeContext.class,0);
		}
		public Function_instructionContext function_instruction() {
			return getRuleContext(Function_instructionContext.class,0);
		}
		public Instruction_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterInstruction_code(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitInstruction_code(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitInstruction_code(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instruction_codeContext instruction_code() throws RecognitionException {
		Instruction_codeContext _localctx = new Instruction_codeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_instruction_code);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNLESS:
			case VAR:
			case SET:
			case FOREVER:
			case MOVE:
			case FACE:
			case WAIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				function_code();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				function_instruction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Move_instructionContext extends ParserRuleContext {
		public TerminalNode MOVE() { return getToken(EZGameParser.MOVE, 0); }
		public Move_typeContext move_type() {
			return getRuleContext(Move_typeContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Move_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMove_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMove_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMove_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Move_instructionContext move_instruction() throws RecognitionException {
		Move_instructionContext _localctx = new Move_instructionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_move_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(MOVE);
			setState(246);
			move_type();
			setState(247);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Move_typeContext extends ParserRuleContext {
		public Math_expressionContext math_expression() {
			return getRuleContext(Math_expressionContext.class,0);
		}
		public Coordinate_valueContext coordinate_value() {
			return getRuleContext(Coordinate_valueContext.class,0);
		}
		public Move_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMove_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMove_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMove_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Move_typeContext move_type() throws RecognitionException {
		Move_typeContext _localctx = new Move_typeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_move_type);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				math_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				coordinate_value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Face_instructionContext extends ParserRuleContext {
		public TerminalNode FACE() { return getToken(EZGameParser.FACE, 0); }
		public Direction_typeContext direction_type() {
			return getRuleContext(Direction_typeContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Face_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_face_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterFace_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitFace_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitFace_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Face_instructionContext face_instruction() throws RecognitionException {
		Face_instructionContext _localctx = new Face_instructionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_face_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(FACE);
			setState(254);
			direction_type();
			setState(255);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Wait_instructionContext extends ParserRuleContext {
		public TerminalNode WAIT() { return getToken(EZGameParser.WAIT, 0); }
		public Math_expressionContext math_expression() {
			return getRuleContext(Math_expressionContext.class,0);
		}
		public TerminalNode SEC() { return getToken(EZGameParser.SEC, 0); }
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Wait_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wait_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterWait_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitWait_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitWait_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wait_instructionContext wait_instruction() throws RecognitionException {
		Wait_instructionContext _localctx = new Wait_instructionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_wait_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(WAIT);
			setState(258);
			math_expression();
			setState(259);
			match(SEC);
			setState(260);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_statementContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(EZGameParser.VAR, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public TerminalNode NUM() { return getToken(EZGameParser.NUM, 0); }
		public Value_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterValue_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitValue_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitValue_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_statementContext value_statement() throws RecognitionException {
		Value_statementContext _localctx = new Value_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_value_statement);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(262);
				match(VAR);
				setState(263);
				match(TEXT);
				}
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_instructionContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(EZGameParser.CALL, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(EZGameParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(EZGameParser.CLOSE_BRACE, 0); }
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public List<Math_expressionContext> math_expression() {
			return getRuleContexts(Math_expressionContext.class);
		}
		public Math_expressionContext math_expression(int i) {
			return getRuleContext(Math_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EZGameParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EZGameParser.COMMA, i);
		}
		public Function_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterFunction_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitFunction_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitFunction_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_instructionContext function_instruction() throws RecognitionException {
		Function_instructionContext _localctx = new Function_instructionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_function_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(CALL);
			setState(268);
			match(TEXT);
			setState(269);
			match(OPEN_BRACE);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 36310272532545536L) != 0)) {
				{
				setState(270);
				math_expression();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(271);
					match(COMMA);
					setState(272);
					math_expression();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(280);
			match(CLOSE_BRACE);
			setState(281);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unless_instructionContext extends ParserRuleContext {
		public TerminalNode UNLESS() { return getToken(EZGameParser.UNLESS, 0); }
		public Boolean_statementContext boolean_statement() {
			return getRuleContext(Boolean_statementContext.class,0);
		}
		public TerminalNode OPEN_CURLY_BRACE() { return getToken(EZGameParser.OPEN_CURLY_BRACE, 0); }
		public TerminalNode CLOSE_CURLY_BRACE() { return getToken(EZGameParser.CLOSE_CURLY_BRACE, 0); }
		public List<Function_codeContext> function_code() {
			return getRuleContexts(Function_codeContext.class);
		}
		public Function_codeContext function_code(int i) {
			return getRuleContext(Function_codeContext.class,i);
		}
		public Unless_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unless_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterUnless_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitUnless_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitUnless_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unless_instructionContext unless_instruction() throws RecognitionException {
		Unless_instructionContext _localctx = new Unless_instructionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_unless_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(UNLESS);
			setState(284);
			boolean_statement();
			setState(285);
			match(OPEN_CURLY_BRACE);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130459632128L) != 0)) {
				{
				{
				setState(286);
				function_code();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(292);
			match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_statementContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(EZGameParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(EZGameParser.CLOSE_BRACE, 0); }
		public Boolean_clauseContext boolean_clause() {
			return getRuleContext(Boolean_clauseContext.class,0);
		}
		public Boolean_conjuctionContext boolean_conjuction() {
			return getRuleContext(Boolean_conjuctionContext.class,0);
		}
		public Boolean_negationContext boolean_negation() {
			return getRuleContext(Boolean_negationContext.class,0);
		}
		public Boolean_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterBoolean_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitBoolean_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitBoolean_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_statementContext boolean_statement() throws RecognitionException {
		Boolean_statementContext _localctx = new Boolean_statementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_boolean_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(OPEN_BRACE);
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(295);
				boolean_clause();
				}
				break;
			case 2:
				{
				setState(296);
				boolean_conjuction();
				}
				break;
			case 3:
				{
				setState(297);
				boolean_negation();
				}
				break;
			}
			setState(300);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_conjuctionContext extends ParserRuleContext {
		public List<Boolean_statementContext> boolean_statement() {
			return getRuleContexts(Boolean_statementContext.class);
		}
		public Boolean_statementContext boolean_statement(int i) {
			return getRuleContext(Boolean_statementContext.class,i);
		}
		public Conjuction_opContext conjuction_op() {
			return getRuleContext(Conjuction_opContext.class,0);
		}
		public Boolean_conjuctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_conjuction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterBoolean_conjuction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitBoolean_conjuction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitBoolean_conjuction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_conjuctionContext boolean_conjuction() throws RecognitionException {
		Boolean_conjuctionContext _localctx = new Boolean_conjuctionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_boolean_conjuction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			boolean_statement();
			setState(303);
			conjuction_op();
			setState(304);
			boolean_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Conjuction_opContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(EZGameParser.OR, 0); }
		public TerminalNode AND() { return getToken(EZGameParser.AND, 0); }
		public Conjuction_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjuction_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterConjuction_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitConjuction_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitConjuction_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conjuction_opContext conjuction_op() throws RecognitionException {
		Conjuction_opContext _localctx = new Conjuction_opContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_conjuction_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==AND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_negationContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(EZGameParser.NOT, 0); }
		public Boolean_statementContext boolean_statement() {
			return getRuleContext(Boolean_statementContext.class,0);
		}
		public Boolean_negationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterBoolean_negation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitBoolean_negation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitBoolean_negation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_negationContext boolean_negation() throws RecognitionException {
		Boolean_negationContext _localctx = new Boolean_negationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_boolean_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(NOT);
			setState(309);
			boolean_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_clauseContext extends ParserRuleContext {
		public Comparison_clauseContext comparison_clause() {
			return getRuleContext(Comparison_clauseContext.class,0);
		}
		public On_clauseContext on_clause() {
			return getRuleContext(On_clauseContext.class,0);
		}
		public Boolean_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterBoolean_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitBoolean_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitBoolean_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_clauseContext boolean_clause() throws RecognitionException {
		Boolean_clauseContext _localctx = new Boolean_clauseContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_boolean_clause);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case OPEN_BRACE:
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				comparison_clause();
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				on_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comparison_clauseContext extends ParserRuleContext {
		public List<Math_expressionContext> math_expression() {
			return getRuleContexts(Math_expressionContext.class);
		}
		public Math_expressionContext math_expression(int i) {
			return getRuleContext(Math_expressionContext.class,i);
		}
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public Comparison_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterComparison_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitComparison_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitComparison_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_clauseContext comparison_clause() throws RecognitionException {
		Comparison_clauseContext _localctx = new Comparison_clauseContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_comparison_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			math_expression();
			setState(316);
			comparison_operator();
			setState(317);
			math_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comparison_operatorContext extends ParserRuleContext {
		public TerminalNode LESS_THAN() { return getToken(EZGameParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(EZGameParser.GREATER_THAN, 0); }
		public TerminalNode LEQ() { return getToken(EZGameParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(EZGameParser.GEQ, 0); }
		public TerminalNode EQUALS() { return getToken(EZGameParser.EQUALS, 0); }
		public Comparison_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterComparison_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitComparison_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitComparison_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_operatorContext comparison_operator() throws RecognitionException {
		Comparison_operatorContext _localctx = new Comparison_operatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_comparison_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 253952L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class On_clauseContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(EZGameParser.ON, 0); }
		public TerminalNode POS() { return getToken(EZGameParser.POS, 0); }
		public CoordinateContext coordinate() {
			return getRuleContext(CoordinateContext.class,0);
		}
		public On_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterOn_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitOn_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitOn_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final On_clauseContext on_clause() throws RecognitionException {
		On_clauseContext _localctx = new On_clauseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_on_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(ON);
			setState(322);
			match(POS);
			setState(323);
			coordinate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class End_definitionContext extends ParserRuleContext {
		public TerminalNode END_CRITERIA_START() { return getToken(EZGameParser.END_CRITERIA_START, 0); }
		public Win_instructionContext win_instruction() {
			return getRuleContext(Win_instructionContext.class,0);
		}
		public Lose_instructionContext lose_instruction() {
			return getRuleContext(Lose_instructionContext.class,0);
		}
		public End_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEnd_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEnd_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEnd_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_definitionContext end_definition() throws RecognitionException {
		End_definitionContext _localctx = new End_definitionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_end_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(END_CRITERIA_START);
			setState(334);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WIN_START:
				{
				{
				setState(326);
				win_instruction();
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOSE_START) {
					{
					setState(327);
					lose_instruction();
					}
				}

				}
				}
				break;
			case LOSE_START:
				{
				{
				setState(330);
				lose_instruction();
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WIN_START) {
					{
					setState(331);
					win_instruction();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Win_instructionContext extends ParserRuleContext {
		public TerminalNode WIN_START() { return getToken(EZGameParser.WIN_START, 0); }
		public End_statementContext end_statement() {
			return getRuleContext(End_statementContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Win_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_win_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterWin_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitWin_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitWin_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Win_instructionContext win_instruction() throws RecognitionException {
		Win_instructionContext _localctx = new Win_instructionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_win_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(WIN_START);
			setState(337);
			end_statement();
			setState(338);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lose_instructionContext extends ParserRuleContext {
		public TerminalNode LOSE_START() { return getToken(EZGameParser.LOSE_START, 0); }
		public End_statementContext end_statement() {
			return getRuleContext(End_statementContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(EZGameParser.SEMI_COLON, 0); }
		public Lose_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lose_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterLose_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitLose_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitLose_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lose_instructionContext lose_instruction() throws RecognitionException {
		Lose_instructionContext _localctx = new Lose_instructionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_lose_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(LOSE_START);
			setState(341);
			end_statement();
			setState(342);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class End_statementContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(EZGameParser.VAR, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public End_attributeContext end_attribute() {
			return getRuleContext(End_attributeContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(EZGameParser.EQUALS, 0); }
		public TerminalNode NUM() { return getToken(EZGameParser.NUM, 0); }
		public End_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEnd_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEnd_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEnd_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_statementContext end_statement() throws RecognitionException {
		End_statementContext _localctx = new End_statementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_end_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(VAR);
			setState(345);
			match(TEXT);
			setState(346);
			end_attribute();
			setState(347);
			match(EQUALS);
			setState(348);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class End_attributeContext extends ParserRuleContext {
		public TerminalNode AMOUNT() { return getToken(EZGameParser.AMOUNT, 0); }
		public TerminalNode HEALTH() { return getToken(EZGameParser.HEALTH, 0); }
		public End_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterEnd_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitEnd_attribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitEnd_attribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_attributeContext end_attribute() throws RecognitionException {
		End_attributeContext _localctx = new End_attributeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_end_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_la = _input.LA(1);
			if ( !(_la==HEALTH || _la==AMOUNT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Math_expressionContext extends ParserRuleContext {
		public Math_termContext math_term() {
			return getRuleContext(Math_termContext.class,0);
		}
		public List<Math_expression_operationContext> math_expression_operation() {
			return getRuleContexts(Math_expression_operationContext.class);
		}
		public Math_expression_operationContext math_expression_operation(int i) {
			return getRuleContext(Math_expression_operationContext.class,i);
		}
		public Math_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMath_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMath_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMath_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_expressionContext math_expression() throws RecognitionException {
		Math_expressionContext _localctx = new Math_expressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_math_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			math_term();
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(353);
				math_expression_operation();
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Math_expression_operationContext extends ParserRuleContext {
		public Math_termContext math_term() {
			return getRuleContext(Math_termContext.class,0);
		}
		public TerminalNode ADD() { return getToken(EZGameParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(EZGameParser.SUB, 0); }
		public Math_expression_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_expression_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMath_expression_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMath_expression_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMath_expression_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_expression_operationContext math_expression_operation() throws RecognitionException {
		Math_expression_operationContext _localctx = new Math_expression_operationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_math_expression_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(360);
			math_term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Math_termContext extends ParserRuleContext {
		public Math_factorContext math_factor() {
			return getRuleContext(Math_factorContext.class,0);
		}
		public List<Math_term_operationContext> math_term_operation() {
			return getRuleContexts(Math_term_operationContext.class);
		}
		public Math_term_operationContext math_term_operation(int i) {
			return getRuleContext(Math_term_operationContext.class,i);
		}
		public Math_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMath_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMath_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMath_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_termContext math_term() throws RecognitionException {
		Math_termContext _localctx = new Math_termContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_math_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			math_factor();
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(363);
				math_term_operation();
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Math_term_operationContext extends ParserRuleContext {
		public Math_factorContext math_factor() {
			return getRuleContext(Math_factorContext.class,0);
		}
		public TerminalNode MUL() { return getToken(EZGameParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(EZGameParser.DIV, 0); }
		public Math_term_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_term_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMath_term_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMath_term_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMath_term_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_term_operationContext math_term_operation() throws RecognitionException {
		Math_term_operationContext _localctx = new Math_term_operationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_math_term_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(370);
			math_factor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Math_factorContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(EZGameParser.OPEN_BRACE, 0); }
		public Math_expressionContext math_expression() {
			return getRuleContext(Math_expressionContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(EZGameParser.CLOSE_BRACE, 0); }
		public TerminalNode NUM() { return getToken(EZGameParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(EZGameParser.VAR, 0); }
		public TerminalNode TEXT() { return getToken(EZGameParser.TEXT, 0); }
		public Math_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).enterMath_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZGameParserListener ) ((EZGameParserListener)listener).exitMath_factor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EZGameParserVisitor ) return ((EZGameParserVisitor<? extends T>)visitor).visitMath_factor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_factorContext math_factor() throws RecognitionException {
		Math_factorContext _localctx = new Math_factorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_math_factor);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				match(OPEN_BRACE);
				setState(373);
				math_expression();
				setState(374);
				match(CLOSE_BRACE);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				match(NUM);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
				match(VAR);
				setState(378);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001:\u017e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0004\u0002n\b\u0002\u000b\u0002"+
		"\f\u0002o\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003w\b\u0003\n\u0003\f\u0003z\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0085\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00aa\b\u000e\n\u000e\f\u000e\u00ad\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00b1\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00ca\b\u0013\n\u0013\f\u0013"+
		"\u00cd\t\u0013\u0003\u0013\u00cf\b\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00d4\b\u0013\n\u0013\f\u0013\u00d7\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u00e2\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u00eb\b\u0016\n\u0016\f\u0016\u00ee\t\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u00f4\b\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u00fc\b\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u010a\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u0112\b\u001d\n\u001d\f\u001d\u0115\t\u001d"+
		"\u0003\u001d\u0117\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0120\b\u001e\n\u001e"+
		"\f\u001e\u0123\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u012b\b\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0003#\u013a\b#\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0003\'\u0149\b\'\u0001"+
		"\'\u0001\'\u0003\'\u014d\b\'\u0003\'\u014f\b\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001+\u0001+\u0001,\u0001,\u0005,\u0163\b,\n,\f,\u0166\t,\u0001-\u0001"+
		"-\u0001-\u0001.\u0001.\u0005.\u016d\b.\n.\f.\u0170\t.\u0001/\u0001/\u0001"+
		"/\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00030\u017c\b0\u0001"+
		"0\u0000\u00001\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`\u0000\u0007"+
		"\u0001\u0000\u0012\u0015\u0001\u0000+.\u0001\u0000\n\u000b\u0001\u0000"+
		"\r\u0011\u0002\u0000\u0017\u0017\u001c\u001c\u0001\u0000\u0005\u0006\u0001"+
		"\u0000\u0007\b\u016e\u0000b\u0001\u0000\u0000\u0000\u0002h\u0001\u0000"+
		"\u0000\u0000\u0004k\u0001\u0000\u0000\u0000\u0006q\u0001\u0000\u0000\u0000"+
		"\b}\u0001\u0000\u0000\u0000\n\u0084\u0001\u0000\u0000\u0000\f\u0086\u0001"+
		"\u0000\u0000\u0000\u000e\u008b\u0001\u0000\u0000\u0000\u0010\u008d\u0001"+
		"\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000\u0000\u0014\u0096\u0001"+
		"\u0000\u0000\u0000\u0016\u009b\u0001\u0000\u0000\u0000\u0018\u00a0\u0001"+
		"\u0000\u0000\u0000\u001a\u00a2\u0001\u0000\u0000\u0000\u001c\u00a7\u0001"+
		"\u0000\u0000\u0000\u001e\u00b0\u0001\u0000\u0000\u0000 \u00b2\u0001\u0000"+
		"\u0000\u0000\"\u00b8\u0001\u0000\u0000\u0000$\u00be\u0001\u0000\u0000"+
		"\u0000&\u00c0\u0001\u0000\u0000\u0000(\u00e1\u0001\u0000\u0000\u0000*"+
		"\u00e3\u0001\u0000\u0000\u0000,\u00e6\u0001\u0000\u0000\u0000.\u00f3\u0001"+
		"\u0000\u0000\u00000\u00f5\u0001\u0000\u0000\u00002\u00fb\u0001\u0000\u0000"+
		"\u00004\u00fd\u0001\u0000\u0000\u00006\u0101\u0001\u0000\u0000\u00008"+
		"\u0109\u0001\u0000\u0000\u0000:\u010b\u0001\u0000\u0000\u0000<\u011b\u0001"+
		"\u0000\u0000\u0000>\u0126\u0001\u0000\u0000\u0000@\u012e\u0001\u0000\u0000"+
		"\u0000B\u0132\u0001\u0000\u0000\u0000D\u0134\u0001\u0000\u0000\u0000F"+
		"\u0139\u0001\u0000\u0000\u0000H\u013b\u0001\u0000\u0000\u0000J\u013f\u0001"+
		"\u0000\u0000\u0000L\u0141\u0001\u0000\u0000\u0000N\u0145\u0001\u0000\u0000"+
		"\u0000P\u0150\u0001\u0000\u0000\u0000R\u0154\u0001\u0000\u0000\u0000T"+
		"\u0158\u0001\u0000\u0000\u0000V\u015e\u0001\u0000\u0000\u0000X\u0160\u0001"+
		"\u0000\u0000\u0000Z\u0167\u0001\u0000\u0000\u0000\\\u016a\u0001\u0000"+
		"\u0000\u0000^\u0171\u0001\u0000\u0000\u0000`\u017b\u0001\u0000\u0000\u0000"+
		"bc\u0003\u0002\u0001\u0000cd\u0003\u0004\u0002\u0000de\u0003\u001c\u000e"+
		"\u0000ef\u0003N\'\u0000fg\u0005\u0000\u0000\u0001g\u0001\u0001\u0000\u0000"+
		"\u0000hi\u0005\u0001\u0000\u0000ij\u0003\u0014\n\u0000j\u0003\u0001\u0000"+
		"\u0000\u0000km\u0005\u0002\u0000\u0000ln\u0003\u0006\u0003\u0000ml\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000p\u0005\u0001\u0000\u0000\u0000qr\u0005/\u0000"+
		"\u0000rs\u0003\b\u0004\u0000st\u00059\u0000\u0000tx\u00052\u0000\u0000"+
		"uw\u0003\n\u0005\u0000vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000{|\u00053\u0000\u0000|\u0007\u0001\u0000"+
		"\u0000\u0000}~\u0007\u0000\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f"+
		"\u0085\u0003\f\u0006\u0000\u0080\u0085\u0003\u0014\n\u0000\u0081\u0085"+
		"\u0003\u0012\t\u0000\u0082\u0085\u0003\u0016\u000b\u0000\u0083\u0085\u0003"+
		"\u001a\r\u0000\u0084\u007f\u0001\u0000\u0000\u0000\u0084\u0080\u0001\u0000"+
		"\u0000\u0000\u0084\u0081\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u000b\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\u0016\u0000\u0000\u0087\u0088\u0005\u001f"+
		"\u0000\u0000\u0088\u0089\u0003\u000e\u0007\u0000\u0089\u008a\u00055\u0000"+
		"\u0000\u008a\r\u0001\u0000\u0000\u0000\u008b\u008c\u0003\u0010\b\u0000"+
		"\u008c\u000f\u0001\u0000\u0000\u0000\u008d\u008e\u00057\u0000\u0000\u008e"+
		"\u008f\u00056\u0000\u0000\u008f\u0090\u00057\u0000\u0000\u0090\u0011\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0005\u0017\u0000\u0000\u0092\u0093\u0005"+
		"\u001f\u0000\u0000\u0093\u0094\u00057\u0000\u0000\u0094\u0095\u00055\u0000"+
		"\u0000\u0095\u0013\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0018\u0000"+
		"\u0000\u0097\u0098\u0005\u001f\u0000\u0000\u0098\u0099\u00057\u0000\u0000"+
		"\u0099\u009a\u00055\u0000\u0000\u009a\u0015\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005\u001a\u0000\u0000\u009c\u009d\u0005\u001f\u0000\u0000\u009d"+
		"\u009e\u0003\u0018\f\u0000\u009e\u009f\u00055\u0000\u0000\u009f\u0017"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0007\u0001\u0000\u0000\u00a1\u0019"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0019\u0000\u0000\u00a3\u00a4"+
		"\u0005\u001f\u0000\u0000\u00a4\u00a5\u00057\u0000\u0000\u00a5\u00a6\u0005"+
		"5\u0000\u0000\u00a6\u001b\u0001\u0000\u0000\u0000\u00a7\u00ab\u0005\u0003"+
		"\u0000\u0000\u00a8\u00aa\u0003\u001e\u000f\u0000\u00a9\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u001d\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b1\u0003&\u0013"+
		"\u0000\u00af\u00b1\u0003,\u0016\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u001f\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\u001d\u0000\u0000\u00b3\u00b4\u00059\u0000\u0000\u00b4"+
		"\u00b5\u0005\u001f\u0000\u0000\u00b5\u00b6\u0003$\u0012\u0000\u00b6\u00b7"+
		"\u00055\u0000\u0000\u00b7!\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u001e"+
		"\u0000\u0000\u00b9\u00ba\u00059\u0000\u0000\u00ba\u00bb\u0005\u001f\u0000"+
		"\u0000\u00bb\u00bc\u0003$\u0012\u0000\u00bc\u00bd\u00055\u0000\u0000\u00bd"+
		"#\u0001\u0000\u0000\u0000\u00be\u00bf\u0003X,\u0000\u00bf%\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005/\u0000\u0000\u00c1\u00c2\u0005 \u0000\u0000"+
		"\u00c2\u00c3\u00059\u0000\u0000\u00c3\u00ce\u00050\u0000\u0000\u00c4\u00c5"+
		"\u0005\u001d\u0000\u0000\u00c5\u00cb\u00059\u0000\u0000\u00c6\u00c7\u0005"+
		"6\u0000\u0000\u00c7\u00c8\u0005\u001d\u0000\u0000\u00c8\u00ca\u00059\u0000"+
		"\u0000\u00c9\u00c6\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00ce\u00c4\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u00051\u0000\u0000"+
		"\u00d1\u00d5\u00052\u0000\u0000\u00d2\u00d4\u0003(\u0014\u0000\u00d3\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u00053\u0000\u0000\u00d9\'\u0001\u0000\u0000\u0000\u00da\u00e2\u0003"+
		"*\u0015\u0000\u00db\u00e2\u00030\u0018\u0000\u00dc\u00e2\u00034\u001a"+
		"\u0000\u00dd\u00e2\u00036\u001b\u0000\u00de\u00e2\u0003\"\u0011\u0000"+
		"\u00df\u00e2\u0003<\u001e\u0000\u00e0\u00e2\u0003 \u0010\u0000\u00e1\u00da"+
		"\u0001\u0000\u0000\u0000\u00e1\u00db\u0001\u0000\u0000\u0000\u00e1\u00dc"+
		"\u0001\u0000\u0000\u0000\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2)\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		"!\u0000\u0000\u00e4\u00e5\u0003<\u001e\u0000\u00e5+\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0005\u001b\u0000\u0000\u00e7\u00e8\u00059\u0000\u0000"+
		"\u00e8\u00ec\u00052\u0000\u0000\u00e9\u00eb\u0003.\u0017\u0000\u00ea\u00e9"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u00053\u0000\u0000\u00f0-\u0001\u0000\u0000\u0000\u00f1\u00f4\u0003("+
		"\u0014\u0000\u00f2\u00f4\u0003:\u001d\u0000\u00f3\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4/\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0005\"\u0000\u0000\u00f6\u00f7\u00032\u0019\u0000\u00f7"+
		"\u00f8\u00055\u0000\u0000\u00f81\u0001\u0000\u0000\u0000\u00f9\u00fc\u0003"+
		"X,\u0000\u00fa\u00fc\u0003\u000e\u0007\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc3\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0005#\u0000\u0000\u00fe\u00ff\u0003\u0018\f\u0000\u00ff"+
		"\u0100\u00055\u0000\u0000\u01005\u0001\u0000\u0000\u0000\u0101\u0102\u0005"+
		"$\u0000\u0000\u0102\u0103\u0003X,\u0000\u0103\u0104\u0005%\u0000\u0000"+
		"\u0104\u0105\u00055\u0000\u0000\u01057\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0005\u001d\u0000\u0000\u0107\u010a\u00059\u0000\u0000\u0108\u010a\u0005"+
		"7\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u010a9\u0001\u0000\u0000\u0000\u010b\u010c\u0005(\u0000\u0000"+
		"\u010c\u010d\u00059\u0000\u0000\u010d\u0116\u00050\u0000\u0000\u010e\u0113"+
		"\u0003X,\u0000\u010f\u0110\u00056\u0000\u0000\u0110\u0112\u0003X,\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000"+
		"\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0116\u010e\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u00051\u0000\u0000\u0119"+
		"\u011a\u00055\u0000\u0000\u011a;\u0001\u0000\u0000\u0000\u011b\u011c\u0005"+
		"\t\u0000\u0000\u011c\u011d\u0003>\u001f\u0000\u011d\u0121\u00052\u0000"+
		"\u0000\u011e\u0120\u0003(\u0014\u0000\u011f\u011e\u0001\u0000\u0000\u0000"+
		"\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000"+
		"\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0125\u00053\u0000\u0000\u0125"+
		"=\u0001\u0000\u0000\u0000\u0126\u012a\u00050\u0000\u0000\u0127\u012b\u0003"+
		"F#\u0000\u0128\u012b\u0003@ \u0000\u0129\u012b\u0003D\"\u0000\u012a\u0127"+
		"\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u0129"+
		"\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012d"+
		"\u00051\u0000\u0000\u012d?\u0001\u0000\u0000\u0000\u012e\u012f\u0003>"+
		"\u001f\u0000\u012f\u0130\u0003B!\u0000\u0130\u0131\u0003>\u001f\u0000"+
		"\u0131A\u0001\u0000\u0000\u0000\u0132\u0133\u0007\u0002\u0000\u0000\u0133"+
		"C\u0001\u0000\u0000\u0000\u0134\u0135\u0005\f\u0000\u0000\u0135\u0136"+
		"\u0003>\u001f\u0000\u0136E\u0001\u0000\u0000\u0000\u0137\u013a\u0003H"+
		"$\u0000\u0138\u013a\u0003L&\u0000\u0139\u0137\u0001\u0000\u0000\u0000"+
		"\u0139\u0138\u0001\u0000\u0000\u0000\u013aG\u0001\u0000\u0000\u0000\u013b"+
		"\u013c\u0003X,\u0000\u013c\u013d\u0003J%\u0000\u013d\u013e\u0003X,\u0000"+
		"\u013eI\u0001\u0000\u0000\u0000\u013f\u0140\u0007\u0003\u0000\u0000\u0140"+
		"K\u0001\u0000\u0000\u0000\u0141\u0142\u0005&\u0000\u0000\u0142\u0143\u0005"+
		"\'\u0000\u0000\u0143\u0144\u0003\u0010\b\u0000\u0144M\u0001\u0000\u0000"+
		"\u0000\u0145\u014e\u0005\u0004\u0000\u0000\u0146\u0148\u0003P(\u0000\u0147"+
		"\u0149\u0003R)\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149\u014f\u0001\u0000\u0000\u0000\u014a\u014c\u0003"+
		"R)\u0000\u014b\u014d\u0003P(\u0000\u014c\u014b\u0001\u0000\u0000\u0000"+
		"\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014f\u0001\u0000\u0000\u0000"+
		"\u014e\u0146\u0001\u0000\u0000\u0000\u014e\u014a\u0001\u0000\u0000\u0000"+
		"\u014fO\u0001\u0000\u0000\u0000\u0150\u0151\u0005)\u0000\u0000\u0151\u0152"+
		"\u0003T*\u0000\u0152\u0153\u00055\u0000\u0000\u0153Q\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0005*\u0000\u0000\u0155\u0156\u0003T*\u0000\u0156"+
		"\u0157\u00055\u0000\u0000\u0157S\u0001\u0000\u0000\u0000\u0158\u0159\u0005"+
		"\u001d\u0000\u0000\u0159\u015a\u00059\u0000\u0000\u015a\u015b\u0003V+"+
		"\u0000\u015b\u015c\u0005\u0011\u0000\u0000\u015c\u015d\u00057\u0000\u0000"+
		"\u015dU\u0001\u0000\u0000\u0000\u015e\u015f\u0007\u0004\u0000\u0000\u015f"+
		"W\u0001\u0000\u0000\u0000\u0160\u0164\u0003\\.\u0000\u0161\u0163\u0003"+
		"Z-\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0163\u0166\u0001\u0000\u0000"+
		"\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000"+
		"\u0000\u0165Y\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000"+
		"\u0167\u0168\u0007\u0005\u0000\u0000\u0168\u0169\u0003\\.\u0000\u0169"+
		"[\u0001\u0000\u0000\u0000\u016a\u016e\u0003`0\u0000\u016b\u016d\u0003"+
		"^/\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000\u0000"+
		"\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000"+
		"\u0000\u016f]\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0171\u0172\u0007\u0006\u0000\u0000\u0172\u0173\u0003`0\u0000\u0173_"+
		"\u0001\u0000\u0000\u0000\u0174\u0175\u00050\u0000\u0000\u0175\u0176\u0003"+
		"X,\u0000\u0176\u0177\u00051\u0000\u0000\u0177\u017c\u0001\u0000\u0000"+
		"\u0000\u0178\u017c\u00057\u0000\u0000\u0179\u017a\u0005\u001d\u0000\u0000"+
		"\u017a\u017c\u00059\u0000\u0000\u017b\u0174\u0001\u0000\u0000\u0000\u017b"+
		"\u0178\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c"+
		"a\u0001\u0000\u0000\u0000\u0018ox\u0084\u00ab\u00b0\u00cb\u00ce\u00d5"+
		"\u00e1\u00ec\u00f3\u00fb\u0109\u0113\u0116\u0121\u012a\u0139\u0148\u014c"+
		"\u014e\u0164\u016e\u017b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}