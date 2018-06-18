// Define a grammar called Hello
grammar KSrc;

//fragment NEWLINE: '\n';

file_input: (statements)* EOF;

// Keywords
LET:    'let';
VAR:    'var';
FUNC:   'fn';
IF:     'if';
RETURN: 'return';
WHILE: 'while';

ASSIGN: '=';

LINE_COMMENT : '#' ~[\r\n]* -> skip;

/// Statments
statements
    : statement (';' statement)*
    | LINE_COMMENT
    ;

statement
    : declaration
    | return_statement

    // Branch statements
    | if_statement
    | loop_statement
    | expression
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

// The initialValue of the condition must be of type Bool
condition
    : expression
    ;

return_statement
    : RETURN expression                     #ReturnStatement;

declaration
    : LET ident ASSIGN expression               #DeclLet
    | VAR ident type_annotation? initializer?   #DeclarationVariable
    | func_decl                                 #FunctionDeclaration
    ;

type_annotation: (':' typename);
initializer: (ASSIGN expression);

expression
    : ident                                 #ExprIdent
    | initialValue                                 #ExprValue

    // Binary operator expressions
    | expression '*' expression                         #ExprMul
    | expression '/' expression                         #ExprDiv
    | expression '+' expression                         #ExprAdd
    | expression '-' expression                         #ExprSub
    | expression '==' expression                        #ExprEqual

    | NAME '(' arguments ')'                #ExprCall
    ;

arguments: (expression (',' expression)*)?              #FunctionCallArgumentList;

typename: NAME ;
ident: NAME ;
initialValue: NUMBER | STRING;

// Function declaration looks like fn <functioname>([param_name : param_typename [,.. ]) { <code block> }
func_decl: FUNC ident ('(' func_params ')')? (':' typename)? ':' code_block #DeclFunc;
func_params: (func_param (',' func_param)*)? #FunctionParameters;
func_param: ident ':' typename #FunctionParameter;



code_block: '{' (statements)* '}' #CodeBlock;


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