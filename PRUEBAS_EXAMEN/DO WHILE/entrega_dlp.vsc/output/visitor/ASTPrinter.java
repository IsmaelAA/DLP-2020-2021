/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import java.io.*;

import ast.*;
import java.util.*;

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *      ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    /**
     * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
     * (línea y columna) de cada nodo.
     *
     * @param sourceFile El fichero del cual se ha obtenido el AST
     * @param raiz       El AST creado a partir de sourceFile
     * @param filename   Nombre del fichero HMTL a crear con la traza del AST
     */

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        toHtml(sourceFile, raiz, filename, 4);
    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    // tabWidth deberían ser los espacios correspondientes a un tabulador en eclipse.
    // Normalmente no sería necesario especificarlo. Usar mejor los dos métodos anteriores.

    public static void toHtml(String sourceFile, AST raiz, String filename, int tabWidth) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"));
            generateHeader(writer);
            writer.println("[ASTPrinter] -------------------------------- line:col  line:col");
            if (raiz != null) {
                ASTPrinter tracer = new ASTPrinter(writer, loadLines(sourceFile, tabWidth));
                raiz.accept(tracer, Integer.valueOf(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[ASTPrinter] --------------------------------");
            generateFooter(writer);
            writer.close();
            System.out.println(ls + "ASTPrinter: Fichero '" + filename
                    + ".html' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "ASTPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static void generateHeader(PrintWriter writer) {
        writer.println("<html>\r\n"
            + "<head>\r\n"
            + "<meta charset=\"utf-8\" />\r\n"
            + "<style type=\"text/css\">\r\n"
            + ".value { font-weight: bold; }\r\n"
            + ".dots { color: #bebdbd; }\r\n"
            + ".type { color: #BBBBBB; }\r\n"
            + ".pos { color: #CCCCCC; }\r\n"
            + ".sourceText { color: #BBBBBB; }\r\n"
            + ".posText {\r\n" + "	color: #BBBBBB;\r\n"
            + "	text-decoration: underline; font-weight: bold;\r\n"
            + "}\r\n"
            + ".null {\r\n"
            + "	color: #FF0000;\r\n"
            + "	font-weight: bold;\r\n"
            + "	font-style: italic;\r\n" + "}\r\n"
            + "</style>\r\n" + "</head>\r\n" + "\r\n"
            + "<body><pre>");
    }

    private static void generateFooter(PrintWriter writer) {
        writer.println("</pre>\r\n" + "</body>\r\n" + "</html>");
    }

    private ASTPrinter(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
    }

    // ----------------------------------------------
	//	class Program { List<Definition> definition; }
	public Object visit(Program node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", node, false);

		visit(indent + 1, "definition", "List<Definition>",node.getDefinition());
		return null;
	}

	//	class DefVariable { Type type;  String name;  String ambito; }
	public Object visit(DefVariable node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DefVariable", node, false);

		visit(indent + 1, "type", "Type",node.getType());
		print(indent + 1, "name", "String", node.getName());
		print(indent + 1, "ambito", "String", node.getAmbito());
		return null;
	}

	//	class DefStruct { String name;  List<VarStruct> varstruct; }
	public Object visit(DefStruct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DefStruct", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "varstruct", "List<VarStruct>",node.getVarstruct());
		return null;
	}

	//	class DefFuncion { String name;  List<Param> param;  Type type;  List<DefVariable> defvariable;  List<Sentence> sentence; }
	public Object visit(DefFuncion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DefFuncion", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "param", "List<Param>",node.getParam());
		visit(indent + 1, "type", "Type",node.getType());
		visit(indent + 1, "defvariable", "List<DefVariable>",node.getDefvariable());
		visit(indent + 1, "sentence", "List<Sentence>",node.getSentence());
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "IntType", node, true);

		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "RealType", node, true);

		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "CharType", node, true);

		return null;
	}

	//	class IdentType { String name; }
	public Object visit(IdentType node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "IdentType", node, "name", node.getName());
		return null;
	}

	//	class ArrayType { String position;  Type type; }
	public Object visit(ArrayType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArrayType", node, false);

		print(indent + 1, "position", "String", node.getPosition());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class Param { String name;  Type type; }
	public Object visit(Param node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Param", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class VarStruct { String name;  Type type; }
	public Object visit(VarStruct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "VarStruct", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class Print { Expression print;  String printType; }
	public Object visit(Print node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Print", node, false);

		visit(indent + 1, "print", "Expression",node.getPrint());
		print(indent + 1, "printType", "String", node.getPrintType());
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Assignment", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class Read { Expression read; }
	public Object visit(Read node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Read", node, false);

		visit(indent + 1, "read", "Expression",node.getRead());
		return null;
	}

	//	class If { Expression condition;  List<Sentence> if_true;  List<Sentence> if_false; }
	public Object visit(If node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "If", node, false);

		visit(indent + 1, "condition", "Expression",node.getCondition());
		visit(indent + 1, "if_true", "List<Sentence>",node.getIf_true());
		visit(indent + 1, "if_false", "List<Sentence>",node.getIf_false());
		return null;
	}

	//	class While { Expression condition;  List<Sentence> sentence; }
	public Object visit(While node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "While", node, false);

		visit(indent + 1, "condition", "Expression",node.getCondition());
		visit(indent + 1, "sentence", "List<Sentence>",node.getSentence());
		return null;
	}

	//	class DoWhile { List<Sentence> sentence;  Expression condition; }
	public Object visit(DoWhile node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "DoWhile", node, false);

		visit(indent + 1, "sentence", "List<Sentence>",node.getSentence());
		visit(indent + 1, "condition", "Expression",node.getCondition());
		return null;
	}

	//	class FuncCall { String name;  List<Expression> expression; }
	public Object visit(FuncCall node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FuncCall", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "expression", "List<Expression>",node.getExpression());
		return null;
	}

	//	class Return { Expression retorno; }
	public Object visit(Return node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Return", node, false);

		visit(indent + 1, "retorno", "Expression",node.getRetorno());
		return null;
	}

	//	class ExpresionAritmetica { Expression left;  String operator;  Expression right; }
	public Object visit(ExpresionAritmetica node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpresionAritmetica", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "operator", "String", node.getOperator());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpresionLogica { Expression left;  String operator;  Expression right; }
	public Object visit(ExpresionLogica node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpresionLogica", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "operator", "String", node.getOperator());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpresionCondicion { Expression left;  String operator;  Expression right; }
	public Object visit(ExpresionCondicion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpresionCondicion", node, false);

		visit(indent + 1, "left", "Expression",node.getLeft());
		print(indent + 1, "operator", "String", node.getOperator());
		visit(indent + 1, "right", "Expression",node.getRight());
		return null;
	}

	//	class ExpresionNot { Expression not; }
	public Object visit(ExpresionNot node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExpresionNot", node, false);

		visit(indent + 1, "not", "Expression",node.getNot());
		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "IntConstant", node, "value", node.getValue());
		return null;
	}

	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "RealConstant", node, "value", node.getValue());
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "CharConstant", node, "value", node.getValue());
		return null;
	}

	//	class IdentConstant { String value; }
	public Object visit(IdentConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "IdentConstant", node, "value", node.getValue());
		return null;
	}

	//	class Cast { Type type;  Expression value; }
	public Object visit(Cast node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Cast", node, false);

		visit(indent + 1, "type", "Type",node.getType());
		visit(indent + 1, "value", "Expression",node.getValue());
		return null;
	}

	//	class Array { Expression name;  Expression value; }
	public Object visit(Array node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Array", node, false);

		visit(indent + 1, "name", "Expression",node.getName());
		visit(indent + 1, "value", "Expression",node.getValue());
		return null;
	}

	//	class VerStruct { Expression name;  String ver; }
	public Object visit(VerStruct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "VerStruct", node, false);

		visit(indent + 1, "name", "Expression",node.getName());
		print(indent + 1, "ver", "String", node.getVer());
		return null;
	}

	//	class FuncCallExpr { String name;  List<Expression> expression; }
	public Object visit(FuncCallExpr node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FuncCallExpr", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "expression", "List<Expression>",node.getExpression());
		return null;
	}


	// -----------------------------------------------------------------
	// Métodos invocados desde los métodos visit -----------------------

	private void printName(int indent, String name, AST node, boolean empty) {
		String text = ls + tabula(indent) + name + " &rarr;  ";
		text = String.format("%1$-" + 93 + "s", text);
		if (empty)
			text = text.replace(name, valueTag(name));
		writer.print(text + getPosition(node));
	}

	private void print(int indent, String name, String type, Object value) {
		write(indent, formatValue(value) + "  " + typeTag(type));
	}

	private void print(int indent, String attName, String type, List<? extends Object> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (Object child : children)
				write(indent + 1, formatValue(child));
		else
			writer.print(" " + valueTag(null));
	}

	// Versión compacta de una linea para nodos que solo tienen un atributo String
	private void printCompact(int indent, String nodeName, AST node, String attName, Object value) {
		String fullName = nodeName + '.' + attName;
		String text = ls + tabula(indent) + '\"' + value + "\"  " + fullName;
		text = String.format("%1$-" + 88 + "s", text);
		// text = text.replace(value.toString(), valueTag(value));
		text = text.replace(fullName, typeTag(fullName));
		writer.print(text + getPosition(node));
	}

	private void visit(int indent, String attName, String type, List<? extends AST> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (AST child : children)
				child.accept(this, indent + 1);
		else
			writer.print(" " + valueTag(null));
	}

	private void visit(int indent, String attName, String type, AST child) {
		if (child != null)
			child.accept(this, Integer.valueOf(indent));
		else
			write(indent, valueTag(null) + "  " + attName + ':' + typeTag(type));
	}

	// -----------------------------------------------------------------
	// Métodos auxiliares privados -------------------------------------

	private void write(int indent, String text) {
		writer.print(ls + tabula(indent) + text);
	}

	private static String tabula(int count) {
		StringBuffer cadena = new StringBuffer("<span class=\"dots\">");
		for (int i = 0; i < count; i++)
			cadena.append(i % 2 == 0 && i > 0 ? "|  " : ".  ");
		return cadena.toString() + "</span>";
	}

	private String typeTag(String type) {
		if (type.equals("String"))
			return "";
		return "<span class=\"type\">" + type.replace("<", "&lt;").replace(">", "&gt;") + "</span>";
	}

	private String valueTag(Object value) {
		if (value == null)
			return "<span class=\"null\">null</span>";
		return "<span class=\"value\">" + value + "</span>";
	}

	private String formatValue(Object value) {
		String text = valueTag(value);
		if (value instanceof String)
			text = "\"" + text + '"';
		return text;
	}


	// -----------------------------------------------------------------
	// Métodos para mostrar las Posiciones -----------------------------

	private String getPosition(AST node) {
		String text = node.getStart() + "  " + node.getEnd();
		text = "<span class=\"pos\">" + String.format("%1$-" + 13 + "s", text) + "</span>";
		text = text.replace("null", "<span class=\"null\">null</span>");
		String sourceText = findSourceText(node);
		if (sourceText != null)
			text += sourceText;
		return text;
	}

	private String findSourceText(AST node) {
		if (sourceLines == null)
			return null;

		Position start = node.getStart();
		Position end = node.getEnd();
		if (start == null || end == null)
			return null;

		String afterText, text, beforeText;
		if (start.getLine() == end.getLine()) {
			String line = sourceLines.get(start.getLine() - 1);
			afterText = line.substring(0, start.getColumn() - 1);
			text = line.substring(start.getColumn() - 1, end.getColumn());
			beforeText = line.substring(end.getColumn());
		} else {
			String firstLine = sourceLines.get(start.getLine() - 1);
			String lastLine = sourceLines.get(end.getLine() - 1);

			afterText = firstLine.substring(0, start.getColumn() - 1);

			text = firstLine.substring(start.getColumn() - 1);
			text += "</span><span class=\"sourceText\">" + " ... " + "</span><span class=\"posText\">";
			text += lastLine.substring(0, end.getColumn()).replaceAll("^\\s+", "");

			beforeText = lastLine.substring(end.getColumn());
		}
		return "<span class=\"sourceText\">" + afterText.replaceAll("^\\s+", "")
				+ "</span><span class=\"posText\">" + text
				+ "</span><span class=\"sourceText\">" + beforeText + "</span>";
	}

	private static List<String> loadLines(String sourceFile, int tabWidth) {
		if (sourceFile == null)
			return null;
		try {
			String spaces = new String(new char[tabWidth]).replace("\0", " ");

			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			while ((line = br.readLine()) != null) {
			//	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
				lines.add(line);
            }
			br.close();
			return lines;
		} catch (FileNotFoundException e) {
			System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		} catch (IOException e) {
			System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		}
	}


	private List<String> sourceLines;
	private static String ls = System.getProperty("line.separator");
	private PrintWriter writer;
}
