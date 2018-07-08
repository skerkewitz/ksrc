package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

import java.util.HashMap;
import java.util.Map;

public final class SymbolTable {

    private final Map<String, VmDescriptor> symbolTable;

    public SymbolTable(Map<String, VmDescriptor> symbolTable) {
      this.symbolTable = symbolTable;
    }

    public SymbolTable() {
      this(new HashMap<>());
    }
  //    private final Map<String, VmMethodDescriptor> funcTable = new HashMap<>();
//    private final Map<String, Vm.ClassRef> classTable = new HashMap<>();

    public VmDescriptor getSymbolByName(String name) {
        return this.symbolTable.get(name);
    }

    public void declareSymbol(String name, VmDescriptor descriptor, AstNode node) {
        if (descriptor == null) {
          throw new IllegalArgumentException("descriptor can not be null");
        }

        if (this.symbolTable.containsKey(name)) {
          VmDescriptor symbolByName = getSymbolByName(name);
          if (!symbolByName.equals(descriptor)) {
            throw new Sema.SemaException(node, "Invalid type redeclaration of symbol '" + name + "' from " + symbolByName + " to " + descriptor);
          }
        }

        this.symbolTable.put(name, descriptor);
    }
}
