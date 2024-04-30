public class Pretre extends Personne {
    public static final int esperanceDeVie=66;
    public Pretre(String name){
        super(name,esperanceDeVie);
    }
    public String toString(){
        return super.toString()+"Je suis un pretre";
    }
    
}
