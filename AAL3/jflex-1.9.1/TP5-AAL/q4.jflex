%%
%public
%class Lexer
%unicode
%standalone

%{
    int cmp=0;
%}

lab=[pbmfv]
cons=[a-zA-Z&&[^{lab}]]
word={lab}?{cons}*


%{eof
    System.out.println("cmp="+cmp); 
%eof}

%%
{word}  {System.out.println(yytext()); cmp++;}
[a-zA-Z]+  {}
[^]  {}
