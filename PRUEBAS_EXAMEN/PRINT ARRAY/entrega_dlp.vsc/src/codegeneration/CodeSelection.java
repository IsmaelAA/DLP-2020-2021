/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.*;
import visitor.*;

public class CodeSelection extends DefaultVisitor {
    enum Funcion {
	DIRECCION, VALOR
    }

    private Map<String, String> instruccion = new HashMap<String, String>();
    private int ifCount = 0;
    private int whileCount = 0;

    public CodeSelection(Writer writer, String sourceFile) {
	this.writer = new PrintWriter(writer);
	this.sourceFile = sourceFile;

	instruccion.put("+", "add");
	instruccion.put("-", "sub");
	instruccion.put("*", "mul");
	instruccion.put("/", "div");
	instruccion.put("&&", "and");
	instruccion.put("||", "or");

	instruccion.put("<", "lt");
	instruccion.put(">", "gt");
	instruccion.put("==", "eq");
	instruccion.put("!=", "ne");
	instruccion.put(">=", "ge");
	instruccion.put("<=", "le");

    }

    // # ----------------------------------------------------------
    /*
     * Poner aquí los visit.
     *
     * Si se ha usado VGen, solo hay que copiarlos de la clase
     * 'visitor/_PlantillaParaVisitors.txt'.
     */

    // Ejemplo:
    //
    // public Object visit(Program node, Object param) {
    // out("#source \"" + sourceFile + "\"");
    // out("call main");
    // out("halt");
    //
    // super.visit(node, param); // Recorrer los hijos
    // return null;
    // }

    // class Program { List<Definition> definition; }
    public Object visit(Program node, Object param) {

	out("#source \"" + sourceFile + "\"");
	out("call main");
	out("halt");
	visitChildren(node.getDefinition(), param);
	return null;
    }

    // class DefVariable { Type type; String name; String ambito; }
    public Object visit(DefVariable node, Object param) {

	out("#GLOBAL " + node.getName() + ":" + node.getType().getNombreMAPL());
	return null;
    }

    // class DefStruct { String name; List<VarStruct> varstruct; }
    public Object visit(DefStruct node, Object param) {

	out("#TYPE " + node.getName() + ":" + "{");
	for (VarStruct c : node.getVarstruct()) {
	    out(c.getName() + ":" + c.getType().getNombreMAPL());
	}
	out("}");

	return null;
    }

    // class DefFuncion { String name; List<Param> param; Type type;
    // List<DefVariable> defvariable; List<Sentence> sentence; }
    public Object visit(DefFuncion node, Object param) {

	out("#line " + node.getStart().getLine());
	int sizeLocales = 0;
	int sizeParametros = 0;
	out(node.getName() + ":");

	if (node.getParam() != null)
	    for (Param child : node.getParam())
		sizeParametros += child.getType().getMemSize();

	if (node.getDefvariable() != null)
	    for (DefVariable child : node.getDefvariable())
		sizeLocales += child.getType().getMemSize();

	out("enter " + sizeLocales);

	if (node.getSentence() != null)
	    for (Sentence child : node.getSentence())
		child.accept(this, param);

	if (node.getType() == null)
	    out("ret 0, " + sizeLocales + ", " + sizeParametros);

	return null;
    }

    // class Print { Expression print; String printType; }
    public Object visit(Print node, Object param) {

	out("#line " + node.getEnd().getLine());

	if (node.getPrintType().equals("")) {
	    // Si es array
	    if (node.getPrint().getType() instanceof ArrayType) {
		// Cargar valores del array y mostrarlos
		int indiceArray = Integer.parseInt(((ArrayType) node.getPrint().getType()).getPosition());
		for (int i = 0; i < indiceArray; i++) {
		    new Array(node.getPrint(), new IntConstant(String.valueOf(i))).accept(this, Funcion.VALOR);
		    out("out" + node.getPrint().getType().getSufijo());
		}

	    } else {
		node.getPrint().accept(this, Funcion.VALOR);
		out("out" + node.getPrint().getType().getSufijo());
	    }
	} else if (node.getPrintType().equals("ln") && node.getPrint() == null) {
	    out("pushb 10"); // \n
	    out("outb");
	} else if (node.getPrintType().equals("ln") && node.getPrint() != null) {
	    if (node.getPrint().getType() instanceof ArrayType) {
		// Cargar valores del array y mostrarlos
		int indiceArray = Integer.parseInt(((ArrayType) node.getPrint().getType()).getPosition());
		for (int i = 0; i < indiceArray; i++) {
		    new Array(node.getPrint(), new IntConstant(String.valueOf(i))).accept(this, Funcion.VALOR);
		    out("out" + node.getPrint().getType().getSufijo());
		}
		out("pushb 10"); // \n
		out("outb");

	    } else {
		node.getPrint().accept(this, Funcion.VALOR);
		out("out" + node.getPrint().getType().getSufijo());
		out("pushb 10"); // \n
		out("outb");
	    }
	} else if (node.getPrintType().equals("sp")) {
	    if (node.getPrint().getType() instanceof ArrayType) {
		// Cargar valores del array y mostrarlos
		int indiceArray = Integer.parseInt(((ArrayType) node.getPrint().getType()).getPosition());
		for (int i = 0; i < indiceArray; i++) {
		    new Array(node.getPrint(), new IntConstant(String.valueOf(i))).accept(this, Funcion.VALOR);
		    out("out" + node.getPrint().getType().getSufijo());
		}
		out("pushb 32"); // " "
		out("outb");
	    } else {
		node.getPrint().accept(this, Funcion.VALOR);
		out("out" + node.getPrint().getType().getSufijo());
		out("pushb 32"); // " "
		out("outb");
	    }
	}

	return null;
    }

    // class Assignment { Expression left; Expression right; }
    public Object visit(Assignment node, Object param) {

	out("#line " + node.getEnd().getLine());
	if (node.getLeft().getType() instanceof ArrayType) {
	    int indiceArray = Integer.parseInt(((ArrayType) node.getLeft().getType()).getPosition());
	    for (int i = 0; i < indiceArray; i++) {
		new Array(node.getLeft(), new IntConstant(String.valueOf(i))).accept(this, Funcion.DIRECCION);
		new Array(node.getRight(), new IntConstant(String.valueOf(i))).accept(this, Funcion.VALOR);
		out("store" + node.getLeft().getType().getSufijo());
	    }
	} else {
	    node.getLeft().accept(this, Funcion.DIRECCION);
	    node.getRight().accept(this, Funcion.VALOR);
	    out("store" + node.getLeft().getType().getSufijo());
	}
	return null;
    }

    // class Read { Expression read; }
    public Object visit(Read node, Object param) {

	out("#line " + node.getEnd().getLine());
	node.getRead().accept(this, Funcion.DIRECCION);
	out("in" + node.getRead().getType().getSufijo());
	out("store" + node.getRead().getType().getSufijo());

	return null;
    }

    // class If { Expression condition; List<Sentence> if_true; List<Sentence>
    // if_false; }
    public Object visit(If node, Object param) {

	out("#line " + node.getStart().getLine());
	int ifCount = this.ifCount;

	this.ifCount++;

	node.getCondition().accept(this, Funcion.VALOR);

	if (node.getIf_false() != null) {
	    out("jz else" + ifCount);
	} else {
	    out("jz finif" + ifCount);
	}

	for (int i = 0; i < node.getIf_true().size(); i++) {
	    node.getIf_true().get(i).accept(this, param);
	    if (i == node.getIf_true().size() - 1 && !(node.getIf_true().get(i) instanceof Return)) {
		out("jmp finif" + ifCount);
	    }
	}

	if (node.getIf_false() != null) {
	    out("else" + ifCount + ":");
	    for (Sentence child : node.getIf_false())
		child.accept(this, param);
	}
	out("finif" + ifCount + ":");

	return null;
    }

    // class While { Expression condition; List<Sentence> sentence; }
    public Object visit(While node, Object param) {

	out("#line " + node.getCondition().getStart().getLine());
	int contadorWhile = this.whileCount;

	this.whileCount++;

	out("while" + contadorWhile + ":");
	node.getCondition().accept(this, Funcion.VALOR);

	out("jz finWhile" + contadorWhile);
	visitChildren(node.getSentence(), param);

	out("jmp while" + contadorWhile);
	out("finWhile" + contadorWhile + ":");
	return null;
    }

    // class FuncCall { String name; List<Expression> expression; }
    public Object visit(FuncCall node, Object param) {

	out("#line " + node.getStart().getLine());
	if (node.getExpression() != null)
	    visitChildren(node.getExpression(), Funcion.VALOR);
	out("call " + node.getName());
	if (node.getDefinicion().getType() != null)
	    out("pop");

	return null;
    }

    // class Return { Expression retorno; }
    public Object visit(Return node, Object param) {

	int sizeLocales = 0;
	int sizeParametros = 0;

	for (Param child : node.getFunction().getParam())
	    sizeParametros += child.getType().getMemSize();
	for (DefVariable child : node.getFunction().getDefvariable())
	    sizeLocales += child.getType().getMemSize();

	if (node.getRetorno() == null)
	    out("ret 0," + sizeLocales + "," + sizeParametros);
	else {
	    node.getRetorno().accept(this, Funcion.VALOR);
	    out("ret " + node.getRetorno().getType().getMemSize() + "," + sizeLocales + "," + sizeParametros);
	}

	return null;
    }

    // class ExpresionAritmetica { Expression left; String operator; Expression
    // right; }
    public Object visit(ExpresionAritmetica node, Object param) {

	node.getLeft().accept(this, Funcion.VALOR);
	node.getRight().accept(this, Funcion.VALOR);
	out(instruccion.get(node.getOperator()) + node.getLeft().getType().getSufijo());

	return null;
    }

    // class ExpresionLogica { Expression left; String operator; Expression right; }
    public Object visit(ExpresionLogica node, Object param) {

	node.getLeft().accept(this, Funcion.VALOR);
	node.getRight().accept(this, Funcion.VALOR);
	out(instruccion.get(node.getOperator()));

	return null;
    }

    // class ExpresionCondicion { Expression left; String operator; Expression
    // right; }
    public Object visit(ExpresionCondicion node, Object param) {

	node.getLeft().accept(this, param);
	node.getRight().accept(this, param);
	out(instruccion.get(node.getOperator()) + node.getLeft().getType().getSufijo());

	return null;
    }

    // class ExpresionNot { Expression not; }
    public Object visit(ExpresionNot node, Object param) {

	if (node.getNot() != null)
	    node.getNot().accept(this, Funcion.VALOR);
	out("not");

	return null;
    }

    // class IntConstant { String value; }
    public Object visit(IntConstant node, Object param) {
	out("pushi " + node.getValue());
	return null;
    }

    // class RealConstant { String value; }
    public Object visit(RealConstant node, Object param) {
	out("pushf " + node.getValue());
	return null;
    }

    // class CharConstant { String value; }
    public Object visit(CharConstant node, Object param) {
	if ("'\\n'".equals(node.getValue()))
	    out("pushb 10");
	else
	    out("pushb " + (int) node.getValue().charAt(1));
	return null;
    }

    // class IdentConstant { String value; }
    public Object visit(IdentConstant node, Object param) {
	if (Funcion.DIRECCION.equals(param)) {
	    if (node.getDefinicion().getAmbito().equals("global")) {
		out("pusha " + node.getDefinicion().getAddress());
	    } else if (node.getDefinicion().getAmbito().equals("param")) {
		out("pusha BP");
		out("push " + node.getDefinicion().getParametro().getAddress());
		out("add");
	    } else if (node.getDefinicion().getAmbito().equals("local")) {
		out("pusha BP");
		out("push " + node.getDefinicion().getAddress());
		out("add");
	    }
	}
	if (Funcion.VALOR.equals(param)) {
	    visit(node, Funcion.DIRECCION);
	    out("load" + node.getDefinicion().getType().getSufijo());
	}
	return null;
    }

    // class Cast { Type type; Expression value; }
    public Object visit(Cast node, Object param) {

	node.getType().accept(this, param);
	node.getValue().accept(this, Funcion.VALOR);
	out(node.getValue().getType().getSufijo() + "2" + node.getType().getSufijo());

	return null;
    }

    // class Array { Expression name; Expression value; }
    public Object visit(Array node, Object param) {

	node.getName().accept(this, Funcion.DIRECCION);
	out("push " + ((ArrayType) (node.getName().getType())).getType().getMemSize());
	node.getValue().accept(this, Funcion.VALOR);
	out("mul");
	out("add");

	if (Funcion.VALOR.equals(param))
	    out("load" + ((ArrayType) node.getName().getType()).getType().getSufijo());

	return null;
    }

    // class VerStruct { Expression name; String ver; }
    public Object visit(VerStruct node, Object param) {

	if (Funcion.VALOR.equals(param)) {
	    node.accept(this, Funcion.DIRECCION);
	    out("load" + node.getType().getSufijo());
	} else {
	    node.getName().accept(this, Funcion.DIRECCION);
	    List<VarStruct> lista = ((IdentType) (node.getName()).getType()).getDefinicion().getVarstruct();
	    for (VarStruct c : lista) {
		if (c.getName().equals(node.getVer())) {
		    out("push " + c.getAddress());
		}
	    }
	    out("add");
	}

	return null;
    }

    // class FuncCallExpr { String name; List<Expression> expression; }
    public Object visit(FuncCallExpr node, Object param) {

	if (node.getExpression() != null)
	    visitChildren(node.getExpression(), Funcion.VALOR);
	out("call " + node.getName());

	return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    // Imprime una línea en el fichero de salida
    private void out(String instruction) {
	writer.println(instruction);
    }

    @SuppressWarnings("unused")
    private void line(AST node) {
	line(node.getEnd());
    }

    private void line(Position pos) {
	if (pos != null)
	    out("\n#line " + pos.getLine());
	else
	    System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }

    private PrintWriter writer;
    private String sourceFile;
}
