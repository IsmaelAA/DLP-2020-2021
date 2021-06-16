/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	defFuncion:definition -> name:String  param:param*  type:type  defvariable:defVariable*  sentence:sentence*

public class DefFuncion extends AbstractDefinition {

	public DefFuncion(String name, List<Param> param, Type type, List<DefVariable> defvariable, List<Sentence> sentence) {
		this.name = name;
		this.param = param;
		this.type = type;
		this.defvariable = defvariable;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(param, type, defvariable, sentence);
	}

	public DefFuncion(Object name, Object param, Object type, Object defvariable, Object sentence) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.param = this.<Param>getAstFromContexts(param);
		this.type = (Type) getAST(type);
		this.defvariable = this.<DefVariable>getAstFromContexts(defvariable);
		this.sentence = this.<Sentence>getAstFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, param, type, defvariable, sentence);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Param> getParam() {
		return param;
	}
	public void setParam(List<Param> param) {
		this.param = param;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public List<DefVariable> getDefvariable() {
		return defvariable;
	}
	public void setDefvariable(List<DefVariable> defvariable) {
		this.defvariable = defvariable;
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

	private String name;
	private List<Param> param;
	private Type type;
	private List<DefVariable> defvariable;
	private List<Sentence> sentence;

	public String toString() {
       return "{name:" + getName() + ", param:" + getParam() + ", type:" + getType() + ", defvariable:" + getDefvariable() + ", sentence:" + getSentence() + "}";
   }
}
