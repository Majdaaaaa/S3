public class Chevalier extends Noble{ //normalement mais tqt
    private static final int prixLiberté=50;
    private boolean estLibre=true;
    private Personne geolier=null;
    public Chevalier(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    public void attaque(Personne p){
        if(p instanceof Chevalier && this.estLibre){ //retourne boolean 
            ((Chevalier)p).capturedBy(this);
        }
    }
    public void capturedBy(Personne geolier){
        this.geolier=geolier;
        this.estLibre=false;
    }
    public boolean acheteLiberte(){
        if(estLibre){
            return false;
        }
        if(perte(prixLiberté)){
            this.geolier.gain(prixLiberté);
            this.estLibre=true;
            return true;
        }
        return false;
    }

}
