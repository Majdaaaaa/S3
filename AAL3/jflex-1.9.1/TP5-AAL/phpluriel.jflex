
%%
%public
%class Lexer
%unicode
%standalone
%state Earticle
%state Enom
%state Everbe
%state Ecomplement
%state EPronoms

%{
public String res="";
public String termi="";
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

ciel=(ciel)
oeil=(oeil)


article=(Le|La|L')
articleIn= Un |Une 

pronom=(Je|Tu|Il|Elle)

comp={lettre}*(" "){lettre}*(.)


%{eof
	System.out.println(res);
%eof}
// ^{lettre}    {System.out.println(res);
//             res="";}

%%
<YYINITIAL>{

{pronom}    {yybegin(EPronoms);}

{article}   {yybegin(Earticle);}

}

<EPronoms>{

"Je "     {res+="Nous ";
        termi="ons";
        yybegin(Everbe);
}

"Tu "    {res+="Vous ";
        termi="ez";
        yybegin(Everbe);
}

"Il "    {res+="Ils ";
        termi="ent";
        yybegin(Everbe);
}

"Elle " {res+="Elles ";
        termi="ent";
        yybegin(Everbe);
}


// " "    {yybegin(Everbe);}
}


<Earticle>{
        {article}   {
                //System.out.println("AA");
                res+="Les ";
                yybegin(Enom);
        }
        {articleIn}  {
                res+="Des ";
                //System.out.println("BB");
                yybegin(Enom);
        }
}

// " "     {yybegin(Enom);}

<Enom>{

{ciel}  {
        res+="cieux ";
        yybegin(Everbe);
        }

{oeil}  {
        res+="yeux ";
        yybegin(Everbe);
        }

{execeptionAl} | {execeptionAEu}        {
        res+=yytext()+"s ";
        yybegin(Everbe);
        }

{motAl}  {
        res+=yytext().substring(0,yylength()-1)+"ux ";
        yybegin(Everbe);
        }

{execeptionAil} {
        res+=yytext().substring(0,yylength()-2)+"ux ";
        yybegin(Everbe);
        }

{motAEu} | {execeptionOu}  {
        res+=yytext()+"x ";
        yybegin(Everbe);
        }

{motAil} | {motOu}  {
        res+=yytext()+"s ";
        yybegin(Everbe);
        }

{invariant} {
        res+=yytext()+" ";
        yybegin(Everbe);
        }

{lettre}   {
        res+=yytext()+"s ";
        yybegin(Everbe);
        }

//" " {yybegin(Everbe);}
}

<Everbe>{

{lettre}    {
        if (termi.length()==3){
        res+=yytext().substring(0,yylength()-1)+termi;        
        }
        if (termi.length()==2){
        res+=yytext().substring(0,yylength()-2)+termi;
        }
        yybegin(Ecomplement);
}

//" "    {yybegin(Ecomplement);}
}

<Ecomplement>{

// {lettre}|(" ")  {res+=yytext();}
// "."     {
//         res+="\n";
//         yybegin(YYINITIAL);}
        {comp}  {
                res+=yytext()+"\n";
                yybegin(YYINITIAL);
        }
}