%%
%public
%class Lexer
%unicode
%standalone

%{
  int res=0;
  String res1="";
  private String cut(String s, int col){
      String[] sSplit = s.split(";");
      return(sSplit[col]);
  }
%}
metro1=(METRO | RER );[a-zA-Z0-9\.']+;(1);(1)?;[a-zA-Z0-9\.']*




%{eof
  System.out.println(res);
  System.out.println(res1);
%eof}



%%
//{metro1} {res++;}
{metro1} { res1+="station:" +cut(yytext(),1); res1+="trafic: "+cut(yytext(),2)+"\n";}

[^] {} 