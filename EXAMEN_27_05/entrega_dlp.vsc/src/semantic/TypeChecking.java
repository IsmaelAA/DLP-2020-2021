/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	// # ----------------------------------------------------------
	/*
	 * Poner aquí los visit.
	 *
	 * Si se ha usado VGen, solo hay que copiarlos de la clase
	 * 'visitor/_PlantillaParaVisitors.txt'.
	 */

	// public Object visit(Program prog, Object param) {
	// ...
	// }

	// ...
	// ...
	// ...

	// # ----------------------------------------------------------
	// Métodos auxiliares recomendados (opcionales) -------------

	/**
	 * predicado. Método auxiliar para implementar los predicados. Borrar si no se
	 * quiere usar.
	 *
	 * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
	 *
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * primitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
	 * expresión debe ser de un tipo primitivo", expr); // Se asume getStart() 3.
	 * predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * primitivo");
	 *
	 * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero
	 * fuente donde estaba el nodo (y así poder dar información más detallada de
	 * la posición del error). Si se usa VGen, dicho método habrá sido generado
	 * en todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo
	 * 2), ya que si se pasa el nodo, se usará por defecto dicha posición. Si no
	 * se quiere imprimir la posición del fichero, se puede omitir el tercer
	 * argumento (ejemplo 3).
	 *
	 * @param condition     Debe cumplirse para que no se produzca un error
	 * @param errorMessage  Se imprime si no se cumple la condición
	 * @param posicionError Fila y columna del fichero donde se ha producido el
	 *                      error.
	 */

	// class DefFuncion { String name; List<Param> param; Type type;
	// List<DefVariable> defvariable; List<Sentence> sentence; }
	public Object visit(DefFuncion node, Object param) {

		// super.visit(node, param);

		// Set de la funcion en la que se define.

		for (Sentence child : node.getSentence()) {
			child.setFunction(node);
		}

		// Comprueba que el tipo es el correcto
		if (node.getParam() != null)
			for (Param child : node.getParam()) {
				child.accept(this, param);
				predicado(isSimple(child.getType()), "Los parametros deben de ser de tipo primitivo", node);
			}

		// Comprueba que el tipo de retorno es el correcto
		if (node.getType() != null) {
			node.getType().accept(this, param);
			predicado(isSimple(node.getType()), "El tipo de retorno debe de ser primitivo", node);
		}

		visitChildren(node.getDefvariable(), param);
		visitChildren(node.getSentence(), param);

		return null;
	}

	// class DefVariable { Type type; String name; String ambito; Expression
	// expression; }
	public Object visit(DefVariable node, Object param) {

		// super.visit(node, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getExpression() != null) {
			node.getExpression().accept(this, param);

			predicado(node.getExpression().getType() != null, "Error, no se puede asignar a una expresion de tipo void",
					node);

			if (node.getExpression().getType() != null) {
				predicado(node.getType().getSufijo() == node.getExpression().getType().getSufijo(),
						"Error, el tipo de la asignacion no coincide.", node);
			}

			predicado(node.getAmbito() == "local", "Error, Solo se pueden inicializar variables locales.", node);

			predicado(isSimple(node.getType()), "Error, El tipo de la asignacion debe de ser simple.", node);

		}

		return null;
	}

	// class Print { Expression print; String printType; }
	public Object visit(Print node, Object param) {

		// super.visit(node, param);

		if (node.getPrint() != null)
			node.getPrint().accept(this, param);

		// Comprueba que el tipo es el correcto
		predicado(isSimple(node.getPrint().getType()), "Error, el print debe de ser tipo primitivo", node);
		return null;
	}

	// class Assignment { Expression left; Expression right; }
	public Object visit(Assignment node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		predicado(isSameType(node.getLeft().getType(), node.getRight().getType()),
				"Error, no es posible asignar,las expresiones son de distinto tipo", node);
		predicado(node.getLeft().isModificable(),
				"Error, no es posible asignar, la expresion de la izquierda no es modificable", node);
		predicado(isSimple(node.getLeft().getType()),
				"Error, no es posible asignar, la expresion de la izquierda debe de ser tipo primitivo", node);

		return null;
	}

	// class Read { Expression read; }
	public Object visit(Read node, Object param) {

		// super.visit(node, param);

		if (node.getRead() != null)
			node.getRead().accept(this, param);

		predicado(isSimple(node.getRead().getType()), "Error, debe ser un tipo primitivo", node);
		predicado(node.getRead().isModificable(), "Error, debe ser modificable", node);
		return null;
	}

	// class If { Expression condition; List<Sentence> if_true; List<Sentence>
	// if_false; }
	public Object visit(If node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		predicado(node.getCondition().getType() instanceof IntType, "Error, la condicion debe de ser de tipo entero",
				node);

		if (node.getIf_true() != null)
			for (Sentence child : node.getIf_true()) {
				child.setFunction(node.getFunction());
				child.accept(this, param);
			}

		if (node.getIf_false() != null)
			for (Sentence child : node.getIf_false()) {
				child.setFunction(node.getFunction());
				child.accept(this, param);
			}

		return null;
	}

	// class While { Expression condition; List<Sentence> sentence; }
	public Object visit(While node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		predicado(node.getCondition().getType() instanceof IntType, "Error, la condicion debe de ser de tipo entero",
				node);

		if (node.getSentence() != null)
			for (Sentence child : node.getSentence()) {
				child.setFunction(node.getFunction());
				child.accept(this, param);
			}

		return null;
	}

	// class FuncCall { String name; List<Expression> expression; }
	public Object visit(FuncCall node, Object param) {

		// super.visit(node, param);
		visitChildren(node.getExpression(), param);

		// Comprueba que el numero de parametros coincide
		predicado(node.getExpression().size() == node.getDefinicion().getParam().size(),
				"Error, se esperaban " + node.getDefinicion().getParam().size() + " argumentos" + node);

		// Comprueba que el tipo de los parametros coincide
		if (node.getExpression().size() == node.getFunction().getParam().size())
			for (int i = 0; i < node.getExpression().size(); i++) {
				predicado(
						isSameType(node.getExpression().get(i).getType(),
								node.getFunction().getParam().get(i).getType()),
						"Error, el tipo de los parametros no coincide", node);
			}

		return null;
	}

	// class Return { Expression retorno; }
	public Object visit(Return node, Object param) {

		// super.visit(node, param);

		if (node.getRetorno() != null)
			node.getRetorno().accept(this, param);

		if (node.getFunction().getType() == null) {
			predicado(node.getRetorno() == null, "Error, la expresion return no puede tener expresiones tipo null/void",
					node);
		} else {
			predicado(node.getRetorno() != null, "Error, valor de retorno necesario", node);

			if (node.getRetorno() != null) {
				predicado(isSameType(node.getRetorno().getType(), node.getFunction().getType()),
						"Error, el tipo de retorno no coincide", node);
			}
		}

		return null;
	}

	// class ExpresionAritmetica { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpresionAritmetica node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		predicado(node.getLeft().getType() instanceof IntType || node.getLeft().getType() instanceof RealType,
				"Erro, los operandos deben ser tipo entero o real", node);

		predicado(isSameType(node.getLeft().getType(), node.getRight().getType()),
				"Error, los operandos deben de ser del mismo tipo", node);

		node.setType(node.getLeft().getType());
		node.setModificable(false);

		return null;
	}

	// class ExpresionLogica { Expression left; String operator; Expression right; }
	public Object visit(ExpresionLogica node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		predicado(
				(node.getLeft().getType() instanceof IntType)
						&& isSameType(node.getLeft().getType(), node.getRight().getType()),
				"Error, los operandos deben de ser de tipo entero", node);

		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	// class ExpresionCondicion { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpresionCondicion node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		predicado(node.getLeft().getType() instanceof IntType || node.getLeft().getType() instanceof RealType,
				"Error, los operandos deben de ser de tipo entero o real", node);
		predicado(isSameType(node.getLeft().getType(), node.getRight().getType()),
				"Error, los operandos deben de ser del mismo tipo", node);

		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	// class ExpresionNot { Expression not; }
	public Object visit(ExpresionNot node, Object param) {

		// super.visit(node, param);

		if (node.getNot() != null)
			node.getNot().accept(this, param);

		predicado(node.getType() instanceof IntType, "Error, la expresion debe de ser de tipo entero", node);

		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	// class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		node.setModificable(false);
		node.setType(new IntType());
		return null;
	}

	// class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		node.setModificable(false);
		node.setType(new RealType());
		return null;
	}

	// class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		node.setModificable(false);
		node.setType(new CharType());
		return null;
	}

	// class IdentConstant { String value; }
	public Object visit(IdentConstant node, Object param) {
		node.setModificable(true);
		node.setType(node.getDefinicion().getType());
		return null;
	}

	// class Cast { Type type; Expression value; }
	public Object visit(Cast node, Object param) {

		super.visit(node, param);

		node.setModificable(false);
		predicado(!isSameType(node.getType(), node.getValue().getType()), "Error, no es posible castear al mismo tipo",
				node);
		predicado(isSimple(node.getType()), "Error, no es posible hacer cast a tipos complejos", node.getStart());
		predicado(isSimple(node.getValue().getType()), "Error, no es posible hacer cast de tipos complejos",
				node.getStart());

		return null;
	}

	// class Array { Expression name; Expression value; }
	public Object visit(Array node, Object param) {

		// super.visit(node, param);

		if (node.getName() != null)
			node.getName().accept(this, param);

		if (node.getValue() != null)
			node.getValue().accept(this, param);

		predicado(node.getName().getType() instanceof ArrayType, "Error, tipo array requerido", node);
		if (node.getName().getType() instanceof ArrayType) {
			predicado(node.getValue().getType() instanceof IntType, "Error, el indice debe ser entero", node);
			node.setType(((ArrayType) node.getName().getType()).getType());
		}
		node.setModificable(true);

		return null;
	}

	// class VerStruct { Expression name; String ver; }
	public Object visit(VerStruct node, Object param) {

		super.visit(node, param);

		predicado(node.getName().getType() instanceof StructType, "Error, tipo de struct necesario", node);
		node.setModificable(true);

		if (node.getName().getType() instanceof StructType) {
			StructType st = (StructType) node.getName().getType();
			DefStruct s = (DefStruct) st.getDefinicion();
			for (VarStruct c : s.getVarstruct()) {
				if (c.getName().equals(node.getVer())) {
					node.setType(c.getType());
				}
			}

			predicado(node.getType() != null, "Error, variable no definida", node.getStart());
		}
		return null;
	}

	// class FuncCallExpr { String name; List<Expression> expression; }
	public Object visit(FuncCallExpr node, Object param) {

		// super.visit(node, param);
		visitChildren(node.getExpression(), param);

		predicado(node.getDefinicion().getType() != null, "Error, la funcion no tiene tipo de retorno", node);

		predicado(node.getExpression().size() == node.getDefinicion().getParam().size(),
				"Error, se esperaban " + node.getDefinicion().getParam().size() + " argumentos", node);

		if (node.getExpression().size() == node.getDefinicion().getParam().size())
			for (int i = 0; i < node.getExpression().size(); i++) {
				predicado(
						isSameType(node.getExpression().get(i).getType(),
								node.getDefinicion().getParam().get(i).getType()),
						"Error, el tipo de los parametros no coincide", node);
			}

		node.setType(node.getDefinicion().getType());
		node.setModificable(false);
		return null;
	}

	//////////////////////////////////////////////////
	// Funciones auxiliares
	//////////////////////////////////////////////////

	private void predicado(boolean condition, String errorMessage, AST node) {
		predicado(condition, errorMessage, node.getStart());
	}

	private void predicado(boolean condition, String errorMessage, Position position) {
		if (!condition)
			errorManager.notify("Type Checking", errorMessage, position);
	}

	private void predicado(boolean condition, String errorMessage) {
		predicado(condition, errorMessage, (Position) null);
	}

	private boolean isSimple(Type type) {
		return type instanceof IntType || type instanceof RealType || type instanceof CharType;
	}

	private boolean isSameType(Type type1, Type type2) {
		return type1 != null && type2 != null ? type1.getClass().isAssignableFrom(type2.getClass()) : false;
	}

	private ErrorManager errorManager;
}
