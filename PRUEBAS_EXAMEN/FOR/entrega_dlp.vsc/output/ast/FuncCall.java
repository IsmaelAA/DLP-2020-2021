/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	funcCall:sentence -> name:String  expression:expression*

public class FuncCall extends AbstractSentence {

	public FuncCall(String name, List<Expression> expression) {
		this.name = name;
		this.expression = expression;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public FuncCall(Object name, Object expression) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.expression = this.<Expression>getAstFromContexts(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, expression);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getExpression() {
		return expression;
	}
	public void setExpression(List<Expression> expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Expression> expression;

	public String toString() {
       return "{name:" + getName() + ", expression:" + getExpression() + "}";
   }
}
