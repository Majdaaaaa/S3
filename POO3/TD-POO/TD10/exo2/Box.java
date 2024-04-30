package exo2;

public class Box<T> {
    private T v;
    public Box(T v){
        this.v=v;
    }
    //1. la seule info qu'on a c'est que T herite de la classe Object. Les seules methodes invocables sur v sont celles de la classe Object
    //Build : v -> un nouveau container encapsulant la valeur de v 
    public static <S>Box<S> build(S v){ //S type generique, on peut ecrire T mais on veut eviter les confusions avec la variable T de declaration de sa classe
                   //ici on declare un nouveau type generique S
        return new Box<S>(v);
    }
    Box<String> s=Box.<String>build("abc");
}

