/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	array:expression -> name:expression  value:expression

public class Array extends AbstractExpression {

	public Array(Expression name, Expression value) {
		this.name = name;
		this.value = value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, value);
	}

	public Array(Object name, Object value) {
		this.name = (Expression) getAST(name);
		this.value = (Expression) getAST(value);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, value);
	}

	public Expression getName() {
		return name;
	}
	public void setName(Expression name) {
		this.name = name;
	}

	public Expression getValue() {
		return value;
	}
	public void setValue(Expression value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression name;
	private Expression value;

	public String toString() {
       return "{name:" + getName() + ", value:" + getValue() + "}";
   }
}
