%%
%public
%class Lexer
%unicode
%standalone

%{
    String res="";
%}

ou=[a-zA-Z]*(ou)
ail=[a-zA-Z]*(ail)
spe=(ciel)|(oeil)

%{eof
%eof}

%%
{ou}  {
    res=yytext();
    switch(yytext()){
        case "bijou": res+="x";break;
        case "chou": res+="x";break;
        case "genou": res+="x";break;
        case "hibou": res+="x";break;
        case "joujou": res+="x";break;
        case "pou": res+="x";break;
        case "caillou": res+="x";break;
        default: res+="s";break;
    }
    System.out.println(res); 
    }
{ail}   {
    res=yytext();
    switch(yytext()){
        case "bail": res=res.substring(0,res.length()-3)+"aux";break;
        case "corail": res=res.substring(0,res.length()-3)+"aux";break;
        case "émail": res=res.substring(0,res.length()-3)+"aux";break;
        case "vitrail": res=res.substring(0,res.length()-3)+"aux";break;
        case "soupirail": res=res.substring(0,res.length()-3)+"aux";break;
        case "travail": res=res.substring(0,res.length()-3)+"aux";break;
        default: res+="s";break;
    }
    System.out.println(res);
}
{spe}   {
    switch(yytext()){
        case "ciel": System.out.println("cieux");break;
        case "oeil": System.out.println("yeux");break;
    }
}
[a-zA-Z]+   {System.out.println(yytext()+"s");}
[^]  {}