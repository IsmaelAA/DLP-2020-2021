/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	if:sentence -> condition:expression  if_true:sentence*  if_false:sentence*

public class If extends AbstractSentence {

	public If(Expression condition, List<Sentence> if_true, List<Sentence> if_false) {
		this.condition = condition;
		this.if_true = if_true;
		this.if_false = if_false;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, if_true, if_false);
	}

	public If(Object condition, Object if_true, Object if_false) {
		this.condition = (Expression) getAST(condition);
		this.if_true = this.<Sentence>getAstFromContexts(if_true);
		this.if_false = this.<Sentence>getAstFromContexts(if_false);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, if_true, if_false);
	}

	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public List<Sentence> getIf_true() {
		return if_true;
	}
	public void setIf_true(List<Sentence> if_true) {
		this.if_true = if_true;
	}

	public List<Sentence> getIf_false() {
		return if_false;
	}
	public void setIf_false(List<Sentence> if_false) {
		this.if_false = if_false;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Sentence> if_true;
	private List<Sentence> if_false;

	public String toString() {
       return "{condition:" + getCondition() + ", if_true:" + getIf_true() + ", if_false:" + getIf_false() + "}";
   }
}
