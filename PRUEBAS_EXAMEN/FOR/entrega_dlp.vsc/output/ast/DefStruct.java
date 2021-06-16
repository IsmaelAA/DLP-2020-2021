/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	defStruct:definition -> name:String  varstruct:varStruct*

public class DefStruct extends AbstractDefinition {

	public DefStruct(String name, List<VarStruct> varstruct) {
		this.name = name;
		this.varstruct = varstruct;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(varstruct);
	}

	public DefStruct(Object name, Object varstruct) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.varstruct = this.<VarStruct>getAstFromContexts(varstruct);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, varstruct);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<VarStruct> getVarstruct() {
		return varstruct;
	}
	public void setVarstruct(List<VarStruct> varstruct) {
		this.varstruct = varstruct;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<VarStruct> varstruct;

	public String toString() {
       return "{name:" + getName() + ", varstruct:" + getVarstruct() + "}";
   }
}
