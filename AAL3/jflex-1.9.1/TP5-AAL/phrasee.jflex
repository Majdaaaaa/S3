%%
%public
%class LexerPhrase
%unicode
%standalone

%{
    String pronom;
%}



%{eof
%eof}

alphabet = [a-zA-Z]

invariant = {alphabet}*[xzs]

invariantAL = (bal|carnaval|festival|recital)
al = {alphabet}*(al)

invariantAUEU = (bleu|pneu|joli)
aueu = {alphabet}*(au|eu)

bisOU = (bijou | caillou | chou | joujou | genou | pou | hibou)
enOU = {alphabet}*(ou|OU)
bisAIL = (bail | travail | soupirail | email | vitrail |corail)
enAIL = {alphabet}*(ail|AIL)
motSpe = (oeil|ciel)


article1 = (Le|La)
article2 = (Un|Une)

%state NOM, VERBEje, VERBEtu, VERBE, COMPLEMENT

%%
<YYINITIAL>{
    {article1}   {System.out.print("Les"); yybegin(NOM);}
    {article2}   {System.out.print("Des"); yybegin(NOM);}
    (Je)         {System.out.print("Nous"); yybegin(VERBEje);}   
    (Tu)         {System.out.print("Vous"); yybegin(VERBEtu);}   
    (Il)         {System.out.print("Ils"); yybegin(VERBE);}   
    (Elle)       {System.out.print("Elles"); yybegin(VERBE);}   
    [^]          {}
}

<NOM>{
    {invariant}      {System.out.print(yytext());yybegin(VERBE);}
    {invariantAL}    {System.out.print(yytext() + "s");yybegin(VERBE);}
    {invariantAUEU}  {System.out.print(yytext() + "s");yybegin(VERBE);}


    {bisOU}     {System.out.print(yytext() + "x");yybegin(VERBE);}
    {bisAIL}    {System.out.print(yytext().substring(0,yytext().length()-2) +"ux");  yybegin(VERBE);}

    {al}        {
                yytext(); System.out.println(yytext().substring(0,yytext().length()-1) +"ux");yybegin(VERBE);}

    {aueu}      {System.out.print(yytext() + "x");yybegin(VERBE);}

    {enOU}      {System.out.print(yytext() + "s");yybegin(VERBE);}
    {enAIL}     {System.out.print(yytext() + "s");yybegin(VERBE);}
    (oeil)      {System.out.print("yeux");yybegin(VERBE);}
    (ciel)      {System.out.print("cieux");yybegin(VERBE);}
    {alphabet}* {System.out.print(yytext() + "s");yybegin(VERBE);}
}

<VERBEje>{
    {alphabet}*     {System.out.print(yytext().substring(0,yytext().length()-1)+"ons");yybegin(COMPLEMENT);}
}

<VERBEtu>{
    {alphabet}*     {System.out.print(yytext().substring(0,yytext().length()-1)+"z");yybegin(COMPLEMENT);}
}

<VERBE>{
    {alphabet}*     {System.out.print(yytext().substring(0,yytext().length()-1)+"ent");yybegin(COMPLEMENT);}
}

<COMPLEMENT>{
    {alphabet}* {System.out.print(yytext());}     
    [.]         {System.out.println(yytext());yybegin(YYINITIAL);}
}
