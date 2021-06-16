/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	doWhile -> sentence:sentence*  condition:expression

public class DoWhile extends AbstractSentence {

    public DoWhile(List<Sentence> sentence, Expression condition) {
	this.sentence = sentence;
	this.condition = condition;

	// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
	// Obtiene la linea/columna a partir de las de los hijos.
	setPositions(sentence, condition);
    }

    public DoWhile(Object sentence, Object condition) {
	this.sentence = this.<Sentence>getAstFromContexts(sentence);
	this.condition = (Expression) getAST(condition);

	// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
	// Obtiene la linea/columna a partir de las de los hijos.
	setPositions(sentence, condition);
    }

    public List<Sentence> getSentence() {
	return sentence;
    }

    public void setSentence(List<Sentence> sentence) {
	this.sentence = sentence;
    }

    public Expression getCondition() {
	return condition;
    }

    public void setCondition(Expression condition) {
	this.condition = condition;
    }

    @Override
    public Object accept(Visitor v, Object param) {
	return v.visit(this, param);
    }

    private List<Sentence> sentence;
    private Expression condition;

    public String toString() {
	return "{sentence:" + getSentence() + ", condition:" + getCondition() + "}";
    }

}
