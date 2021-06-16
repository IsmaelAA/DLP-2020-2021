/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	verStruct:expression -> name:expression  ver:String

public class VerStruct extends AbstractExpression {

	public VerStruct(Expression name, String ver) {
		this.name = name;
		this.ver = ver;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name);
	}

	public VerStruct(Object name, Object ver) {
		this.name = (Expression) getAST(name);
		this.ver = (ver instanceof Token) ? ((Token)ver).getText() : (String) ver;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, ver);
	}

	public Expression getName() {
		return name;
	}
	public void setName(Expression name) {
		this.name = name;
	}

	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression name;
	private String ver;

	public String toString() {
       return "{name:" + getName() + ", ver:" + getVer() + "}";
   }
}
