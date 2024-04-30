package EX1;
public class Personne{
    private String nom;
    private String prenom;
    public int age;
    public int monnaie;
    public Personne(String nom, String prenom, int age, int m){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.monnaie=m;
    }
    public void setPrenom(String p){
        this.prenom=p;
    }
    //Q2
    public void setNom(String n){
        this.nom=n;
    }
    public void anniversiare(){
        this.age++;
    }
    public String toString(){
        return "Je m'appelle : "+ this.prenom+" "+this.nom+". J'ai "+this.age+" ans. "+this.monnaie;
    }
    //EX2 Q2:
    public static boolean donne (Personne p1,Personne p2,int montant){
        if(p2.monnaie<montant){
            return false;
        }else{
            p1.monnaie=p1.monnaie+montant;
            p2.monnaie=p2.monnaie-montant;
            return true;
        }
    }
    public boolean donne(Personne receveur,int montant){
        return donne(this,receveur,montant);
    }
    
}