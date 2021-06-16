// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, LITINT=38, 
		LITREAL=39, LITCHAR=40, IDENT=41, COMMENT=42, MULTILINE_COMMENT=43, WHITESPACE=44;
	public static final int
		RULE_start = 0, RULE_definiciones = 1, RULE_definicion = 2, RULE_variablesStruct = 3, 
		RULE_variableStruct = 4, RULE_variables = 5, RULE_def_variable = 6, RULE_params = 7, 
		RULE_param = 8, RULE_def_funcion = 9, RULE_tipo = 10, RULE_sentencias = 11, 
		RULE_sentencia = 12, RULE_expresiones = 13, RULE_expresion = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definiciones", "definicion", "variablesStruct", "variableStruct", 
			"variables", "def_variable", "params", "param", "def_funcion", "tipo", 
			"sentencias", "sentencia", "expresiones", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "':'", "'var'", "','", "'('", 
			"')'", "'float'", "'int'", "'char'", "'['", "']'", "'='", "'print'", 
			"'printsp'", "'println'", "'read'", "'return'", "'if'", "'else'", "'while'", 
			"'<'", "'>'", "'.'", "'*'", "'/'", "'+'", "'-'", "'<='", "'>='", "'!='", 
			"'=='", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "LITINT", "LITREAL", "LITCHAR", "IDENT", "COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public DefinicionesContext definiciones;
		public DefinicionesContext definiciones() {
			return getRuleContext(DefinicionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((StartContext)_localctx).definiciones = definiciones();
			setState(31);
			match(EOF);
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).definiciones.lista);
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

	public static class DefinicionesContext extends ParserRuleContext {
		public List<Definition> lista = new ArrayList<Definition>();
		public DefinicionContext definicion;
		public List<DefinicionContext> definicion() {
			return getRuleContexts(DefinicionContext.class);
		}
		public DefinicionContext definicion(int i) {
			return getRuleContext(DefinicionContext.class,i);
		}
		public DefinicionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definiciones; }
	}

	public final DefinicionesContext definiciones() throws RecognitionException {
		DefinicionesContext _localctx = new DefinicionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definiciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << IDENT))) != 0)) {
				{
				{
				setState(34);
				((DefinicionesContext)_localctx).definicion = definicion();
				_localctx.lista.add(((DefinicionesContext)_localctx).definicion.ast);
				}
				}
				setState(41);
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

	public static class DefinicionContext extends ParserRuleContext {
		public Definition ast;
		public Def_variableContext def_variable;
		public Token IDENT;
		public VariablesStructContext variablesStruct;
		public Def_funcionContext def_funcion;
		public Def_variableContext def_variable() {
			return getRuleContext(Def_variableContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public VariablesStructContext variablesStruct() {
			return getRuleContext(VariablesStructContext.class,0);
		}
		public Def_funcionContext def_funcion() {
			return getRuleContext(Def_funcionContext.class,0);
		}
		public DefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion; }
	}

	public final DefinicionContext definicion() throws RecognitionException {
		DefinicionContext _localctx = new DefinicionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definicion);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((DefinicionContext)_localctx).def_variable = def_variable();
				((DefinicionContext)_localctx).def_variable.ast.setAmbito("global"); ((DefinicionContext)_localctx).ast =  ((DefinicionContext)_localctx).def_variable.ast;
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__0);
				setState(46);
				((DefinicionContext)_localctx).IDENT = match(IDENT);
				setState(47);
				match(T__1);
				setState(48);
				((DefinicionContext)_localctx).variablesStruct = variablesStruct();
				setState(49);
				match(T__2);
				setState(50);
				match(T__3);
				 ((DefinicionContext)_localctx).ast =  new DefStruct(((DefinicionContext)_localctx).IDENT,((DefinicionContext)_localctx).variablesStruct.lista);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				((DefinicionContext)_localctx).def_funcion = def_funcion();
				 ((DefinicionContext)_localctx).ast =  ((DefinicionContext)_localctx).def_funcion.ast;
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

	public static class VariablesStructContext extends ParserRuleContext {
		public List<VarStruct> lista = new ArrayList<VarStruct>();
		public VariableStructContext variableStruct;
		public List<VariableStructContext> variableStruct() {
			return getRuleContexts(VariableStructContext.class);
		}
		public VariableStructContext variableStruct(int i) {
			return getRuleContext(VariableStructContext.class,i);
		}
		public VariablesStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesStruct; }
	}

	public final VariablesStructContext variablesStruct() throws RecognitionException {
		VariablesStructContext _localctx = new VariablesStructContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variablesStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(58);
				((VariablesStructContext)_localctx).variableStruct = variableStruct();
				_localctx.lista.add(((VariablesStructContext)_localctx).variableStruct.ast);
				}
				}
				setState(65);
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

	public static class VariableStructContext extends ParserRuleContext {
		public VarStruct ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public VariableStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStruct; }
	}

	public final VariableStructContext variableStruct() throws RecognitionException {
		VariableStructContext _localctx = new VariableStructContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableStruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((VariableStructContext)_localctx).IDENT = match(IDENT);
			setState(67);
			match(T__4);
			setState(68);
			((VariableStructContext)_localctx).tipo = tipo();
			setState(69);
			match(T__3);
			 ((VariableStructContext)_localctx).ast =  new VarStruct(((VariableStructContext)_localctx).IDENT, ((VariableStructContext)_localctx).tipo.ast);
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

	public static class VariablesContext extends ParserRuleContext {
		public List<DefVariable> list = new ArrayList<DefVariable>();
		public Def_variableContext def_variable;
		public List<Def_variableContext> def_variable() {
			return getRuleContexts(Def_variableContext.class);
		}
		public Def_variableContext def_variable(int i) {
			return getRuleContext(Def_variableContext.class,i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(72);
				((VariablesContext)_localctx).def_variable = def_variable();
				 ((VariablesContext)_localctx).def_variable.ast.setAmbito("local");_localctx.list.add(((VariablesContext)_localctx).def_variable.ast); 
				}
				}
				setState(79);
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

	public static class Def_variableContext extends ParserRuleContext {
		public DefVariable ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Def_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_variable; }
	}

	public final Def_variableContext def_variable() throws RecognitionException {
		Def_variableContext _localctx = new Def_variableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_def_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__5);
			setState(81);
			((Def_variableContext)_localctx).IDENT = match(IDENT);
			setState(82);
			match(T__4);
			setState(83);
			((Def_variableContext)_localctx).tipo = tipo();
			setState(84);
			match(T__3);
			 ((Def_variableContext)_localctx).ast =  new DefVariable(((Def_variableContext)_localctx).tipo.ast, ((Def_variableContext)_localctx).IDENT,""); 
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

	public static class ParamsContext extends ParserRuleContext {
		public List<Param> lista = new ArrayList<Param>();
		public ParamContext param;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(87);
				((ParamsContext)_localctx).param = param();
				_localctx.lista.add(((ParamsContext)_localctx).param.ast);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(89);
					match(T__6);
					setState(90);
					((ParamsContext)_localctx).param = param();
					_localctx.lista.add(((ParamsContext)_localctx).param.ast);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(102);
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

	public static class ParamContext extends ParserRuleContext {
		public Param ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			((ParamContext)_localctx).IDENT = match(IDENT);
			setState(104);
			match(T__4);
			setState(105);
			((ParamContext)_localctx).tipo = tipo();
			((ParamContext)_localctx).ast =  new Param(((ParamContext)_localctx).IDENT, ((ParamContext)_localctx).tipo.ast);
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

	public static class Def_funcionContext extends ParserRuleContext {
		public DefFuncion ast;
		public Token IDENT;
		public ParamsContext params;
		public VariablesContext variables;
		public SentenciasContext sentencias;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Def_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_funcion; }
	}

	public final Def_funcionContext def_funcion() throws RecognitionException {
		Def_funcionContext _localctx = new Def_funcionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_def_funcion);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((Def_funcionContext)_localctx).IDENT = match(IDENT);
				setState(109);
				match(T__7);
				setState(110);
				((Def_funcionContext)_localctx).params = params();
				setState(111);
				match(T__8);
				setState(112);
				match(T__1);
				setState(113);
				((Def_funcionContext)_localctx).variables = variables();
				setState(114);
				((Def_funcionContext)_localctx).sentencias = sentencias();
				setState(115);
				match(T__2);
				 ((Def_funcionContext)_localctx).ast =  new DefFuncion(((Def_funcionContext)_localctx).IDENT, ((Def_funcionContext)_localctx).params.lista, null , ((Def_funcionContext)_localctx).variables.list, ((Def_funcionContext)_localctx).sentencias.list);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				((Def_funcionContext)_localctx).IDENT = match(IDENT);
				setState(119);
				match(T__7);
				setState(120);
				((Def_funcionContext)_localctx).params = params();
				setState(121);
				match(T__8);
				setState(122);
				match(T__4);
				setState(123);
				((Def_funcionContext)_localctx).tipo = tipo();
				setState(124);
				match(T__1);
				setState(125);
				((Def_funcionContext)_localctx).variables = variables();
				setState(126);
				((Def_funcionContext)_localctx).sentencias = sentencias();
				setState(127);
				match(T__2);
				 ((Def_funcionContext)_localctx).ast =  new DefFuncion(((Def_funcionContext)_localctx).IDENT, ((Def_funcionContext)_localctx).params.lista, ((Def_funcionContext)_localctx).tipo.ast, ((Def_funcionContext)_localctx).variables.list, ((Def_funcionContext)_localctx).sentencias.list);
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

	public static class TipoContext extends ParserRuleContext {
		public Type ast;
		public Token IDENT;
		public Token LITINT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode LITINT() { return getToken(GrammarParser.LITINT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T__9);
				  ((TipoContext)_localctx).ast =  new RealType(); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(T__10);
				  ((TipoContext)_localctx).ast =  new IntType(); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(T__11);
				  ((TipoContext)_localctx).ast =  new CharType(); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				((TipoContext)_localctx).IDENT = match(IDENT);
				  ((TipoContext)_localctx).ast =  new StructType(((TipoContext)_localctx).IDENT); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				match(T__12);
				setState(141);
				((TipoContext)_localctx).LITINT = match(LITINT);
				setState(142);
				match(T__13);
				setState(143);
				((TipoContext)_localctx).tipo = tipo();
				 ((TipoContext)_localctx).ast =  new ArrayType(((TipoContext)_localctx).LITINT,((TipoContext)_localctx).tipo.ast);
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

	public static class SentenciasContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenciaContext sentencia;
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__36) | (1L << LITINT) | (1L << LITREAL) | (1L << LITCHAR) | (1L << IDENT))) != 0)) {
				{
				{
				setState(148);
				((SentenciasContext)_localctx).sentencia = sentencia();
				 _localctx.list.add(((SentenciasContext)_localctx).sentencia.ast); 
				}
				}
				setState(155);
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

	public static class SentenciaContext extends ParserRuleContext {
		public Sentence ast;
		public ExpresionContext expresion;
		public SentenciasContext sentencias;
		public Token IDENT;
		public ExpresionesContext expresiones;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<SentenciasContext> sentencias() {
			return getRuleContexts(SentenciasContext.class);
		}
		public SentenciasContext sentencias(int i) {
			return getRuleContext(SentenciasContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExpresionesContext expresiones() {
			return getRuleContext(ExpresionesContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentencia);
		try {
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				expresion(0);
				setState(157);
				match(T__14);
				setState(158);
				expresion(0);
				setState(159);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Assignment(_localctx.expresion(0), _localctx.expresion(1));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(T__15);
				setState(163);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(164);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Print(((SentenciaContext)_localctx).expresion.ast, "");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(T__16);
				setState(168);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(169);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Print(((SentenciaContext)_localctx).expresion.ast, "sp");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(T__17);
				setState(173);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(174);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Print(((SentenciaContext)_localctx).expresion.ast, "ln");
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(177);
				match(T__18);
				setState(178);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(179);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Read(((SentenciaContext)_localctx).expresion.ast);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(182);
				match(T__19);
				setState(183);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(184);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Return(((SentenciaContext)_localctx).expresion.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				match(T__19);
				setState(188);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Return(null);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				match(T__20);
				setState(191);
				match(T__7);
				setState(192);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(193);
				match(T__8);
				setState(194);
				match(T__1);
				setState(195);
				((SentenciaContext)_localctx).sentencias = sentencias();
				setState(196);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new If(((SentenciaContext)_localctx).expresion.ast, ((SentenciaContext)_localctx).sentencias.list, null);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(199);
				match(T__20);
				setState(200);
				match(T__7);
				setState(201);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(202);
				match(T__8);
				setState(203);
				match(T__1);
				setState(204);
				sentencias();
				setState(205);
				match(T__2);
				setState(206);
				match(T__21);
				setState(207);
				match(T__1);
				setState(208);
				sentencias();
				setState(209);
				match(T__2);
				 ((SentenciaContext)_localctx).ast =  new If(((SentenciaContext)_localctx).expresion.ast, _localctx.sentencias(0).list, _localctx.sentencias(1).list);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(212);
				match(T__22);
				setState(213);
				match(T__7);
				setState(214);
				((SentenciaContext)_localctx).expresion = expresion(0);
				setState(215);
				match(T__8);
				setState(216);
				match(T__1);
				setState(217);
				((SentenciaContext)_localctx).sentencias = sentencias();
				setState(218);
				match(T__2);
				((SentenciaContext)_localctx).ast =  new While(((SentenciaContext)_localctx).expresion.ast, ((SentenciaContext)_localctx).sentencias.list);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(221);
				((SentenciaContext)_localctx).IDENT = match(IDENT);
				setState(222);
				match(T__7);
				setState(223);
				((SentenciaContext)_localctx).expresiones = expresiones();
				setState(224);
				match(T__8);
				setState(225);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new FuncCall(((SentenciaContext)_localctx).IDENT, ((SentenciaContext)_localctx).expresiones.lista);
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

	public static class ExpresionesContext extends ParserRuleContext {
		public List<Expression> lista = new ArrayList<Expression>();
		public ExpresionContext expresion;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ExpresionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresiones; }
	}

	public final ExpresionesContext expresiones() throws RecognitionException {
		ExpresionesContext _localctx = new ExpresionesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expresiones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__23) | (1L << T__36) | (1L << LITINT) | (1L << LITREAL) | (1L << LITCHAR) | (1L << IDENT))) != 0)) {
				{
				{
				setState(230);
				((ExpresionesContext)_localctx).expresion = expresion(0);
				_localctx.lista.add(((ExpresionesContext)_localctx).expresion.ast);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(232);
					match(T__6);
					setState(233);
					((ExpresionesContext)_localctx).expresion = expresion(0);
					_localctx.lista.add(((ExpresionesContext)_localctx).expresion.ast);
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(245);
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

	public static class ExpresionContext extends ParserRuleContext {
		public Expression ast;
		public Token IDENT;
		public Token LITINT;
		public Token LITREAL;
		public Token LITCHAR;
		public ExpresionesContext expresiones;
		public ExpresionContext expresion;
		public TipoContext tipo;
		public Token op;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode LITINT() { return getToken(GrammarParser.LITINT, 0); }
		public TerminalNode LITREAL() { return getToken(GrammarParser.LITREAL, 0); }
		public TerminalNode LITCHAR() { return getToken(GrammarParser.LITCHAR, 0); }
		public ExpresionesContext expresiones() {
			return getRuleContext(ExpresionesContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(247);
				((ExpresionContext)_localctx).IDENT = match(IDENT);
				 ((ExpresionContext)_localctx).ast =  new IdentConstant(((ExpresionContext)_localctx).IDENT); 
				}
				break;
			case 2:
				{
				setState(249);
				((ExpresionContext)_localctx).LITINT = match(LITINT);
				 ((ExpresionContext)_localctx).ast =  new IntConstant(((ExpresionContext)_localctx).LITINT); 
				}
				break;
			case 3:
				{
				setState(251);
				((ExpresionContext)_localctx).LITREAL = match(LITREAL);
				 ((ExpresionContext)_localctx).ast =  new RealConstant(((ExpresionContext)_localctx).LITREAL); 
				}
				break;
			case 4:
				{
				setState(253);
				((ExpresionContext)_localctx).LITCHAR = match(LITCHAR);
				 ((ExpresionContext)_localctx).ast =  new CharConstant(((ExpresionContext)_localctx).LITCHAR); 
				}
				break;
			case 5:
				{
				setState(255);
				((ExpresionContext)_localctx).IDENT = match(IDENT);
				setState(256);
				match(T__7);
				setState(257);
				((ExpresionContext)_localctx).expresiones = expresiones();
				setState(258);
				match(T__8);
				 ((ExpresionContext)_localctx).ast =  new FuncCallExpr(((ExpresionContext)_localctx).IDENT, ((ExpresionContext)_localctx).expresiones.lista);
				}
				break;
			case 6:
				{
				setState(261);
				match(T__7);
				setState(262);
				((ExpresionContext)_localctx).expresion = expresion(0);
				setState(263);
				match(T__8);
				 ((ExpresionContext)_localctx).ast =  ((ExpresionContext)_localctx).expresion.ast; 
				}
				break;
			case 7:
				{
				setState(266);
				match(T__23);
				setState(267);
				((ExpresionContext)_localctx).tipo = tipo();
				setState(268);
				match(T__24);
				setState(269);
				match(T__7);
				setState(270);
				((ExpresionContext)_localctx).expresion = expresion(0);
				setState(271);
				match(T__8);
				 ((ExpresionContext)_localctx).ast =  new Cast(((ExpresionContext)_localctx).tipo.ast, ((ExpresionContext)_localctx).expresion.ast);
				}
				break;
			case 8:
				{
				setState(274);
				match(T__36);
				setState(275);
				((ExpresionContext)_localctx).expresion = expresion(1);
				((ExpresionContext)_localctx).ast =  new ExpresionNot(((ExpresionContext)_localctx).expresion.ast);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(320);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(280);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(281);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(282);
						((ExpresionContext)_localctx).expresion = expresion(8);
						 ((ExpresionContext)_localctx).ast =  new ExpresionAritmetica(_localctx.expresion(0), ((ExpresionContext)_localctx).op, _localctx.expresion(1));
						}
						break;
					case 2:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(285);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(286);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(287);
						((ExpresionContext)_localctx).expresion = expresion(7);
						 ((ExpresionContext)_localctx).ast =  new ExpresionAritmetica(_localctx.expresion(0), ((ExpresionContext)_localctx).op, _localctx.expresion(1));
						}
						break;
					case 3:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(290);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(291);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__30) | (1L << T__31))) != 0)) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(292);
						((ExpresionContext)_localctx).expresion = expresion(6);
						 ((ExpresionContext)_localctx).ast =  new ExpresionCondicion(_localctx.expresion(0), ((ExpresionContext)_localctx).op, _localctx.expresion(1));
						}
						break;
					case 4:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(295);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(296);
						((ExpresionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((ExpresionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(297);
						((ExpresionContext)_localctx).expresion = expresion(5);
						 ((ExpresionContext)_localctx).ast =  new ExpresionCondicion(_localctx.expresion(0), ((ExpresionContext)_localctx).op, _localctx.expresion(1));
						}
						break;
					case 5:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(300);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(301);
						match(T__34);
						setState(302);
						((ExpresionContext)_localctx).expresion = expresion(4);
						 ((ExpresionContext)_localctx).ast =  new ExpresionLogica(_localctx.expresion(0), "&&", _localctx.expresion(1));
						}
						break;
					case 6:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(305);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(306);
						match(T__35);
						setState(307);
						((ExpresionContext)_localctx).expresion = expresion(3);
						 ((ExpresionContext)_localctx).ast =  new ExpresionLogica(_localctx.expresion(0), "||", _localctx.expresion(1));
						}
						break;
					case 7:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(310);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(311);
						match(T__12);
						setState(312);
						((ExpresionContext)_localctx).expresion = expresion(0);
						setState(313);
						match(T__13);
						 ((ExpresionContext)_localctx).ast =  new Array(_localctx.expresion(0), _localctx.expresion(1));
						}
						break;
					case 8:
						{
						_localctx = new ExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(316);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(317);
						match(T__25);
						setState(318);
						((ExpresionContext)_localctx).IDENT = match(IDENT);
						 ((ExpresionContext)_localctx).ast =  new VerStruct(_localctx.expresion(0), ((ExpresionContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0148\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7N\n\7\f\7\16\7Q\13\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t`\n\t\f\t\16\tc\13\t\7\te\n\t"+
		"\f\t\16\th\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0085\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u0095\n\f\3\r\3\r\3\r\7\r\u009a\n\r\f\r\16\r\u009d\13\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00e7\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00ef\n\17"+
		"\f\17\16\17\u00f2\13\17\7\17\u00f4\n\17\f\17\16\17\u00f7\13\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u0119\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u0143\n\20\f\20\16\20\u0146\13\20\3\20\2\3\36"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\3\2\35\36\3\2\37 \4\2\32"+
		"\33!\"\3\2#$\2\u0160\2 \3\2\2\2\4)\3\2\2\2\6:\3\2\2\2\bA\3\2\2\2\nD\3"+
		"\2\2\2\fO\3\2\2\2\16R\3\2\2\2\20f\3\2\2\2\22i\3\2\2\2\24\u0084\3\2\2\2"+
		"\26\u0094\3\2\2\2\30\u009b\3\2\2\2\32\u00e6\3\2\2\2\34\u00f5\3\2\2\2\36"+
		"\u0118\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\"#\b\2\1\2#\3\3\2\2\2$%\5\6\4\2%&"+
		"\b\3\1\2&(\3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2"+
		"\2+)\3\2\2\2,-\5\16\b\2-.\b\4\1\2.;\3\2\2\2/\60\7\3\2\2\60\61\7+\2\2\61"+
		"\62\7\4\2\2\62\63\5\b\5\2\63\64\7\5\2\2\64\65\7\6\2\2\65\66\b\4\1\2\66"+
		";\3\2\2\2\678\5\24\13\289\b\4\1\29;\3\2\2\2:,\3\2\2\2:/\3\2\2\2:\67\3"+
		"\2\2\2;\7\3\2\2\2<=\5\n\6\2=>\b\5\1\2>@\3\2\2\2?<\3\2\2\2@C\3\2\2\2A?"+
		"\3\2\2\2AB\3\2\2\2B\t\3\2\2\2CA\3\2\2\2DE\7+\2\2EF\7\7\2\2FG\5\26\f\2"+
		"GH\7\6\2\2HI\b\6\1\2I\13\3\2\2\2JK\5\16\b\2KL\b\7\1\2LN\3\2\2\2MJ\3\2"+
		"\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QO\3\2\2\2RS\7\b\2\2ST\7"+
		"+\2\2TU\7\7\2\2UV\5\26\f\2VW\7\6\2\2WX\b\b\1\2X\17\3\2\2\2YZ\5\22\n\2"+
		"Za\b\t\1\2[\\\7\t\2\2\\]\5\22\n\2]^\b\t\1\2^`\3\2\2\2_[\3\2\2\2`c\3\2"+
		"\2\2a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2dY\3\2\2\2eh\3\2\2\2fd\3\2"+
		"\2\2fg\3\2\2\2g\21\3\2\2\2hf\3\2\2\2ij\7+\2\2jk\7\7\2\2kl\5\26\f\2lm\b"+
		"\n\1\2m\23\3\2\2\2no\7+\2\2op\7\n\2\2pq\5\20\t\2qr\7\13\2\2rs\7\4\2\2"+
		"st\5\f\7\2tu\5\30\r\2uv\7\5\2\2vw\b\13\1\2w\u0085\3\2\2\2xy\7+\2\2yz\7"+
		"\n\2\2z{\5\20\t\2{|\7\13\2\2|}\7\7\2\2}~\5\26\f\2~\177\7\4\2\2\177\u0080"+
		"\5\f\7\2\u0080\u0081\5\30\r\2\u0081\u0082\7\5\2\2\u0082\u0083\b\13\1\2"+
		"\u0083\u0085\3\2\2\2\u0084n\3\2\2\2\u0084x\3\2\2\2\u0085\25\3\2\2\2\u0086"+
		"\u0087\7\f\2\2\u0087\u0095\b\f\1\2\u0088\u0089\7\r\2\2\u0089\u0095\b\f"+
		"\1\2\u008a\u008b\7\16\2\2\u008b\u0095\b\f\1\2\u008c\u008d\7+\2\2\u008d"+
		"\u0095\b\f\1\2\u008e\u008f\7\17\2\2\u008f\u0090\7(\2\2\u0090\u0091\7\20"+
		"\2\2\u0091\u0092\5\26\f\2\u0092\u0093\b\f\1\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0086\3\2\2\2\u0094\u0088\3\2\2\2\u0094\u008a\3\2\2\2\u0094\u008c\3\2"+
		"\2\2\u0094\u008e\3\2\2\2\u0095\27\3\2\2\2\u0096\u0097\5\32\16\2\u0097"+
		"\u0098\b\r\1\2\u0098\u009a\3\2\2\2\u0099\u0096\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\31\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u009f\5\36\20\2\u009f\u00a0\7\21\2\2\u00a0\u00a1\5\36\20"+
		"\2\u00a1\u00a2\7\6\2\2\u00a2\u00a3\b\16\1\2\u00a3\u00e7\3\2\2\2\u00a4"+
		"\u00a5\7\22\2\2\u00a5\u00a6\5\36\20\2\u00a6\u00a7\7\6\2\2\u00a7\u00a8"+
		"\b\16\1\2\u00a8\u00e7\3\2\2\2\u00a9\u00aa\7\23\2\2\u00aa\u00ab\5\36\20"+
		"\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad\b\16\1\2\u00ad\u00e7\3\2\2\2\u00ae"+
		"\u00af\7\24\2\2\u00af\u00b0\5\36\20\2\u00b0\u00b1\7\6\2\2\u00b1\u00b2"+
		"\b\16\1\2\u00b2\u00e7\3\2\2\2\u00b3\u00b4\7\25\2\2\u00b4\u00b5\5\36\20"+
		"\2\u00b5\u00b6\7\6\2\2\u00b6\u00b7\b\16\1\2\u00b7\u00e7\3\2\2\2\u00b8"+
		"\u00b9\7\26\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\7\6\2\2\u00bb\u00bc"+
		"\b\16\1\2\u00bc\u00e7\3\2\2\2\u00bd\u00be\7\26\2\2\u00be\u00bf\7\6\2\2"+
		"\u00bf\u00e7\b\16\1\2\u00c0\u00c1\7\27\2\2\u00c1\u00c2\7\n\2\2\u00c2\u00c3"+
		"\5\36\20\2\u00c3\u00c4\7\13\2\2\u00c4\u00c5\7\4\2\2\u00c5\u00c6\5\30\r"+
		"\2\u00c6\u00c7\7\5\2\2\u00c7\u00c8\b\16\1\2\u00c8\u00e7\3\2\2\2\u00c9"+
		"\u00ca\7\27\2\2\u00ca\u00cb\7\n\2\2\u00cb\u00cc\5\36\20\2\u00cc\u00cd"+
		"\7\13\2\2\u00cd\u00ce\7\4\2\2\u00ce\u00cf\5\30\r\2\u00cf\u00d0\7\5\2\2"+
		"\u00d0\u00d1\7\30\2\2\u00d1\u00d2\7\4\2\2\u00d2\u00d3\5\30\r\2\u00d3\u00d4"+
		"\7\5\2\2\u00d4\u00d5\b\16\1\2\u00d5\u00e7\3\2\2\2\u00d6\u00d7\7\31\2\2"+
		"\u00d7\u00d8\7\n\2\2\u00d8\u00d9\5\36\20\2\u00d9\u00da\7\13\2\2\u00da"+
		"\u00db\7\4\2\2\u00db\u00dc\5\30\r\2\u00dc\u00dd\7\5\2\2\u00dd\u00de\b"+
		"\16\1\2\u00de\u00e7\3\2\2\2\u00df\u00e0\7+\2\2\u00e0\u00e1\7\n\2\2\u00e1"+
		"\u00e2\5\34\17\2\u00e2\u00e3\7\13\2\2\u00e3\u00e4\7\6\2\2\u00e4\u00e5"+
		"\b\16\1\2\u00e5\u00e7\3\2\2\2\u00e6\u009e\3\2\2\2\u00e6\u00a4\3\2\2\2"+
		"\u00e6\u00a9\3\2\2\2\u00e6\u00ae\3\2\2\2\u00e6\u00b3\3\2\2\2\u00e6\u00b8"+
		"\3\2\2\2\u00e6\u00bd\3\2\2\2\u00e6\u00c0\3\2\2\2\u00e6\u00c9\3\2\2\2\u00e6"+
		"\u00d6\3\2\2\2\u00e6\u00df\3\2\2\2\u00e7\33\3\2\2\2\u00e8\u00e9\5\36\20"+
		"\2\u00e9\u00f0\b\17\1\2\u00ea\u00eb\7\t\2\2\u00eb\u00ec\5\36\20\2\u00ec"+
		"\u00ed\b\17\1\2\u00ed\u00ef\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ef\u00f2\3"+
		"\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00e8\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\35\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9"+
		"\b\20\1\2\u00f9\u00fa\7+\2\2\u00fa\u0119\b\20\1\2\u00fb\u00fc\7(\2\2\u00fc"+
		"\u0119\b\20\1\2\u00fd\u00fe\7)\2\2\u00fe\u0119\b\20\1\2\u00ff\u0100\7"+
		"*\2\2\u0100\u0119\b\20\1\2\u0101\u0102\7+\2\2\u0102\u0103\7\n\2\2\u0103"+
		"\u0104\5\34\17\2\u0104\u0105\7\13\2\2\u0105\u0106\b\20\1\2\u0106\u0119"+
		"\3\2\2\2\u0107\u0108\7\n\2\2\u0108\u0109\5\36\20\2\u0109\u010a\7\13\2"+
		"\2\u010a\u010b\b\20\1\2\u010b\u0119\3\2\2\2\u010c\u010d\7\32\2\2\u010d"+
		"\u010e\5\26\f\2\u010e\u010f\7\33\2\2\u010f\u0110\7\n\2\2\u0110\u0111\5"+
		"\36\20\2\u0111\u0112\7\13\2\2\u0112\u0113\b\20\1\2\u0113\u0119\3\2\2\2"+
		"\u0114\u0115\7\'\2\2\u0115\u0116\5\36\20\3\u0116\u0117\b\20\1\2\u0117"+
		"\u0119\3\2\2\2\u0118\u00f8\3\2\2\2\u0118\u00fb\3\2\2\2\u0118\u00fd\3\2"+
		"\2\2\u0118\u00ff\3\2\2\2\u0118\u0101\3\2\2\2\u0118\u0107\3\2\2\2\u0118"+
		"\u010c\3\2\2\2\u0118\u0114\3\2\2\2\u0119\u0144\3\2\2\2\u011a\u011b\f\t"+
		"\2\2\u011b\u011c\t\2\2\2\u011c\u011d\5\36\20\n\u011d\u011e\b\20\1\2\u011e"+
		"\u0143\3\2\2\2\u011f\u0120\f\b\2\2\u0120\u0121\t\3\2\2\u0121\u0122\5\36"+
		"\20\t\u0122\u0123\b\20\1\2\u0123\u0143\3\2\2\2\u0124\u0125\f\7\2\2\u0125"+
		"\u0126\t\4\2\2\u0126\u0127\5\36\20\b\u0127\u0128\b\20\1\2\u0128\u0143"+
		"\3\2\2\2\u0129\u012a\f\6\2\2\u012a\u012b\t\5\2\2\u012b\u012c\5\36\20\7"+
		"\u012c\u012d\b\20\1\2\u012d\u0143\3\2\2\2\u012e\u012f\f\5\2\2\u012f\u0130"+
		"\7%\2\2\u0130\u0131\5\36\20\6\u0131\u0132\b\20\1\2\u0132\u0143\3\2\2\2"+
		"\u0133\u0134\f\4\2\2\u0134\u0135\7&\2\2\u0135\u0136\5\36\20\5\u0136\u0137"+
		"\b\20\1\2\u0137\u0143\3\2\2\2\u0138\u0139\f\13\2\2\u0139\u013a\7\17\2"+
		"\2\u013a\u013b\5\36\20\2\u013b\u013c\7\20\2\2\u013c\u013d\b\20\1\2\u013d"+
		"\u0143\3\2\2\2\u013e\u013f\f\n\2\2\u013f\u0140\7\34\2\2\u0140\u0141\7"+
		"+\2\2\u0141\u0143\b\20\1\2\u0142\u011a\3\2\2\2\u0142\u011f\3\2\2\2\u0142"+
		"\u0124\3\2\2\2\u0142\u0129\3\2\2\2\u0142\u012e\3\2\2\2\u0142\u0133\3\2"+
		"\2\2\u0142\u0138\3\2\2\2\u0142\u013e\3\2\2\2\u0143\u0146\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\37\3\2\2\2\u0146\u0144\3\2\2"+
		"\2\21):AOaf\u0084\u0094\u009b\u00e6\u00f0\u00f5\u0118\u0142\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}