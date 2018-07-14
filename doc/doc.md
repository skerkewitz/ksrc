How it should work
 * ANTRL4 reads input and creates a parse tree
 * AstBuilder transforms ANTLR4 tree into AST tree
 * Sema module type-checks the AST and annotates it with type information.
 * IL module creates intermediate language tree
 * IL tree can be written as LLVM IR, JVM or CIL code
 
Missing language features
 * No arrays
 * No interfaces
 * No default constructor
 * Classes currently actually more like structs
 * Syntax not final
 
Missing compiler/VM features
 * No AST optimisations
 * No Sema optimisations
 * No VM optimisations

 
 

     
 

