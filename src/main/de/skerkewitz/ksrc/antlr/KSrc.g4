// Define a grammar called Hello
grammar KSrc;

//fragment NEWLINE: '\n';

file_input: (stmt_list | func_decl)* EOF;

// Keywords
LET: 'let';
FUNC: 'fn';

ASSIGN: '=';


/// Statments
stmt_list: stmt (';' stmt)*;

stmt
    : LET ident ASSIGN expr #DeclLet
    | expr #Expression
    ;

expr
    : ident #ExprIdent
    | value #ExprValue
    | expr '*' expr #ExprMul
    | expr '/' expr #ExprDiv
    | expr '+' expr #ExprAdd
    | expr '-' expr #ExprSub
    | NAME '(' arguments ')' #ExprCall
    ;

arguments: (expr (',' expr)*)? #FuncArguments;

ident: NAME ;
value: NUMBER | STRING;

func_decl: FUNC ident ('(' func_params ')')? func_body #DeclFunc;

func_params: (ident (',' ident)*)? #FunctionParameter;
func_body: '{' (stmt_list)* '}' #FunctionBody;

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