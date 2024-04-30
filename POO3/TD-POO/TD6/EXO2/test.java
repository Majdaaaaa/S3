package EXO2;

public class test {
    public static void main(String[] args) {
        // A a=new A(); // ne marche pas psq A abstract donc non instantiable
        // a.m(); a.n();a.p();
        B b = new B();
        b.m(); // I.m Implementation par defaut(interfae I)
        b.n(); // A.n Implementation heritée de A
        b.p(); // B.p Implementation de B
        C c = new C();
        c.m(); // C.m C a implementé la methode m dans da propre classe: on utilise la nouvelle
               // implementation dans C
        c.n(); // A.n C herite de B qui n'as pas implementé n, mais B herite de A qui a
               // implemente n. On utilise l'implementation herité de A
        c.p(); // B.p Methode herité de B
        c.q(); // C.q Implementation dans C
        A u = b; //meme effet qu'avec b 
        u.m(); // I.m
        u.n(); //A.n
        u.p();  //B.p
        A v = c; //meme effet qu'avec c, par liaison dynamique, sauf pour v.q() : le nom de methde q n'est pas visible dans la classe A
        v.m(); //C.m
        v.n(); //A.n
        v.p(); //B.p
        //v.q(); //marche pas

    }
}
