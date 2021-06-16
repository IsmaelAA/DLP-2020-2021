/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arrayType:type -> position:String  type:type

public class ArrayType extends AbstractType {

	public ArrayType(String position, Type type) {
		this.position = position;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public ArrayType(Object position, Object type) {
		this.position = (position instanceof Token) ? ((Token)position).getText() : (String) position;
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(position, type);
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String position;
	private Type type;

	public String toString() {
       return "{position:" + getPosition() + ", type:" + getType() + "}";
   }
}
