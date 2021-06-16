lexer grammar Lexicon;

LITINT : [0-9]+ ;
LITREAL :[0-9]+ '.' [0-9]+ ;
LITCHAR : '\'' (.|'\\n') '\'' ;
IDENT : [a-zA-Z][a-zA-Z0-9_]* ;
COMMENT : '//' .*? ('\n' | EOF) -> skip ;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;
WHITESPACE : [ \t\r\n]+ -> skip ;