/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.DefFuncion;
import ast.DefStruct;
import ast.DefVariable;
import ast.Definition;
import ast.Program;
import ast.Sentence;
import ast.VarStruct;
import visitor.DefaultVisitor;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    /*
     * Poner aquí los visit.
     *
     * Si se ha usado VGen, solo hay que copiarlos de la clase
     * 'visitor/_PlantillaParaVisitors.txt'.
     */

    // public Object visit(Program prog, Object param) {
    // ...
    // }

//	class Program { List<Definition> definition; }
    public Object visit(Program node, Object param) {

	int currentAddress = 0;

	for (Definition child : node.getDefinition()) {
	    if (child instanceof DefVariable) {
		((DefVariable) child).setAddress(currentAddress);
		currentAddress += ((DefVariable) child).getType().getMemSize();
	    }
	    child.accept(this, param);
	}

	return null;
    }

    // class DefStruct { String name; List<VarStruct> varstruct; }
    public Object visit(DefStruct node, Object param) {

	int address = 0;

	if (node.getVarstruct() != null)
	    for (VarStruct child : node.getVarstruct()) {
		child.setAddress(address);
		address += child.getType().getMemSize();
		child.accept(this, param);
	    }

	return null;
    }

    // class DefFuncion { String name; List<Param> param; Type type;
    // List<DefVariable> defvariable; List<Sentence> sentence; }
    public Object visit(DefFuncion node, Object param) {

	// super.visit(node, param);

	if (node.getParam() != null) {
	    int address = 4;
	    for (int i = (node.getParam().size() - 1); i >= 0; i--) {
		node.getParam().get(i).setAddress(address);
		address += node.getParam().get(i).getType().getMemSize();
		node.getParam().get(i).accept(this, param);
	    }
	}

	if (node.getType() != null)
	    node.getType().accept(this, param);

	if (node.getDefvariable() != null) {
	    int address = 0;
	    for (DefVariable child : node.getDefvariable()) {
		address -= child.getType().getMemSize();
		child.setAddress(address);
		child.accept(this, param);
	    }
	}

	if (node.getSentence() != null)
	    for (Sentence child : node.getSentence())
		child.accept(this, param);

	return null;
    }
}
