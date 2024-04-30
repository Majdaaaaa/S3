%%
%public
%class Lexer
%unicode
%standalone

%{

%}

// consonne=[a-zA-Z]-{voyelle}
// voyelle=[aiuyeoAIUYEO]
voyelle=[zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN]*[aiuyeoAIUYEO][zrtpqsdfghjklmwxcvbnZRTPQSDFGHJKLMWXCVBN]*
//marche={consonne}*{voyelle}{consonne}*

//\< debut de mot
//\> fin de mot
//^ ne pas prendre 
//{n} avec n un nombre, au moins n fois ce truc

%{eof
%eof}

%%
{voyelle} {System.out.println(yytext());}
[a-zA-Z]*   {}
[^]     {}