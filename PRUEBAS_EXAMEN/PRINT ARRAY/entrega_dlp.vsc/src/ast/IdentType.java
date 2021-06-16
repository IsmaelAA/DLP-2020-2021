/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	identType:type -> name:String

public class IdentType extends AbstractType {

    public IdentType(String name) {
	this.name = name;
    }

    public IdentType(Object name) {
	this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

	// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
	// Obtiene la linea/columna a partir de las de los hijos.
	setPositions(name);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public Object accept(Visitor v, Object param) {
	return v.visit(this, param);
    }

    private String name;

    public String toString() {
	return "{name:" + getName() + "}";
    }

    public DefStruct getDefinicion() {
	return definition;
    }

    public void setDefinicion(DefStruct definition) {
	this.definition = definition;
    }

    private DefStruct definition;

    @Override
    public int getMemSize() {
	int memSize = 0;
	for (VarStruct var : definition.getVarstruct()) {
	    memSize += var.getType().getMemSize();
	}
	return memSize;
    }

    @Override
    public String getNombreMAPL() {
        return getName();
    }

    @Override
    public char getSufijo() {
        return 0;
    }
}
