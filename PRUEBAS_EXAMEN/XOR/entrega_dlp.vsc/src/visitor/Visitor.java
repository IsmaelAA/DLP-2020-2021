/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(DefVariable node, Object param);
	public Object visit(DefStruct node, Object param);
	public Object visit(DefFuncion node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(RealType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(IdentType node, Object param);
	public Object visit(ArrayType node, Object param);
	public Object visit(Param node, Object param);
	public Object visit(VarStruct node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(If node, Object param);
	public Object visit(While node, Object param);
	public Object visit(FuncCall node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(ExpresionAritmetica node, Object param);
	public Object visit(ExpresionLogica node, Object param);
	public Object visit(ExpresionCondicion node, Object param);
	public Object visit(ExpresionNot node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(RealConstant node, Object param);
	public Object visit(CharConstant node, Object param);
	public Object visit(IdentConstant node, Object param);
	public Object visit(Cast node, Object param);
	public Object visit(Array node, Object param);
	public Object visit(VerStruct node, Object param);
	public Object visit(FuncCallExpr node, Object param);
}
