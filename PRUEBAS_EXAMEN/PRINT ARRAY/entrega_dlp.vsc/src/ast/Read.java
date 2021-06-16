/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	read:sentence -> read:expression

public class Read extends AbstractSentence {

	public Read(Expression read) {
		this.read = read;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(read);
	}

	public Read(Object read) {
		this.read = (Expression) getAST(read);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(read);
	}

	public Expression getRead() {
		return read;
	}
	public void setRead(Expression read) {
		this.read = read;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression read;

	public String toString() {
       return "{read:" + getRead() + "}";
   }

   
}
