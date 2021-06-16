/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	for:sentence -> sentencia:sentence  condition:expression  step:sentence  sentence:sentence*

public class For extends AbstractSentence {

	public For(Sentence sentencia, Expression condition, Sentence step, List<Sentence> sentence) {
		this.sentencia = sentencia;
		this.condition = condition;
		this.step = step;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(sentencia, condition, step, sentence);
	}

	public For(Object sentencia, Object condition, Object step, Object sentence) {
		this.sentencia = (Sentence) getAST(sentencia);
		this.condition = (Expression) getAST(condition);
		this.step = (Sentence) getAST(step);
		this.sentence = this.<Sentence>getAstFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(sentencia, condition, step, sentence);
	}

	public Sentence getSentencia() {
		return sentencia;
	}
	public void setSentencia(Sentence sentencia) {
		this.sentencia = sentencia;
	}

	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public Sentence getStep() {
		return step;
	}
	public void setStep(Sentence step) {
		this.step = step;
	}

	public List<Sentence> getSentence() {
		return sentence;
	}
	public void setSentence(List<Sentence> sentence) {
		this.sentence = sentence;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Sentence sentencia;
	private Expression condition;
	private Sentence step;
	private List<Sentence> sentence;

	public String toString() {
       return "{sentencia:" + getSentencia() + ", condition:" + getCondition() + ", step:" + getStep() + ", sentence:" + getSentence() + "}";
   }
}
