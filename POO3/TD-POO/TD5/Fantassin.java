public class Fantassin extends Roturier{
    public static int degats=15;
    public Fantassin(String name, int esperance) {
        super(name, esperance);
    }

    public void attaque(Personne p){
        if(p instanceof Chevalier){
            ((Chevalier)p).capturedBy(this);
        }else{p.blessure(degats);
        }
    }    
}
