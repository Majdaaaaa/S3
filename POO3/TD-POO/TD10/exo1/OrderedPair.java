package exo1;

public class OrderedPair<T,S> implements Pair<T,S> {
    //attributs
    T fst;
    S snd;
    //constructeur 
    public OrderedPair(T t, S s){
        this.fst=t;
        this.snd=s;
    }
    //getter 
    public T getFst(){
        return this.fst;
    }
    public S getSnd(){
        return this.snd;
    }
    //methode
    public OrderedPair<S,T> reverse(){
        return new OrderedPair<S,T>(snd,fst);        
    }
    //syntaxe pour crée une paire Integer x String
    Pair<Integer,String> p=new OrderedPair<Integer,String>(10,"abc");
}
