/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.AST;
import ast.DefFuncion;
import ast.DefStruct;
import ast.DefVariable;
import ast.Definition;
import ast.FuncCall;
import ast.FuncCallExpr;
import ast.IdentConstant;
import ast.Param;
import ast.Position;
import ast.Program;
import ast.StructType;
import ast.VarStruct;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class Identification extends DefaultVisitor {

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	@SuppressWarnings("unused")
	private void error(String msg) {
		error(msg, null);
	}

	private void error(String msg, Position position) {
		errorManager.notify("Identification", msg, position);
	}

	private void predicado(boolean condition, String errorMessage, AST node) {
		if (!condition)
			error(errorMessage, node.getStart());
	}

	private ErrorManager errorManager;
	private TablaVariables variables = new TablaVariables();
	private Map<String, VarStruct> variablesStruct = new HashMap<String, VarStruct>();
	private Map<String, DefFuncion> funciones = new HashMap<String, DefFuncion>();
	private Map<String, DefStruct> structs = new HashMap<String, DefStruct>();

//	class Program { List<Definition> definition; }
	public Object visit(Program node, Object param) {
		if (node.getDefinition() != null)
			for (Definition child : node.getDefinition())
				child.accept(this, param);

		return null;
	}

	// class DefVariable { Type type; String name; }
	public Object visit(DefVariable node, Object param) {
		predicado(variables.getTop(node.getName()) == null, "Variable ya definida: " + node.getName(), node);
		variables.insert(node.getName(), node);
		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	// class DefStruct { String name; List<Definition> definition; }
	public Object visit(DefStruct node, Object param) {
		predicado(structs.get(node.getName()) == null, "Struct ya definido: " + node.getName(), node);
		structs.put(node.getName(), node);

		for (VarStruct child : node.getVarstruct()) {
			child.setDefinicion(node);
			variablesStruct.put(child.getName(), child);

		}
		visitChildren(node.getVarstruct(), param);
		return null;
	}

	// class DefFuncion { String name; List<Param> param; Type type;
	// List<DefVariable> defvariable; List<Sentence> sentence; }
	public Object visit(DefFuncion node, Object param) {
		variables.set();

		predicado(funciones.get(node.getName()) == null, "Función ya definida: " + node.getName(), node);
		funciones.put(node.getName(), node);

		visitChildren(node.getParam(), param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		visitChildren(node.getDefvariable(), param);
		visitChildren(node.getSentence(), param);

		variables.reset();

		return null;
	}

	// class VarStruct { String name; Type type; }
	public Object visit(VarStruct node, Object param) {
		variablesStruct.remove(node.getName(), node);
		predicado(variablesStruct.get(node.getName()) == null, "Variable " + node.getName() + " repetida en el struct",
				node);

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	// class StructType { String name; }
	public Object visit(StructType node, Object param) {
		predicado(structs.get(node.getName()) != null, "Variable no definida: " + node.getName(), node);
		node.setDefinicion(structs.get(node.getName()));
		return null;
	}

	// class Param { String name; Type type; }
	public Object visit(Param node, Object param) {
		DefVariable var = new DefVariable(node.getType(), node.getName(), "param", null);
		var.setParam(node);
		predicado(variables.getTop(node.getName()) == null, "Parametro repetido: " + node.getName(), node);

		variables.insert(node.getName(), var);
		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	// class IdentConstant { String value; }
	public Object visit(IdentConstant node, Object param) {
		predicado(variables.get(node.getValue()) != null, "Variable no definida: " + node.getValue(), node);
		node.setDefinicion((DefVariable) variables.get(node.getValue()));
		return null;
	}

//	class FuncCallExpr { String name;  List<Expression> expression; }
	public Object visit(FuncCallExpr node, Object param) {

		predicado(funciones.get(node.getName()) != null, "Funcion no definida: " + node.getName(), node);
		node.setDefinicion(funciones.get(node.getName()));
		visitChildren(node.getExpression(), param);

		return null;
	}

//	class FuncCall { String name;  List<Expression> expression; }
	public Object visit(FuncCall node, Object param) {

		predicado(funciones.get(node.getName()) != null, "Procedimiento no definido: " + node.getName(), node);
		node.setDefinicion(funciones.get(node.getName()));
		visitChildren(node.getExpression(), param);

		return null;
	}

}
