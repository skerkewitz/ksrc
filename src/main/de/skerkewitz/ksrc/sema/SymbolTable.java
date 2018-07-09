package de.skerkewitz.ksrc.sema;

import de.skerkewitz.ksrc.ast.nodes.AstNode;
import de.skerkewitz.ksrc.vm.descriptor.VmDescriptor;

import java.util.HashMap;
import java.util.Map;

public final class SymbolTable {

    private final Map<String, VmDescriptor> symbolTable;
    private final SymbolTable parent;

    public SymbolTable(Map<String, VmDescriptor> symbolTable, SymbolTable parent) {
      this.symbolTable = symbolTable;
      this.parent = parent;
    }

    public SymbolTable(SymbolTable parent) {
      this(new HashMap<>(), parent);
    }

    public VmDescriptor getSymbolByName(String name) {
      VmDescriptor vmDescriptor = this.symbolTable.get(name);
      if (vmDescriptor != null) {
        return vmDescriptor;
      }

      VmDescriptor returnDescriptor = parent != null ? parent.getSymbolByName(name) : null;
      if (returnDescriptor == null) {
        System.out.println("Could no find descriptor for symbol '" + name + "'");
      }
      return returnDescriptor;
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
