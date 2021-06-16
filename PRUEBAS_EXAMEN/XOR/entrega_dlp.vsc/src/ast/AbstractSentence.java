/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

public abstract class AbstractSentence extends AbstractAST implements Sentence {

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
