%%
%public
%class Lexer
%unicode
%standalone

%{
public int count = 0;
public double somme=0;
%}
chiffres=-*\.*[0-9]+\.*[0-9]+



%{eof
	System.out.println("nombre de chiffres = "+ count);
	System.out.println("somme des chiffres = "+ somme);
%eof}

%%
{chiffres }      { count++; somme+=Double.valueOf(yytext()); System.out.println(yytext()); }

[^]     {}
