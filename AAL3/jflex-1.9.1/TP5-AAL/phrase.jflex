%%
%public
%class Lexer
%unicode
%standalone

%{
    //Déclaration de variable :
    public boolean premierePersonne = true;

%}

//Déclaration d'expression rationnelle :

mot = [a-zA-Zèéàï]+


%eof{
    //Déclaration de programme à exécuter à la fin :


%eof}

//Déclaration d'états :

%state NOM, VERBE, COMPLEMENT

%%

<YYINITIAL> {

    le | la {
        System.out.print("les");
        premierePersonne = false;
        yybegin(NOM);
    }

    Le | La {
        System.out.print("Les");
        premierePersonne = false;
        yybegin(NOM);
    }

    un | une | du | de la {
        System.out.print("des");
        premierePersonne = false;
        yybegin(NOM);
    }

    Un | Une | Du | De la {
        System.out.print("Des");
        premierePersonne = false;
        yybegin(NOM);
    }

    je me {
        System.out.print("nous nous");
        premierePersonne = true;
        yybegin(VERBE);
    }

    je {
        System.out.print("nous");
        premierePersonne = true;
        yybegin(VERBE);
    }

    Je {
        System.out.print("Nous");
        premierePersonne = true;
        yybegin(VERBE);
        }

    tu {
        System.out.print("vous");
        yybegin(VERBE);
        }

    Tu {
        System.out.print("Vous");
        yybegin(VERBE);
        }

    il {
        System.out.print("ils");
        premierePersonne = false;
        yybegin(VERBE);
        }

    Il {
        System.out.print("Ils");
        premierePersonne = false;
        yybegin(VERBE);
        }

    elle {
        System.out.print("elles");
        premierePersonne = false;
        yybegin(VERBE);
        }

    Elle {
        System.out.print("Elles");
        premierePersonne = false;
        yybegin(VERBE);
        }


    [^] {System.out.print(yytext());}

}

<NOM> {

    oeil {
        System.out.print("yeux");
        yybegin(VERBE);
    }

    ciel {
        System.out.print("cieux");
        yybegin(VERBE);
    }

    {mot}x | {mot}s | {mot}z {
        System.out.print(yytext());
        yybegin(VERBE);
    }

    bal | carnaval | festival | recital | bleu | pneu | récital {
        System.out.print(yytext() + "s");
        yybegin(VERBE);
    }

    {mot}al {
        System.out.print(yytext().substring(0, yylength() - 2) + "aux"); 
        yybegin(VERBE);
    }


    {mot}au | {mot}eu | bijou | caillou | chou | joujou | genou | pou | hibou {
        System.out.print(yytext() + "x");
        yybegin(VERBE);
    }

    bail | travail | soupirail | émail | email | vitrail | corail {
        System.out.print(yytext().substring(0, yylength() - 2) + "ux");
        yybegin(VERBE);
    }


    {mot} {
        System.out.print(yytext() + "s");
        yybegin(VERBE);
    }

      [^] {System.out.print(yytext());}

}

<VERBE> {

    me {
        System.out.print("nous");
    }

    te {
        System.out.print("vous");
    }

    se {
        System.out.print("se");
    }


    {mot}e {
        if(premierePersonne) System.out.print(yytext().substring(0, yylength() - 1) + "ons");
        else System.out.print(yytext().substring(0, yylength() - 1) + "ent");
        yybegin(COMPLEMENT);
    }

    {mot}es {
        System.out.print(yytext().substring(0, yylength() - 1) + "z");
        yybegin(COMPLEMENT);
    }

    [^] {System.out.print(yytext());}
}

<COMPLEMENT> {
    \. {
        System.out.print(yytext());
        yybegin(YYINITIAL);
    }

    [^] {System.out.print(yytext());}
}