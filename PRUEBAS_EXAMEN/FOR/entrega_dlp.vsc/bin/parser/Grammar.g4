grammar Grammar;

import Lexicon;

@parser::header {
    import ast.*;
}

start
	returns[Program ast ] : definiciones EOF { $ast = new Program($definiciones.lista);} ;

definiciones returns[List<Definition> lista = new ArrayList<Definition>()] : (definicion {$lista.add($definicion.ast);})*;

definicion returns [Definition ast]
: def_variable {$def_variable.ast.setAmbito("global"); $ast = $def_variable.ast;}
| 'struct' IDENT '{' variablesStruct '}' ';' { $ast = new DefStruct($IDENT,$variablesStruct.lista);}
| def_funcion { $ast = $def_funcion.ast;}
;

variablesStruct returns[List<VarStruct> lista = new ArrayList<VarStruct>()]
		:(variableStruct {$lista.add($variableStruct.ast);})*;

variableStruct returns[VarStruct ast]
	: IDENT ':' tipo ';' { $ast = new VarStruct($IDENT, $tipo.ast);} ;   

variables  returns[List<DefVariable> list = new ArrayList<DefVariable>()] :(def_variable { $def_variable.ast.setAmbito("local");$list.add($def_variable.ast); })* ;

def_variable returns[DefVariable ast] 
: 'var' IDENT ':' tipo  ';'  { $ast = new DefVariable($tipo.ast, $IDENT,""); }
;

params returns[List<Param> lista = new ArrayList<Param>()] : (param{$lista.add($param.ast);}(','param{$lista.add($param.ast);})*)*;

param returns[Param ast] : IDENT ':' tipo  {$ast = new Param($IDENT, $tipo.ast);};

def_funcion returns [DefFuncion ast]
: IDENT'(' params ')' '{' variables sentencias '}'  { $ast = new DefFuncion($IDENT, $params.lista, null , $variables.list, $sentencias.list);}
| IDENT'(' params ')' ':' tipo '{' variables sentencias '}' { $ast = new DefFuncion($IDENT, $params.lista, $tipo.ast, $variables.list, $sentencias.list);}
;

tipo returns[Type ast] : 'float' {  $ast = new RealType(); } 
| 'int' {  $ast = new IntType(); }
| 'char' {  $ast = new CharType(); }
| IDENT  {  $ast = new IdentType($IDENT); }
| '[' LITINT ']' tipo { $ast = new ArrayType($LITINT,$tipo.ast);}
;

sentencias returns[List<Sentence> list = new ArrayList<Sentence>()]
:  (sentencia { $list.add($sentencia.ast); })*;

sentencia returns [Sentence ast]
: expresion '=' expresion ';' { $ast = new Assignment($ctx.expresion(0), $ctx.expresion(1));}
| 'print' expresion ';' { $ast = new Print($expresion.ast, "");}
| 'printsp' expresion ';' { $ast = new Print($expresion.ast, "sp");}
| 'println' expresion ';' { $ast = new Print($expresion.ast, "ln");}
| 'read' expresion ';' { $ast = new Read($expresion.ast);}
| 'return' expresion ';' { $ast = new Return($expresion.ast);}
| 'return' ';' { $ast = new Return(null);}
| 'if' '(' expresion ')' '{' sentencias '}' { $ast = new If($expresion.ast, $sentencias.list, null);}
| 'if' '(' expresion ')' '{' sentencias '}' 'else' '{' sentencias '}' { $ast = new If($expresion.ast, $ctx.sentencias(0).list, $ctx.sentencias(1).list);}
| 'while' '(' expresion ')' '{' sentencias '}' {$ast = new While($expresion.ast, $sentencias.list);}
| 'for' '(' sentencianpc ';' expresion ';' sentencianpc ')' '{' sentencias '}' {$ast = new For($ctx.sentencianpc(0), $expresion.ast, $ctx.sentencianpc(1), $sentencias.list);}
| IDENT '('expresiones')' ';' { $ast = new FuncCall($IDENT, $expresiones.lista);}
;


sentencianpc returns [Sentence ast]
: expresion '=' expresion  { $ast = new Assignment($ctx.expresion(0), $ctx.expresion(1));}
| 'print' expresion  { $ast = new Print($expresion.ast, "");}
| 'printsp' expresion  { $ast = new Print($expresion.ast, "sp");}
| 'println' expresion  { $ast = new Print($expresion.ast, "ln");}
| 'read' expresion  { $ast = new Read($expresion.ast);}
| 'return' expresion  { $ast = new Return($expresion.ast);}
| 'return'  { $ast = new Return(null);}
| 'if' '(' expresion ')' '{' sentencias '}' { $ast = new If($expresion.ast, $sentencias.list, null);}
| 'if' '(' expresion ')' '{' sentencias '}' 'else' '{' sentencias '}' { $ast = new If($expresion.ast, $ctx.sentencias(0).list, $ctx.sentencias(1).list);}
| 'while' '(' expresion ')' '{' sentencias '}' {$ast = new While($expresion.ast, $sentencias.list);}
| 'for' '(' sentencianpc ';' expresion ';' sentencianpc ')' '{' sentencias '}' {$ast = new For($ctx.sentencianpc(0), $expresion.ast, $ctx.sentencianpc(1), $sentencias.list);}
| IDENT '('expresiones')' { $ast = new FuncCall($IDENT, $expresiones.lista);}
;

expresiones returns [List<Expression> lista = new ArrayList<Expression>()]
:(expresion{$lista.add($expresion.ast);}(','expresion{$lista.add($expresion.ast);})*)*
;

expresion returns [Expression ast]
: IDENT { $ast = new IdentConstant($IDENT); }
| LITINT { $ast = new IntConstant($LITINT); }
| LITREAL { $ast = new RealConstant($LITREAL); }
| LITCHAR { $ast = new CharConstant($LITCHAR); }
| IDENT '('expresiones')' { $ast = new FuncCallExpr($IDENT, $expresiones.lista);}
| '('expresion')' { $ast = $expresion.ast; }
| '<'tipo'>' '('expresion')' { $ast = new Cast($tipo.ast, $expresion.ast);}
| expresion '[' expresion ']'   { $ast = new Array($ctx.expresion(0), $ctx.expresion(1));}
| expresion '.' IDENT { $ast = new VerStruct($ctx.expresion(0), $IDENT);}
| expresion op=('*'|'/') expresion { $ast = new ExpresionAritmetica($ctx.expresion(0), $op, $ctx.expresion(1));}
| expresion op=('+'|'-') expresion { $ast = new ExpresionAritmetica($ctx.expresion(0), $op, $ctx.expresion(1));}
| expresion op=('<'|'>'|'<='|'>=') expresion { $ast = new ExpresionCondicion($ctx.expresion(0), $op, $ctx.expresion(1));}
| expresion op=('!='|'==') expresion { $ast = new ExpresionCondicion($ctx.expresion(0), $op, $ctx.expresion(1));}
| expresion '&&' expresion { $ast = new ExpresionLogica($ctx.expresion(0), "&&", $ctx.expresion(1));}
| expresion '||' expresion { $ast = new ExpresionLogica($ctx.expresion(0), "||", $ctx.expresion(1));}
| '!' expresion {$ast = new ExpresionNot($expresion.ast);}
;
