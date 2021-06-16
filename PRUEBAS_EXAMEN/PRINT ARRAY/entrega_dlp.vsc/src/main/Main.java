package main;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ast.AST;
import codegeneration.CodeGeneration;
import parser.GrammarLexer;
import parser.GrammarParser;
import semantic.SemanticAnalisys;
import visitor.ASTPrinter;

public class Main {
    // public static final String INPUT_FILE = "tests/ejemplo.txt"; // Fichero de
    // prueba
    // durante el desarrollo
//     public static final String INPUT_FILE = "tests/Hipoteca.txt";
    // public static final String INPUT_FILE = "tests/prog2.txt";
    // public static final String INPUT_FILE = "tests/Test de Generación de Código
    // básico.txt";
    public static final String INPUT_FILE = "tests/ArrayAsignacion.txt";
    public static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws Exception {

	// GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(INPUT_FILE));
	//
	// GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
	//
	// parser.start();
	//
	// System.out.println("Compilación Finalizada");

	ErrorManager errorManager = new ErrorManager();

	AST ast = compile(INPUT_FILE, errorManager); // Sustituir "INPUT_FILE" por args[0] en la versión final
	if (errorManager.errorsCount() == 0)
	    System.out.println("El programa se ha compilado correctamente.");

	ASTPrinter.toHtml(INPUT_FILE, ast, "AST"); // Utilidad generada por VGen (opcional)
	// ast.accept(new PrintVisitor(), ast);
    }

    /**
     * Método que coordina todas las fases del compilador
     */
    public static AST compile(String sourceName, ErrorManager errorManager) throws Exception {

	// 1. Fases de Análisis Léxico y Sintáctico
	GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(sourceName));
	GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));

	AST ast = null;

	// IMPORTANTE: Cuando se genere el AST, INTERCAMBIAR las dos líneas siguientes:

	ast = parser.start().ast;
	parser.start();

	if (parser.getNumberOfSyntaxErrors() > 0 || ast == null) { // Hay errores o el AST no se ha implementado aún
	    errorManager.notify("El AST no ha sido creado.");
	    return null;
	}

	// 2. Fase de Análisis Semántico
	SemanticAnalisys analyzer = new SemanticAnalisys(errorManager);
	analyzer.analize(ast);
	if (errorManager.errorsCount() > 0)
	    return ast;

	// 3. Fase de Generación de Código
	File sourceFile = new File(sourceName);
	Writer out = new FileWriter(new File(sourceFile.getParent(), OUTPUT_FILE));

	CodeGeneration generator = new CodeGeneration();
	generator.generate(sourceFile.getName(), ast, out);
	out.close();

	return ast;
    }
}
