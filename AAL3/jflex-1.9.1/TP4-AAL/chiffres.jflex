%%
%public
%class Lexer
%unicode
%standalone

%{
public int count = 0;
public int somme=0;
%}

chiffre = [0-9]

%{eof
	// System.out.println("nombre de chiffres = "+ count);
	// System.out.println("somme = "+ somme);
	// System.out.println("moyenne = "+somme/count);
%eof}


%%
//{chiffre}     { count++; somme+=Integer.valueOf(yytext()); }

[^]     {}
