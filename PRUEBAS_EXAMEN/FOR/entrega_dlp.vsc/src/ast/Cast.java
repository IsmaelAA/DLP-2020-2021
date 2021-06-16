/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	cast:expression -> type:type  value:expression

public class Cast extends AbstractExpression {

	public Cast(Type type, Expression value) {
		this.type = type;
		this.value = value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type, value);
	}

	public Cast(Object type, Object value) {
		this.type = (Type) getAST(type);
		this.value = (Expression) getAST(value);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type, value);
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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

	private Type type;
	private Expression value;

	public String toString() {
       return "{type:" + getType() + ", value:" + getValue() + "}";
   }
}
