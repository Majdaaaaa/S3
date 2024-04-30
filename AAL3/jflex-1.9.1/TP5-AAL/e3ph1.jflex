%%
%public
%class Lexer
%unicode
%standalone
%line
%column
%states article nom verbe pronom complément

%{
    String res="";
    String n="";
%}
//les regles:
pronom= (Je |Tu |Il |Elle )

article=(Le|La|Un|Une)

verbe= [a-zA-Zéèà]+(e)
//nom
inchangeable=[a-zA-Zéèà]*.(z|s|x)+
al=[a-zA-Zéèà]*.(al)+
au_eu=[a-zA-Zéèà]*.(au|eu)+
ou=[a-zA-Zéèà]*(ou)
ail=[a-zA-Zéèà]*(ail)
spe=(ciel)|(oeil)
autre=[a-zA-Zéèà]+

//complément
comp= ([a-zA-Zéèà']*[ ])*.+

%{eof
	System.out.println(res);
%eof}


%%
//ce qui se passe 
<YYINITIAL> {
    {pronom} {yybegin(pronom);}
    {article} {yybegin(article);}
}
<article>{

    {article}  {
        switch(yytext()){
            case "Le"  : res+="Les "; yybegin(nom) ;break;
            case "La" : res+="Les "; yybegin(nom) ;break;
            case "Un" : res+="Des "; yybegin(nom) ;break;
            case "Une"  : res+="Des "; yybegin(nom) ;break;
        } 
    } 
}
<pronom>    {
    {pronom}  {
        switch(yytext()){
            case "Je"  : res+="Nous "; yybegin(verbe) ;break;
            case "Tu" : res+="Vous "; yybegin(verbe) ;break;
            case "Il"  : res+="Ils "; yybegin(verbe) ;break;
            case "Elle" : res+="Elles "; yybegin(verbe) ;break;
        } 
    } 
}
<verbe> {
    {verbe} {
        switch(res){
            case "Nous "  : res+=yytext()+"ons "; yybegin(complément) ;break;
            case "Vous " : res+="ez "; yybegin(complément) ;break;
            case "Ils "  : res+="ent "; yybegin(complément) ;break;
            case "Elles " : res+="ent "; yybegin(complément) ;break;
        }
        res+=yytext()+"nt "; yybegin(complément);
    }
}
<nom>   {
    {inchangeable}  {res+=yytext()+" "; yybegin(verbe);}
    {al}    {
        n=yytext();
        if(yytext().equals("bal") || yytext().equals("carnaval")||yytext().equals("festival")||  yytext().equals("recital") ){ //mieux de faire de switch
            n+="s";
        }else{
            //System.out.println(yytext().substring(0,yytext().length()-2)+"aux"); 
            n=yytext().substring(0,yytext().length()-2)+"aux";
        }
        res+=n+" "; yybegin(verbe);
    }
    {au_eu} {
        n=yytext();
        if(yytext().equals("pneu")|| yytext().equals("bleu")){
            //System.out.println(yytext()+"s");
            n+="s";
        }else{
            n+="x";
            //System.out.println(yytext()+"x");
        }
        res+=n+" "; yybegin(verbe);
    }
    {ou}  {
        n=yytext();
        switch(yytext()){
            case "bijou": n+="x";break;
            case "chou": n+="x";break;
            case "genou": n+="x";break;
            case "hibou": n+="x";break;
            case "joujou": n+="x";break;
            case "pou": n+="x";break;
            case "caillou": n+="x";break;
            default: n+="s";break;
        }
        res+=n+" "; yybegin(verbe);
    }
    {ail}   {
        n=yytext();
        switch(yytext()){
            case "bail": n=n.substring(0,n.length()-3)+"aux";break;
            case "corail": n=n.substring(0,n.length()-3)+"aux";break;
            case "émail": n=n.substring(0,n.length()-3)+"aux";break;
            case "vitrail": n=n.substring(0,n.length()-3)+"aux";break;
            case "soupirail": n=n.substring(0,n.length()-3)+"aux";break;
            case "travail": n=n.substring(0,n.length()-3)+"aux";break;
            default: n+="s";break;
        }
        res+=n+" "; yybegin(verbe);
    }
    {spe}   {
        n=yytext();
        switch(yytext()){
            case "ciel": n="cieux";break;
            case "oeil": n="yeux";break;
        }
        res+=n+" "; yybegin(verbe);
    }   
    {autre}    {n=yytext()+"s";res+=n+" "; yybegin(verbe);}
}
<complément>  { 
    {comp}    {res+=yytext()+"\n";}
    (\.)    {res+="\n";yybegin(YYINITIAL);}
}
//regle souvent la, ne prends rien de ce qui se passe apres
[^]     {}