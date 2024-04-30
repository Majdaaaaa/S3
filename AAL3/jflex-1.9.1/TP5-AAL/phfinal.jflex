
%%
%public
%class Lexer
%unicode
%standalone
%state Earticle
%state Enom
%state Eje
%state Eilelle
%state Etu
%state Ecomplement
%state EPronoms

%{
public String res="";
%}

lettre=[a-zA-Zéèàù']+

execeptionAl= (bal|carnaval|festival|recital)
motAl={lettre}al

execeptionAEu=(bleu|pneu)
AEu=(au|eu)
motAEu={lettre}{AEu}

lInvariant=(x|s|z)
invariant={lettre}{lInvariant}

execeptionOu=(bijou|caillou|chou|joujou|genou|pou|hibou)
motOu={lettre}ou

execeptionAil=(bail|travail|soupirail|émail|vitrail|corail)
motAil={lettre}ail

%{eof
	System.out.println(res);
%eof}

%%
<YYINITIAL>{
"La " | "Le "   {res+="Les ";
                yybegin(Enom);
}
 "Un " | "Une "   {res+="Des ";
 yybegin(Enom);}

 "Je "   {res+="Nous ";
 yybegin(Eje);
 }

 "Tu "   {res+="Vous ";
 yybegin(Etu);
 }

"Il" | "Elle"  {res+=yytext()+"s ";
 yybegin(Eilelle);
 }

<Eje>{
    "me"    {res+="nous";}
" "     {res+=yytext();}
{lettre}    {
    res+=yytext().substring(0,yylength()-1)+"ons";
    yybegin(Ecomplement);
}
}

<Etu>{
"te"    {res+="vous";}
" "     {res+=yytext();}
{lettre}    {
    res+=yytext().substring(0,yylength()-1)+"z";
    yybegin(Ecomplement);
}

}

<Eilelle>{
    "se"    {   res+=yytext()+" ";}
    " "     {res+=yytext();}
    {lettre}    {
        res+=yytext()+"nt";
        yybegin(Ecomplement);
    }
}

<Enom>{

"ciel"  {
        res+="cieux ";
        yybegin(Eilelle);
        }

"oeil"  {
        res+="yeux ";
        yybegin(Eilelle);
        }

{execeptionAl} | {execeptionAEu}        {
        res+=yytext()+"s ";
        yybegin(Eilelle);
        }

 {motAl}  {
        res+=yytext().substring(0,yylength()-1)+"ux ";
        yybegin(Eilelle);
        }

{execeptionAil} {
        res+=yytext().substring(0,yylength()-2)+"ux ";
        yybegin(Eilelle);
        }

{motAEu} | {execeptionOu}  {
        res+=yytext()+"x ";
        yybegin(Eilelle);
        }

{motAil} | {motOu}  {
        res+=yytext()+"s ";
        yybegin(Eilelle);
        }

{invariant} {
        res+=yytext()+" ";
        yybegin(Eilelle);
        }
"se"    {   res+=yytext()+" ";
        yybegin(Eilelle);
}
{lettre}   {
        res+=yytext()+"s ";
        yybegin(Eilelle);
        }
}

<Ecomplement>{

{lettre}    {res+=yytext();}

" "     {res+=yytext();}

"."     {
        res+=". \n";
        yybegin(YYINITIAL);}
}