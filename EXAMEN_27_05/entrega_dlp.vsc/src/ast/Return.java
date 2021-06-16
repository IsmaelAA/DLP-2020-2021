/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	return:sentence -> retorno:expression

public class Return extends AbstractSentence {

	public Return(Expression retorno) {
		this.retorno = retorno;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(retorno);
	}

	public Return(Object retorno) {
		this.retorno = (Expression) getAST(retorno);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(retorno);
	}

	public Expression getRetorno() {
		return retorno;
	}
	public void setRetorno(Expression retorno) {
		this.retorno = retorno;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression retorno;

	public String toString() {
       return "{retorno:" + getRetorno() + "}";
   }
}
