/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import visitor.*;

//	program -> definition:definition*

public class Program extends AbstractAST  {

	public Program(List<Definition> definition) {
		this.definition = definition;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definition);
	}

	public Program(Object definition) {
		this.definition = this.<Definition>getAstFromContexts(definition);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definition);
	}

	public List<Definition> getDefinition() {
		return definition;
	}
	public void setDefinition(List<Definition> definition) {
		this.definition = definition;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Definition> definition;

	public String toString() {
       return "{definition:" + getDefinition() + "}";
   }
}
