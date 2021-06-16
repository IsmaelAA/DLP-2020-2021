/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expresionNot:expression -> not:expression

public class ExpresionNot extends AbstractExpression {

	public ExpresionNot(Expression not) {
		this.not = not;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(not);
	}

	public ExpresionNot(Object not) {
		this.not = (Expression) getAST(not);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(not);
	}

	public Expression getNot() {
		return not;
	}
	public void setNot(Expression not) {
		this.not = not;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression not;

	public String toString() {
       return "{not:" + getNot() + "}";
   }
}
