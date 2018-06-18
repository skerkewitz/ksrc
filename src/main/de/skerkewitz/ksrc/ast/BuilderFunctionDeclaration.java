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
    var hasParameter = ctx.getChildCount() == 6;

    var ident = (AstExprIdent) builder.visit(ctx.children.get(1));
    AstParameter[] params;
    if (hasParameter) {
      ParseTree tree = ctx.children.get(3);
      final int childCount = tree.getChildCount();

      List<AstParameter> result = new ArrayList<>(childCount);
      for (int i = 0; i < childCount; ++i) {
        ParseTree child = tree.getChild(i);
        if (!(child instanceof TerminalNode)) {
          result.add((AstParameter) builder.visit(child));
        }
      }
      params = result.toArray(new AstParameter[result.size()]);
    } else {
      params = null;
    }

    var expr = (AstStatements) builder.visit(ctx.children.get(hasParameter ? 5 : 2));
    var srcLoc = new SourceLocation(ctx.start, ctx.stop);
    return new AstDeclarationFunction(srcLoc, ident, params, expr);
  }

  static AstNode functionDeclarationParameter(Builder builder, KSrcParser.FunctionParameterContext ctx) {
    var expr = (AstExprIdent) builder.visit(ctx.children.get(0));
    var stmt = (AstTypeIdentifier) builder.visit(ctx.children.get(2));
    return new AstParameter(SourceLocation.fromContext(ctx), expr, stmt);
  }
}
