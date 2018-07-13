// Define a grammar called Hello
grammar KSrc;


// Keywords
LET:    'let';
VAR:    'var';
FUNC:   'fn';
IF:     'if';
RETURN: 'return';
BREAK: 'break';
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


// The root element
translation_unit
    : statements_list EOF
    ;

statements
    : statement (SEMICOLON statement)*
    ;

statement
    : declaration
    | return_statement | break_statement

    | LINE_COMMENT

    // Branch statements
    | if_statement
    | loop_statement
    | expression
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
    : expression
    ;

return_statement
    : RETURN expression                     #ReturnStatement
    ;

break_statement
    : BREAK                                                             #BreakStatement
    ;

assign_statement
    : postfix_expression ASSIGN expression                              #StatementAssign
    ;

declaration
    : constant_declaration                              #DeclarationConstant
    | variable_declaration                              #DeclarationVariable

    // Function declaration looks like fn <functioname>([param_name : param_typename [,.. ]) { <code block> }
    | function_declaration                              #DeclarationFunction
    | class_declaration                                 #DeclarationClass
    ;

constant_declaration
    : LET identifier type_annotation? initializer
    ;

variable_declaration
    : VAR identifier type_annotation? initializer?
    ;

class_declaration
    : CLASS identifier ':' (field_declaration | function_declaration)* END
    ;

function_declaration
    : FUNC identifier function_signature code_block
    ;

field_declaration
    : constant_declaration                              #DeclarationFieldVariable
    | variable_declaration                              #DeclarationFieldConstant
    ;

type_annotation: (':' type_literal);
initializer: (ASSIGN expression);

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

expression

    // Binary operator expressions - Arimethric
    : expression POW expression                         #ExprPow
    | MINUS expression                                  #ExprUnaryMinus
    | NOT expression                                    #ExprNot
    | LPARENS expression RPARENS                        #ExprParens
    | expression op=(MULT | DIV | MOD) expression       #ExprMultiplication
    | expression op=(PLUS | MINUS) expression           #ExprAdditive
    | expression op=(LTEQ | GTEQ | LT | GT) expression  #ExprRelational
    | expression op=(EQ | NEQ) expression               #ExprEquality
    | expression AND expression                         #ExprLogicalAnd
    | expression OR expression                          #ExprLogicalOr
    | expression IDEQ expression                        #ExprIdEqual
    | postfix_expression                                #ExprPostFix




//    | NAME '(' arguments ')'                            #ExprCall
//    | function_call_expression
    // Atoms
    ;

postfix_expression
    //:
    // A function call astNode consists of a function name followed by a comma-separated list of the function’s
    // arguments in parentheses. The function name can be any astNode whose value is of a function descriptor.
    : primary_expression                                #ExprPrimary
    | lhs=postfix_expression '.' rhs=postfix_expression #ExprExplicitMemberAccess
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
function_call_argument_list: (expression (',' expression)*)?            #FunctionCallArgumentList;

type_literal: NAME ;
identifier: NAME ;



function_signature
    : (LPARENS function_parameters RPARENS)? ('->' function_result)?   #FunctionSignature
    ;

function_result:
    type_literal
    ;

function_parameters
    : (function_parameter (',' function_parameter)*)?   #FunctionParameters
    ;

function_parameter
    : identifier ':' type_literal                                #FunctionParameter
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