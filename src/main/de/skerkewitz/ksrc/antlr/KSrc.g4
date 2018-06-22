// Define a grammar called Hello
grammar KSrc;

//fragment NEWLINE: '\n';

//tokens { INDENT, DEDENT }
//
//@lexer::header {
//  import denter.DenterHelper;
//}
//
//@lexer::members {
//  private final DenterHelper denter = DenterHelper.builder()
//        .nl(NL)
//        .indent(KSrcParser.INDENT)
//        .dedent(KSrcParser.DEDENT)
//        .pullToken(KSrcLexer.super::nextToken);
//
//  @Override
//  public Token nextToken() {
//    return denter.nextToken();
//  }
//}
//
//NL: ('\r'? '\n' ' '*);

file_input: statements* EOF;

// Keywords
LET:    'let';
VAR:    'var';
FUNC:   'fn';
IF:     'if';
RETURN: 'return';
WHILE: 'while';

ASSIGN: '=';

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
    : IF condition code_block              #IfStatement;

loop_statement
    : while_statement
    ;

// A while statement allows a block of code to be executed repeatedly, as long as a condition remains true.
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
    : ident ASSIGN expression                              #StatementAssign
    ;

declaration
    : LET ident type_annotation? initializer            #DeclarationConstant
    | VAR ident type_annotation? initializer?           #DeclarationVariable

    // Function declaration looks like fn <functioname>([param_name : param_typename [,.. ]) { <code block> }
    | FUNC ident function_signature code_block  #FunctionDeclaration
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
    | ident                                             #ExprIdent
    | value                                             #ExprValue
    ;

arguments: (expression (',' expression)*)?              #FunctionCallArgumentList;

typename: NAME ;
ident: NAME ;
value: NUMBER | STRING;


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
    : ident ':' typename                                #FunctionParameter
    ;



code_block
//    : '{' (statements)* '}'                             #CodeBlock;
//    : INDENT (statements)* DEDENT                             #CodeBlock;
    : ':' (statements)* 'end'                             #CodeBlock;



WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

NUMBER
 : INTEGER
 | FLOAT_NUMBER
 ;

INTEGER
  : DECIMAL_INTEGER
  ;

/// decimalinteger ::=  nonzerodigit digit* | "0"+
DECIMAL_INTEGER
    : NON_ZERO_DIGIT DIGIT*
    | '0'+
    ;

/// floatnumber   ::=  pointfloat | exponentfloat
FLOAT_NUMBER
    : POINT_FLOAT
    ;

STRING: '"' (~'"')* '"';

/// Name
NAME: ID_START ID_CONTINUE*;

/// id_start     ::=  <all characters in general categories Lu, Ll, Lt, Lm, Lo, Nl, the underscore, and characters with the Other_ID_Start property>
fragment ID_START
    : '_'
    | [A-Z]
    | [a-z]
    ;

fragment ID_CONTINUE: ID_START | [0-9];

fragment NON_ZERO_DIGIT: [1-9];
fragment DIGIT: [0-9];

fragment POINT_FLOAT
    : INT_PART? FRACTION
    | INT_PART '.'
    ;

fragment INT_PART: DIGIT+ ;

fragment FRACTION: '.' DIGIT+;