package de.skerkewitz.ksrc;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TestListener implements ParseTreeListener {

//  @Override
//  public void enterDeclarationFunction(KSrcParser.DeclarationFunctionContext ctx) {
//    System.out.print("Enter " + ctx.function_declaration().identifier().NAME().getText());
//    super.enterDeclarationFunction(ctx);
//
//  }





  @Override
  public void visitTerminal(TerminalNode node) {

  }

  @Override
  public void visitErrorNode(ErrorNode node) {

  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
      System.out.println("Enter " + ctx.getText());
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {

  }
}
