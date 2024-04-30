package EX5;

public class Exo {
    private static int a=1; //attribut de classe 
    private int b=2; //attribut d'instance 
    private final int c=3; //attribut d'instance //peut etre initialiser grace  a un constructeur 
    public static void main(String[] args) {
        System.out.println("Hello");
        a=42;
        Exo e=new Exo();
        e.b=23; //pour modifier b faut une instance 
        // c pas modifiable  car final

    }
}
