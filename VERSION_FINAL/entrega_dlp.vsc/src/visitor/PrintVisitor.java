package visitor;

// package <nombre paquete>;

import ast.*;

/*
Plantilla para Visitors.
Para crear un nuevo Visitor cortar y pegar este código y ya se tendría un visitor que compila y
que al ejecutarlo recorrería todo el árbol (sin hacer nada aún en él).
Solo quedaría añadir a cada método visit aquello adicional que se quiera realizar sobre su nodo del AST.
*/

public class PrintVisitor extends DefaultVisitor {

    // ---------------------------------------------------------
    // Tareas a realizar en cada método visit:
    //
    // Si en algún método visit NO SE QUIERE HACER NADA más que recorrer los hijos
    // entonces se puede
    // borrar (dicho método se heredaría de DefaultVisitor con el código de
    // recorrido).
    //
    // Lo siguiente es para cuando se quiera AÑADIR alguna funcionalidad adicional a
    // un visit:
    //
    // - El código que aparece en cada método visit es aquel que recorre los hijos.
    // Es el mismo código
    // que está implementado en el padre (DefaultVisitor). Por tanto la llamada a
    // 'super.visit' y el
    // resto del código del método hacen lo mismo (por ello 'super.visit' está
    // comentado).
    //
    // - Lo HABITUAL será borrar todo el código de recorrido dejando solo la llamada
    // a 'super.visit'. De esta
    // manera, cada método visit se puede centrar en la tarea que tiene que realizar
    // sobre su nodo del AST
    // (dejando que el padre se encargue del recorrido de los hijos).
    //
    // - La razón de que aparezca el código de recorrido de los hijos es por si se
    // necesita realizar alguna
    // tarea DURANTE el mismo (por ejemplo ir comprobando su tipo). En este caso, ya
    // se tiene implementado
    // dicho recorrido y solo habría que incrustar las acciones adicionales en el
    // mismo. En este caso,
    // es la llamada a 'super.visit' la que debería ser borrada.
    // ---------------------------------------------------------

    // class Program { List<Definition> definition; }
    public Object visit(Program node, Object param) {

	// super.visit(node, param);

	if (node.getDefinition() != null)
	    for (Definition child : node.getDefinition())
		child.accept(this, param);

	return null;
    }

    // class DefVariable { Type type; String name; }
    public Object visit(DefVariable node, Object param) {

	// super.visit(node, param);
	System.out.print("var " + node.getName() + ":");
	if (node.getType() != null)
	    node.getType().accept(this, param);
	System.out.println(";");
	return null;
    }

    /*
    // class DefStruct { String name; List<Definition> definition; }
    public Object visit(DefStruct node, Object param) {

	// super.visit(node, param);
	System.out.print("struct " + node.getName());
	System.out.println("{");
	if (node.getDefinition() != null)
	    for (Definition child : node.getDefinition())
		child.accept(this, param);
	System.out.println("}");
	return null;
    }
    */

    // class DefFuncion { String name; List<Param> param; Type type;
    // List<DefVariable> defvariable; List<Sentence> sentence; }
    public Object visit(DefFuncion node, Object param) {

	// super.visit(node, param);
	System.out.print(node.getName());

	System.out.print("(");
	if (node.getParam() != null) {
	    int aux = 0;
	    for (Param child : node.getParam()) {
		if (aux++ != 0)
		    System.out.print(", ");
		child.accept(this, param);
	    }
	}
	
	System.out.print(")");

	if (node.getType() != null) {
	    System.out.print(":");
	    node.getType().accept(this, param);
	}

	System.out.println("{");
	if (node.getDefvariable() != null)
	    for (DefVariable child : node.getDefvariable())
		child.accept(this, param);

	if (node.getSentence() != null)
	    for (Sentence child : node.getSentence())
		child.accept(this, param);
	System.out.println("}");

	return null;
    }

    // class IntType { }
    public Object visit(IntType node, Object param) {
	System.out.print("int");
	return null;
    }

    // class RealType { }
    public Object visit(RealType node, Object param) {
	System.out.print("float");
	return null;
    }

    // class CharType { }
    public Object visit(CharType node, Object param) {
	System.out.print("char");
	return null;
    }

    // class IdentType { String name; }
    public Object visit(StructType node, Object param) {
	System.out.print(node.getName());
	return null;
    }

    // class ArrayType { String position; Type type; }
    public Object visit(ArrayType node, Object param) {

	// super.visit(node, param);

	System.out.print("[" + node.getPosition() + "]");

	if (node.getType() != null)
	    node.getType().accept(this, param);

	return null;
    }

    // class Param { String name; Type type; }
    public Object visit(Param node, Object param) {

	// super.visit(node, param);
	System.out.print(node.getName() + ":");

	if (node.getType() != null)
	    node.getType().accept(this, param);

	return null;
    }

    // class Print { Expression print; String printType; }
    public Object visit(Print node, Object param) {

	// super.visit(node, param);
	System.out.print("print ");
	if (node.getPrint() != null)
	    node.getPrint().accept(this, param);
	System.out.println(";");
	return null;
    }

    // class Assignment { Expression left; Expression right; }
    public Object visit(Assignment node, Object param) {

	// super.visit(node, param);

	if (node.getLeft() != null)
	    node.getLeft().accept(this, param);

	System.out.print("=");

	if (node.getRight() != null)
	    node.getRight().accept(this, param);
	System.out.println(";");
	return null;
    }

    // class Read { Expression read; }
    public Object visit(Read node, Object param) {

	// super.visit(node, param);
	System.out.print("read ");
	if (node.getRead() != null)
	    node.getRead().accept(this, param);
	System.out.println(";");
	return null;
    }

    // class If { Expression condition; List<Sentence> if_true; List<Sentence>
    // if_false; }
    public Object visit(If node, Object param) {

	// super.visit(node, param);
	System.out.print("if");

	System.out.print("(");
	if (node.getCondition() != null)
	    node.getCondition().accept(this, param);
	System.out.print(")");

	System.out.println("{");
	if (node.getIf_true() != null)
	    for (Sentence child : node.getIf_true())
		child.accept(this, param);
	System.out.println("}");

	if (node.getIf_false() != null) {
	    System.out.print("else");
	    System.out.println("{");
	    for (Sentence child : node.getIf_false())
		child.accept(this, param);
	    System.out.println("}");
	}

	return null;
    }

    // class While { Expression condition; List<Sentence> sentence; }
    public Object visit(While node, Object param) {

	// super.visit(node, param);
	System.out.print("while");

	System.out.print("(");
	if (node.getCondition() != null)
	    node.getCondition().accept(this, param);
	System.out.print(")");

	System.out.println("{");
	if (node.getSentence() != null)
	    for (Sentence child : node.getSentence())
		child.accept(this, param);
	System.out.println("}");

	return null;
    }

    // class FuncCall { String name; List<Expression> expression; }
    public Object visit(FuncCall node, Object param) {

	// super.visit(node, param);
	System.out.print(node.getName());

	System.out.print("(");
	if (node.getExpression() != null)
	    for (Expression child : node.getExpression())
		child.accept(this, param);
	System.out.print(")");

	System.out.println(";");
	return null;
    }

    // class Return { Expression retorno; }
    public Object visit(Return node, Object param) {

	// super.visit(node, param);
	System.out.print("return ");
	if (node.getRetorno() != null)
	    node.getRetorno().accept(this, param);
	System.out.println(";");
	return null;
    }

    // class ExpresionAritmetica { Expression left; String operator; Expression
    // right; }
    public Object visit(ExpresionAritmetica node, Object param) {

	// super.visit(node, param);

	if (node.getLeft() != null)
	    node.getLeft().accept(this, param);

	System.out.print(node.getOperator());

	if (node.getRight() != null)
	    node.getRight().accept(this, param);

	return null;
    }

    // class ExpresionLogica { Expression left; String operator; Expression right; }
    public Object visit(ExpresionLogica node, Object param) {

	// super.visit(node, param);

	if (node.getLeft() != null)
	    node.getLeft().accept(this, param);

	System.out.print(node.getOperator());

	if (node.getRight() != null)
	    node.getRight().accept(this, param);

	return null;
    }

    // class ExpresionCondicion { Expression left; String operator; Expression
    // right; }
    public Object visit(ExpresionCondicion node, Object param) {

	// super.visit(node, param);

	if (node.getLeft() != null)
	    node.getLeft().accept(this, param);

	System.out.print(node.getOperator());

	if (node.getRight() != null)
	    node.getRight().accept(this, param);

	return null;
    }

    // class ExpresionNot { Expression not; }
    public Object visit(ExpresionNot node, Object param) {

	// super.visit(node, param);
	System.out.print("!");
	if (node.getNot() != null)
	    node.getNot().accept(this, param);

	return null;
    }



    // class IntConstant { String value; }
    public Object visit(IntConstant node, Object param) {
	System.out.print(node.getValue());
	return null;
    }

    // class RealConstant { String value; }
    public Object visit(RealConstant node, Object param) {
	System.out.print(node.getValue());
	return null;
    }

    // class CharConstant { String value; }
    public Object visit(CharConstant node, Object param) {
	System.out.print(node.getValue());
	return null;
    }

    // class IdentConstant { String value; }
    public Object visit(IdentConstant node, Object param) {
	System.out.print(node.getValue());
	return null;
    }

    // class Cast { Type type; Expression value; }
    public Object visit(Cast node, Object param) {

	// super.visit(node, param);
	System.out.print("<");
	if (node.getType() != null)
	    node.getType().accept(this, param);
	System.out.print(">");

	System.out.print("(");
	if (node.getValue() != null)
	    node.getValue().accept(this, param);
	System.out.print(")");

	return null;
    }

    // class Array { Expression name; Expression value; }
    public Object visit(Array node, Object param) {

	// super.visit(node, param);

	if (node.getName() != null)
	    node.getName().accept(this, param);
	System.out.print("[");
	if (node.getValue() != null)
	    node.getValue().accept(this, param);
	System.out.print("]");

	return null;
    }

    // class VerStruct { Expression name; String ver; }
    public Object visit(VerStruct node, Object param) {

	// super.visit(node, param);

	if (node.getName() != null) {
	    node.getName().accept(this, param);
	    System.out.print(".");
	}

	return null;
    }

    // class FuncCallExpr { String name; List<Expression> expression; }
    public Object visit(FuncCallExpr node, Object param) {

	// super.visit(node, param);
	System.out.print(node.getName() + "(");
	if (node.getExpression() != null)
	    for (Expression child : node.getExpression())
		child.accept(this, param);
	System.out.print(")");

	return null;
    }
}