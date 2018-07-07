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

// The initializer of the condition must be of type Bool
condition
    : expression
    ;

return_statement
    : RETURN expression                     #ReturnStatement
    ;

assign_statement
    : name ASSIGN expression                              #StatementAssign
    ;

declaration
    : LET name type_annotation? initializer            #DeclarationConstant
    | VAR name type_annotation? initializer?           #DeclarationVariable

    // Function declaration looks like fn <functioname>([param_name : param_typename [,.. ]) { <code block> }
    | function_declaration                              #DeclarationFunction
    | class_declaration                                 #DeclarationClass
    ;


class_declaration
    : CLASS name ':' (function_declaration)* END
    ;

function_declaration
    : FUNC name function_signature code_block
    ;

type_annotation: (':' typename);
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
    | value                                             #ExprValue
    | MINUS expression                                  #ExprUnaryMinus
    | NOT expression                                    #ExprNot
    | expression op=(MULT | DIV | MOD) expression       #ExprMultiplication
    | expression op=(PLUS | MINUS) expression           #ExprAdditive
    | expression op=(LTEQ | GTEQ | LT | GT) expression  #ExprRelational
    | expression op=(EQ | NEQ) expression               #ExprEquality
    | expression AND expression                         #ExprLogicalAnd
    | expression OR expression                          #ExprLogicalOr
    | expression IDEQ expression                        #ExprIdEqual

    | NAME '(' arguments ')'                            #ExprCall
    // Atoms
    | name                                             #ExprIdent

    ;

arguments: (expression (',' expression)*)?              #FunctionCallArgumentList;

typename: NAME ;
name: NAME ;
value: numeric_literal | string_literal;


function_signature
    : (LPARENS function_parameters RPARENS)? ('->' function_result)?   #FunctionSignature
    ;

function_result:
    typename
    ;

function_parameters
    : (function_parameter (',' function_parameter)*)?   #FunctionParameters
    ;

function_parameter
    : name ':' typename                                #FunctionParameter
    ;

statements_list
    : statements*
    ;

code_block
    : ':' statements_list 'end'                             #CodeBlock;

numeric_literal
    : DECIMAL_INTEGER #LiteralInteger
    | FLOAT_LITERAL #LiteralFloat
    ;

string_literal
    : STRING
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

fragment ID_CONTINUE: ID_START | [0-9] | '.';

fragment NON_ZERO_DIGIT: [1-9];
fragment DIGIT: [0-9];

fragment FRACTION: '.' DIGIT+;