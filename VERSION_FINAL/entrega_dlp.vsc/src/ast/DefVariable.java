/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	defVariable:definition -> type:type  name:String  ambito:String

public class DefVariable extends AbstractDefinition {

    public DefVariable(Type type, String name, String ambito) {
	this.type = type;
	this.name = name;
	this.ambito = ambito;

	// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
	// Obtiene la linea/columna a partir de las de los hijos.
	setPositions(type);
    }

    public DefVariable(Object type, Object name, Object ambito) {
	this.type = (Type) getAST(type);
	this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
	this.ambito = (ambito instanceof Token) ? ((Token) ambito).getText() : (String) ambito;

	// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
	// Obtiene la linea/columna a partir de las de los hijos.
	setPositions(type, name, ambito);
    }

    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAmbito() {
	return ambito;
    }

    public void setAmbito(String ambito) {
	this.ambito = ambito;
    }

    @Override
    public Object accept(Visitor v, Object param) {
	return v.visit(this, param);
    }

    private Type type;
    private String name;
    private String ambito;

    public String toString() {
	return "{type:" + getType() + ", name:" + getName() + ", ambito:" + getAmbito() + "}";
    }

    private Param param;

    public void setParam(Param node) {
	this.param = node;
    }

    public Param getParametro() {
	return param;
    }

    private int address;

    public void setAddress(int address) {
	this.address = address;
    }

    public int getAddress() {
	return this.address;
    }
}
