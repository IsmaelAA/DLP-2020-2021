/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

public abstract class AbstractExpression extends AbstractAST implements Expression {

    private Type type;
    private boolean modificable;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isModificable() {
        return modificable;
    }

    public void setModificable(Boolean modificable) {
        this.modificable = modificable;
    }
}
