%%
%public
%class Lexer
%unicode
%standalone

%{

%}

majuscule=[A-Z][a-zA-Z]*

//\< debut de mot
//\> fin de mot
//^ ne pas prendre 
//{n} avec n un nombre, au moins n fois ce truc

%{eof
%eof}

%%
{majuscule} {System.out.println(yytext());}
[^]  {}