package ui;

// import davidmayer.Program;
import ast.Program;
import evaluator.Evaluator;
import gamemaker.EZGameBuilder;
import org.antlr.v4.runtime.*;
import parser.*;

import java.io.IOException;

// Inspired by tinyHTML: https://github.students.cs.ubc.ca/CPSC410-2024W-T2/tinyHTML
public class Main {
    public static void main(String[] args) throws IOException {
        EZGameLexer lexer = new EZGameLexer(CharStreams.fromFileName("input.ezgame"));
        TokenStream tokens = new CommonTokenStream(lexer);
        EZGameParser parser = new EZGameParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());

        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());
        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();
        parsedProgram.accept(builder, evaluator);

        new EZGameWindow(builder);
    }
}