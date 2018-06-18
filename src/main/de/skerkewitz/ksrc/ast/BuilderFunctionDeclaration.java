package de.skerkewitz.ksrc.ast;

import de.skerkewitz.ksrc.antlr.KSrcParser;
import de.skerkewitz.ksrc.antlr.SourceLocation;
import de.skerkewitz.ksrc.ast.nodes.*;
import de.skerkewitz.ksrc.ast.nodes.expr.AstExprIdent;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatements;
import de.skerkewitz.ksrc.ast.nodes.statement.declaration.AstDeclarationFunction;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

class BuilderFunctionDeclaration {

  static AstStatement functionDeclaration(Builder builder, KSrcParser.DeclFuncContext ctx) {
    var srcLoc = new SourceLocation(ctx.start, ctx.stop);

    var hasParameter = ctx.getChild(2) instanceof TerminalNode
            && ctx.getChild(2).getText().equals("(");

    var ident = (AstExprIdent) builder.visit(ctx.children.get(1));
    List<AstParameter> params = new ArrayList<>();
    if (hasParameter) {
      ParseTree tree = ctx.children.get(3);
      final int childCount = tree.getChildCount();

      for (int i = 0; i < childCount; ++i) {
        ParseTree child = tree.getChild(i);
        if (!(child instanceof TerminalNode)) {
          params.add((AstParameter) builder.visit(child));
        }
      }
    }

    /* Derterime if explicit type was given or implicit 'void' should be used. */
    AstTypeIdentifier returnTypeIdentifier = new AstTypeIdentifier(srcLoc, Type.VOID.toString());
    var childCount = ctx.children.size();
    var hasExplicitType = ctx.getChild(childCount - 1) instanceof KSrcParser.CodeBlockContext
                && ctx.getChild(childCount - 2) instanceof TerminalNode
                && ctx.getChild(childCount - 3) instanceof KSrcParser.TypenameContext;
    if (hasExplicitType) {
      returnTypeIdentifier = ((AstTypeIdentifier) builder.visit(ctx.getChild(childCount - 3)));
    }

    var codeBlock = (AstStatements) builder.visit(ctx.getChild(childCount - 1));
    return new AstDeclarationFunction(srcLoc, ident, params, returnTypeIdentifier, codeBlock);
  }

  static AstNode functionDeclarationParameter(Builder builder, KSrcParser.FunctionParameterContext ctx) {
    var expr = (AstExprIdent) builder.visit(ctx.children.get(0));
    var stmt = (AstTypeIdentifier) builder.visit(ctx.children.get(2));
    return new AstParameter(SourceLocation.fromContext(ctx), expr, stmt);
  }
}
