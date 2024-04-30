%%
%public
%class Lexer
%unicode
%standalone

%{
    int cmp=0;
%}

voy=[aiuyeoAIUYEO]
cons=[a-zA-Z&&[^{voy}]]
wordC=({voy}{cons})*{voy}?
wordV=({cons}{voy})*{cons}?

%{eof
    System.out.println("cmp="+cmp);
%eof}

%%

{wordC}|{wordV}  {System.out.println(yytext()); cmp++;}
[a-zA-Z]+  {}
[^]  {}
