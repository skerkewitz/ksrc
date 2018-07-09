// Define a grammar called Hello
grammar KSrc;

file_input: statements_list EOF;

// Keywords
LET:    'let';
VAR:    'var';
FUNC:   'fn';
IF:     'if';
RETURN: 'return';
WHILE: 'while';

CLASS:  'class';

ASSIGN: '=';

ELSE: 'else:';
END: 'end';

LPARENS:    '(';
RPARENS:    ')';
SEMICOLON:  ';';

LINE_COMMENT : '#' ~[\r\n]* -> skip;
BLOCK_COMMENT: '<!--' .*? '-->' -> skip;

/// Statments
statements
    : statement (SEMICOLON statement)*
    ;

statement
    : declaration
    | return_statement

    | LINE_COMMENT

    // Branch statements
    | if_statement
    | loop_statement
    | astNode
    | assign_statement
    ;

if_statement
    //: IF condition code_block              #IfStatement;
    : IF condition ':' thenBlock=statements_list (ELSE elseBlock=statements_list)? END #IfStatement;

loop_statement
    : while_statement
    ;

// A while thenStatement allows a block of code to be executed repeatedly, as long as a condition remains true.
while_statement
    : WHILE condition code_block           #StatementWhile
    ;

// The initializer of the condition must be of descriptor Bool
condition
    : astNode
    ;

return_statement
    : RETURN astNode                     #ReturnStatement
    ;

assign_statement
    : identifier ASSIGN astNode                              #StatementAssign
    ;

declaration
    : LET identifier type_annotation? initializer            #DeclarationConstant
    | VAR identifier type_annotation? initializer?           #DeclarationVariable

    // Function declaration looks like fn <functioname>([param_name : param_typename [,.. ]) { <code block> }
    | function_declaration                              #DeclarationFunction
    | class_declaration                                 #DeclarationClass
    ;


class_declaration
    : CLASS identifier ':' (function_declaration)* END
    ;

function_declaration
    : FUNC identifier function_signature code_block
    ;

type_annotation: (':' type);
initializer: (ASSIGN astNode);

POW:    '^';
MINUS:  '-';
NOT:    '!';
MULT:   '*';
DIV:    '/';
MOD:    '%';
PLUS:   '+';

LTEQ:   '=<';
GTEQ:   '>=';
LT:     '<';
GT:     '>';
EQ:     '==';
IDEQ:   '===';
NEQ:    '!=';

AND:    'and';
OR:     'or';

astNode

    // Binary operator expressions - Arimethric
    : astNode POW astNode                         #ExprPow
    | postfix_expression                                #ExprPostFix
    | MINUS astNode                                  #ExprUnaryMinus
    | NOT astNode                                    #ExprNot
    | astNode op=(MULT | DIV | MOD) astNode       #ExprMultiplication
    | astNode op=(PLUS | MINUS) astNode           #ExprAdditive
    | astNode op=(LTEQ | GTEQ | LT | GT) astNode  #ExprRelational
    | astNode op=(EQ | NEQ) astNode               #ExprEquality
    | astNode AND astNode                         #ExprLogicalAnd
    | astNode OR astNode                          #ExprLogicalOr
    | astNode IDEQ astNode                        #ExprIdEqual




//    | NAME '(' arguments ')'                            #ExprCall
//    | function_call_expression
    // Atoms
    ;

postfix_expression
    //:
    // A function call astNode consists of a function name followed by a comma-separated list of the function’s
    // arguments in parentheses. The function name can be any astNode whose value is of a function descriptor.
    : primary_expression                                #ExprPrimary
    | lhs=postfix_expression '.' rhs=postfix_expression         #ExprExplicitMemberAccess
    | postfix_expression function_call_argument_clause  #ExprCall
    ;


// Primary expressions are the most basic kind of astNode. They can be used as expressions on their own, and they
// can be combined with other tokens to make prefix expressions, binary expressions, and postfix expressions.
primary_expression
    : literal_expression                                #ExprValue
    | identifier                                        #ExprIdent
    ;

// A literal astNode consists of an ordinary literal (such as a string or a number)
literal_expression
    : numeric_literal
    | string_literal
    | boolean_literal
    | nil_literal
    ;


function_call_argument_clause: '(' function_call_argument_list ')'    #FunctionCallArgumentClause;
function_call_argument_list: (astNode (',' astNode)*)?            #FunctionCallArgumentList;

type: NAME ;
identifier: NAME ;



function_signature
    : (LPARENS function_parameters RPARENS)? ('->' function_result)?   #FunctionSignature
    ;

function_result:
    type
    ;

function_parameters
    : (function_parameter (',' function_parameter)*)?   #FunctionParameters
    ;

function_parameter
    : identifier ':' type                                #FunctionParameter
    ;

statements_list
    : statements*
    ;

/* A compound statement (also called a "block") typically appears as the body of another statement, such as the if
   statement. Declarations and Types describes the form and meaning of the declarations that can appear at the head of
   a compound statement. */
code_block
    : ':' statements_list 'end'                             #CodeBlock;

numeric_literal
    : DECIMAL_INTEGER #LiteralInteger
    | FLOAT_LITERAL #LiteralFloat
    ;

string_literal
    : STRING
    ;

boolean_literal
    : 'true' | 'false'
    ;

nil_literal
    : 'nil'
    ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines


/// decimalinteger ::=  nonzerodigit digit* | "0"+
DECIMAL_INTEGER
    : NON_ZERO_DIGIT DIGIT*
    | '0'+
    ;

FLOAT_LITERAL
    : DECIMAL_INTEGER FRACTION
//    | Hexadecimal_literal Hexadecimal_fraction? Hexadecimal_exponent
    ;


STRING: '"' (~'"')* '"';

/// Name
NAME: ID_START ID_CONTINUE*;

/// id_start     ::=  <all characters in general categories Lu, Ll, Lt, Lm, Lo, Nl, the underscore, and characters with the Other_ID_Start property>
fragment ID_START
    : '_'
    | '-'
    | [A-Z]
    | [a-z]
    ;

fragment ID_CONTINUE: ID_START | [0-9];

fragment NON_ZERO_DIGIT: [1-9];
fragment DIGIT: [0-9];

fragment FRACTION: '.' DIGIT+;