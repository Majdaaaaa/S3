%%
%public
%class Lexer
%unicode
%standalone

%{
  private String cut(String s, int col){
     String[] sSplit = s.split(";");
     return(sSplit[col]);
  }
%}

%{eof

%eof}
station=(METRO | RER );[a-zA-Z0-9\.']+;[0-9]+;[0-9]+;[a-zA-Z0-9\.']*
stationPont=(METRO | RER );(PONT [a-zA-Z0-9\.']+);[0-9]+;[0-9]+;[a-zA-Z0-9\.']*;[0-9]+;[0-9]+;[a-zA-Z0-9\.';]*;PARIS;[0-9]+;


%%
{station} {System.out.println(cut(yytext(),1));}

[^] {} 