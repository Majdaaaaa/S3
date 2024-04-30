%%
%public
%class Lexer  //générera le fichier Lexer.java
%unicode
%standalone

//ca affiche tout ce qu'il ya dans le fichier de base mais en remplcant ce qu'il ya dans les regles par ce qu'il faut 

%{
//éventuellement code java qui sera recopié au début de du lexer généré
	public int compteBlabla = 0;
   public int compteZ=0;
   public int moyenne=0;
%}

//définition d'expressions régulières

moustique = z+ //moustique= au moins un z


%{eof
   //éventuellement code java qui sera recopié en fin du lexer généré
   System.out.println("\n nombre de blabla = "+ compteBlabla);
   System.out.println(" moyenne: "+moyenne/compteZ);
%eof}

%%

//les règles:

bla(bla)+      {
   //quand ya des blabla on compte et on affiche rien
   //Q3-b
   System.out.println(yytext() + ":"+ compteBlabla);   
   compteBlabla++;                
}
{moustique}     {
   //quand ya un z ou plus on affiche ca
   compteZ++;
   moyenne+=yylength();
   System.out.println("il y a un moustique! (longueur: " + yylength() + ")"); //compte le nombre de z
}
[^]      {}
