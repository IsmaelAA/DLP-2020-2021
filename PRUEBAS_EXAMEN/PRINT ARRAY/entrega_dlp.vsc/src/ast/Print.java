/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	print:sentence -> print:expression  printType:String

public class Print extends AbstractSentence {

	public Print(Expression print, String printType) {
		this.print = print;
		this.printType = printType;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(print);
	}

	public Print(Object print, Object printType) {
		this.print = (Expression) getAST(print);
		this.printType = (printType instanceof Token) ? ((Token)printType).getText() : (String) printType;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(print, printType);
	}

	public Expression getPrint() {
		return print;
	}
	public void setPrint(Expression print) {
		this.print = print;
	}

	public String getPrintType() {
		return printType;
	}
	public void setPrintType(String printType) {
		this.printType = printType;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression print;
	private String printType;

	public String toString() {
       return "{print:" + getPrint() + ", printType:" + getPrintType() + "}";
   }

   private DefFuncion defFunction;

	@Override
	public void setFunction(DefFuncion function) {
		this.defFunction = function;

	}

	@Override
	public DefFuncion getFunction() {

		return defFunction;
	}
}
