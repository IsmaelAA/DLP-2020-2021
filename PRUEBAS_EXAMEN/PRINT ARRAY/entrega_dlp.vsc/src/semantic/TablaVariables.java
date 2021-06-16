package semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ast.Definition;

public class TablaVariables {

    private Stack<Map<String, Definition>> tabla;

    public TablaVariables() {
	tabla = new Stack<Map<String, Definition>>();
	set();
    }

    public void set() {
	tabla.push(new HashMap<String, Definition>());
    }

    public void reset() {
	tabla.pop();

    }

    public void insert(String nombre, Definition definition) {
	tabla.peek().put(nombre, definition);

    }

    public Definition getTop(String id) {
	return tabla.peek().get(id);
    }

    public Definition get(String id) {
	for (int i = tabla.size() - 1; i >= 0; i--) {
	    Map<String, Definition> ambito = tabla.get(i);
	    Definition def = ambito.get(id);
	    if (def != null)
		return def;
	}
	return null;
    }

}
