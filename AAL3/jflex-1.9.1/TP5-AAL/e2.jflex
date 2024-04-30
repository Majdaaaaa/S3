%%
%public
%class Lexer
%unicode
%standalone

%{
    int cmp=0;
%}

punc=-|_|\.
lettre=[A-Za-z]+
fin=com|fr|org|etu|net|edu

word=({lettre}{punc}?{lettre}{punc}?)+@({lettre}{punc}?{lettre})+.{fin}+

%{eof
    System.out.println("cmp="+cmp); 
%eof}

%%
{word}  {System.out.println(yytext()); cmp++;}
[a-zA-Z]+  {}
[^]  {}
