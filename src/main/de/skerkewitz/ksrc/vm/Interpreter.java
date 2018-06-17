package de.skerkewitz.ksrc.vm;

import de.skerkewitz.ksrc.ast.AstExpr;
import de.skerkewitz.ksrc.ast.AstStatement;
import de.skerkewitz.ksrc.ast.AstStatementDeclFunc;

import java.util.HashMap;
import java.util.Map;

/** A vm for the Ast nodes. */
public interface Interpreter {

	interface VmFunc {
	}

	/** Allows to implement build in functions. */
	interface VmFuncBuildIn extends VmFunc {
		String exec(Interpreter vm, AstExpr[] args, VmExecContext execContext);
	}

	/** Allows to implement build in functions. */
	class VmFuncRef implements VmFunc {
		public final AstStatementDeclFunc funcRef;

		public VmFuncRef(AstStatementDeclFunc funcRef) {
			this.funcRef = funcRef;
		}
	}

	final class VmExecContext {

		/** The parent is always readonly. If null then this is the global layer. */
		private final VmExecContext parent;

		private final Map<String, String> symbolTable = new HashMap<>();
		private final Map<String, VmFunc> funcTable = new HashMap<>();

		public VmExecContext(VmExecContext parent) {
			this.parent = parent;
		}

		public String getSymbolByName(String name) {
			var symbol = this.symbolTable.get(name);
			if (symbol != null) {
			  return symbol;
			}

			if (parent != null) {
			  return parent.getSymbolByName(name);
			}

			throw new VmUnknownSymbol(name);
		}

		public void declareSymbol(String name, String value) {
			if (this.symbolTable.containsKey(name)) {
			  throw new VmSymbolAlreadyDeclared(name);
			}

			this.symbolTable.put(name, value);
		}

	  public VmFunc getFuncByName(String name) {
		var symbol = this.funcTable.get(name);
		if (symbol != null) {
		  return symbol;
		}

		if (parent != null) {
		  return parent.getFuncByName(name);
		}

		throw new VmUnknownSymbol(name);
	  }

	  public void declareFunc(String name, VmFunc func) {
		if (this.funcTable.containsKey(name)) {
		  throw new VmSymbolAlreadyDeclared(name);
		}

		this.funcTable.put(name, func);
	  }

	}

	/**
	 * Evaluates the given expression and returns the value.
	 * @param expression the {@link AstExpr} to evaluate
	 *
	 * @return the String value of the evaluated expression.
	 */
	String eval(AstExpr expression, VmExecContext execContext);


	/**
	 * Execute the given statement.
	 *
	 * @param statement the {@link AstStatement} to execute.
	 * @return
	 */
	String exec(AstStatement statement, VmExecContext execContext);

}
