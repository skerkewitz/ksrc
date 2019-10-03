Basically we do a nice rip off of how LLVM and Swift do:

* The Parse module constructs an AST from source code.
* The Sema module type-checks the AST and annotates it with type information.
* The SILGen module generates SIL from an AST.
* IRGen lowers canonical SIL to IR.
* The WASM backend (optionally) applies WASM optimizations, runs the WASM code generator and emits binary code.

Splitting the process into several stages hopefully make me keep my sanity!

