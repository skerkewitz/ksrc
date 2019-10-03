/*
 * Defines the SIL grammer.
 */
grammar Sil;

//// Keywords
//LPARENS:    '(';
//RPARENS:    ')';
//SEMICOLON:  ';';
//
//LINE_COMMENT : '#' ~[\r\n]* -> skip;
//BLOCK_COMMENT: '<!--' .*? '-->' -> skip;

// The root element
translation_unit
    : sil_function EOF
    ;

sil_type
  : TYPE_SIGIL sil_types;

sil_types
  : sil_basic_type
  | sil_function_type;

sil_function_type
  : '(' sil_function_type_arguments ')' '->' returnType=sil_types;

sil_function_type_arguments
  : sil_types (',' sil_types)*
  ;

sil_basic_type
  : sil_identifier            #Simple
  | POINTER_SIGIL sil_identifier  #Pointer;

sil_identifier
  : valuename;

sil_value_name
  : '%' valuename;

sil_value
  : sil_value_name;
//sil-value ::= 'undef'
sil_operand
  : sil_value ':' sil_type;


// --- function declaration
sil_function
//  : 'sil' sil-linkage? sil_function_name ':' sil_type '{' sil_basic_block+ '}';
  : 'sil' sil_function_name ':' sil_type '{' sil_basic_block+ '}';

sil_function_name
  : FUNCTION_SIGIL functioname;

sil_name
  : NAME;

// --- Basic block

sil_basic_block
  : sil_label sil_instruction_def* sil_terminator;

sil_label_target
  : sil_identifier ('(' sil_operand (',' sil_operand)* ')')?
  ;

sil_label
  : sil_identifier ('(' sil_operand (',' sil_operand)* ')')? ':'
  ;



//sil_argument
//  : sil_value_name ':' sil_type;

sil_instruction_result
  : sil_value_name;

//sil-instruction-result ::= '(' (sil-value-name (',' sil-value-name)*)? ')'
//sil-instruction-source-info ::= (',' sil-scope-ref)? (',' sil-loc)?

sil_instruction_def
  : (sil_instruction_result '=')? sil_instruction; //sil_instruction_source_info;


// --- Block terminator
sil_terminator
  : sil_terminator_br
  | sil_terminator_cond_br
  | sil_terminator_return
  ;

sil_terminator_return
  : 'return' sil_operand
  ;

//
// br label (%0 : $A, %1 : $B, ...)
// `label` must refer to a basic block label within the current function
// %0, %1, etc. must be of the types of `label`'s arguments
// Unconditionally transfers control from the current basic block to the block labeled label, binding the given values to the arguments of the destination basic block.
sil_terminator_br
  : 'br' sil_label_target
  ;

//
// cond_br %0 : $Builtin.Int1, true_label (%a : $A, %b : $B, ...),
//                             false_label (%x : $X, %y : $Y, ...)
//
// %0 must be of $Builtin.Int1 type
// `true_label` and `false_label` must refer to block labels within the
//   current function and must not be identical
// %a, %b, etc. must be of the types of `true_label`'s arguments
// %x, %y, etc. must be of the types of `false_label`'s arguments
//
//Conditionally branches to true_label if %0 is equal to 1 or to false_label if %0 is equal to 0, binding the corresponding set of values to the arguments of the chosen destination block.
sil_terminator_cond_br
  : 'cond_br' condition=sil_operand ',' thenLabel=sil_label_target ',' elseLabel=sil_label_target;

// --- Instructions
sil_instruction
  : 'alloc_stack' sil_type;

/// Name
valuename: VALUENAME;
functioname: VALUENAME;


WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

TYPE_SIGIL: '$';
POINTER_SIGIL: '*';
LOCAL_SIGIL:    '%';
FUNCTION_SIGIL: '@';

STRING: '"' (~'"')* '"';


VALUENAME: (DIGIT | ID_START) ID_CONTINUE*;


/// id_start     ::=  <all characters in general categories Lu, Ll, Lt, Lm, Lo, Nl, the underscore, and characters with the Other_ID_Start property>
fragment ID_START
    : '_'
    | '-'
    | [A-Z]
    | [a-z]
    ;

fragment ID_CONTINUE: ID_START | [0-9.];


fragment NON_ZERO_DIGIT: [1-9];
fragment DIGIT: '0';

fragment FRACTION: '.' DIGIT+;