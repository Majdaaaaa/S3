%%
%public
%class Lexer
%unicode
%column
%line
%standalone

%{

%}

annee=[0-9]{4}


%{eof
	
%eof}


%%
{annee}      { System.out.println("Ligne : "+yyline+" Position : "+yycolumn+" Année : "+yytext()); }

[^]     {}
