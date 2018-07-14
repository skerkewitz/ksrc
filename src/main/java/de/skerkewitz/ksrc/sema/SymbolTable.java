package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.nodes.AstNode;

import java.util.HashMap;
import java.util.Map;

public final class SymbolTable<T> {

  private final Map<String, T> symbolTable; // Can only contain unique symbols.
  public final SymbolTable<T> parent;

  public SymbolTable(Map<String, T> symbolTable, SymbolTable<T> parent) {
    this.symbolTable = symbolTable;
    this.parent = parent;
  }

  public SymbolTable(SymbolTable parent) {
    this(new HashMap<>(), parent);
  }

  public SymbolTable() {
    this(new HashMap<>(), null);
  }

  public T getSymbolByName(String name) {
    T vmDescriptor = this.symbolTable.get(name);
    if (vmDescriptor != null) {
      return vmDescriptor;
    }

    T returnDescriptor = parent != null ? parent.getSymbolByName(name) : null;
    if (returnDescriptor == null) {
      System.out.println("Could no find descriptor for symbol '" + name + "'");
    }
    return returnDescriptor;
  }

  public void declareSymbol(String name, T symbolValue, AstNode node) {
    if (symbolValue == null) {
      throw new IllegalArgumentException("symbolValue can not be null");
    }

    if (this.symbolTable.containsKey(name)) {
      T symbolByName = getSymbolByName(name);
      if (!symbolByName.equals(symbolValue)) {
        throw new Sema.SemaException(node, "Invalid type redeclaration of symbol '" + name + "' from " + symbolByName + " to " + symbolValue);
      }
    }

    this.symbolTable.put(name, symbolValue);
  }

  public void redeclareSymbol(String name, T symbolValue, AstNode node) {
    if (symbolValue == null) {
      throw new IllegalArgumentException("symbolValue can not be null");
    }

    if (this.symbolTable.containsKey(name)) {
      this.symbolTable.put(name, symbolValue);
      return;
    }

    if (parent != null) {
      parent.redeclareSymbol(name, symbolValue, node);
      return;
    }

    throw new Sema.SemaException(node, "Invalid type redeclaration of unknown symbol '" + name + "' to " + symbolValue);
}

  /**
   * Create a new scope by returning new table and setting this table as the parent.
   */
  public SymbolTable<T> createNewScope() {
    return new SymbolTable<>(this);
  }
}
