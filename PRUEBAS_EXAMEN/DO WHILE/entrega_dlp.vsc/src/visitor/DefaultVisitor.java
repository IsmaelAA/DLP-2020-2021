/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Definition> definition; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDefinition(), param);
		return null;
	}

	//	class DefVariable { Type type;  String name;  String ambito; }
	public Object visit(DefVariable node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class DefStruct { String name;  List<VarStruct> varstruct; }
	public Object visit(DefStruct node, Object param) {
		visitChildren(node.getVarstruct(), param);
		return null;
	}

	//	class DefFuncion { String name;  List<Param> param;  Type type;  List<DefVariable> defvariable;  List<Sentence> sentence; }
	public Object visit(DefFuncion node, Object param) {
		visitChildren(node.getParam(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		visitChildren(node.getDefvariable(), param);
		visitChildren(node.getSentence(), param);
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		return null;
	}

	//	class IdentType { String name; }
	public Object visit(IdentType node, Object param) {
		return null;
	}

	//	class ArrayType { String position;  Type type; }
	public Object visit(ArrayType node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class Param { String name;  Type type; }
	public Object visit(Param node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class VarStruct { String name;  Type type; }
	public Object visit(VarStruct node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class Print { Expression print;  String printType; }
	public Object visit(Print node, Object param) {
		if (node.getPrint() != null)
			node.getPrint().accept(this, param);
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Read { Expression read; }
	public Object visit(Read node, Object param) {
		if (node.getRead() != null)
			node.getRead().accept(this, param);
		return null;
	}

	//	class If { Expression condition;  List<Sentence> if_true;  List<Sentence> if_false; }
	public Object visit(If node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getIf_true(), param);
		visitChildren(node.getIf_false(), param);
		return null;
	}

	//	class While { Expression condition;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getSentence(), param);
		return null;
	}
	
//	class DoWhile { List<Sentence> sentence;  Expression condition; }
	public Object visit(DoWhile node, Object param) {
		visitChildren(node.getSentence(), param);
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		return null;
	}

	//	class FuncCall { String name;  List<Expression> expression; }
	public Object visit(FuncCall node, Object param) {
		visitChildren(node.getExpression(), param);
		return null;
	}

	//	class Return { Expression retorno; }
	public Object visit(Return node, Object param) {
		if (node.getRetorno() != null)
			node.getRetorno().accept(this, param);
		return null;
	}

	//	class ExpresionAritmetica { Expression left;  String operator;  Expression right; }
	public Object visit(ExpresionAritmetica node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpresionLogica { Expression left;  String operator;  Expression right; }
	public Object visit(ExpresionLogica node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpresionCondicion { Expression left;  String operator;  Expression right; }
	public Object visit(ExpresionCondicion node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpresionNot { Expression not; }
	public Object visit(ExpresionNot node, Object param) {
		if (node.getNot() != null)
			node.getNot().accept(this, param);
		return null;
	}


	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		return null;
	}

	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		return null;
	}

	//	class IdentConstant { String value; }
	public Object visit(IdentConstant node, Object param) {
		return null;
	}

	//	class Cast { Type type;  Expression value; }
	public Object visit(Cast node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		return null;
	}

	//	class Array { Expression name;  Expression value; }
	public Object visit(Array node, Object param) {
		if (node.getName() != null)
			node.getName().accept(this, param);
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		return null;
	}

	//	class VerStruct { Expression name;  String ver; }
	public Object visit(VerStruct node, Object param) {
		if (node.getName() != null)
			node.getName().accept(this, param);
		return null;
	}

	//	class FuncCallExpr { String name;  List<Expression> expression; }
	public Object visit(FuncCallExpr node, Object param) {
		visitChildren(node.getExpression(), param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
