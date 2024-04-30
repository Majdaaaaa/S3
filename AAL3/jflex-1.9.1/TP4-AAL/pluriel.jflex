%%
%public
%class Lexer
%unicode
%standalone

%{
    //variable
%}
inchangeable=[a-zA-Z]*.(z|s|x)+
al=[a-zA-Z]*.(al)+
au_eu=[a-zA-Z]*.(au|eu)+
autre=[a-zA-Z]+


%{eof
	
%eof}


%%
{inchangeable} {System.out.println(yytext());}
{al} {
    if(yytext().equals("bal") || yytext().equals("carnaval")||yytext().equals("festival")||  yytext().equals("recital") ){ //mieux de faire de switch
        System.out.println(yytext()+"s");
    }else{
        System.out.println(yytext().substring(0,yytext().length()-2)+"aux"); 
    }
}
{au_eu} {
    if(yytext().equals("pneu")|| yytext().equals("bleu")){
        System.out.println(yytext()+"s");
    }else{
        System.out.println(yytext()+"x");
    }
}
{autre}    {System.out.println(yytext()+"s");}
