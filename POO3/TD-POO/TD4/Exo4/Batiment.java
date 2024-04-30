package Exo4;

public class Batiment { 
    private double surfaceHabitable; //peut etre float pour plus de precision
    private String adresse;
    public Batiment(String a,double s){
        this.adresse=a;
        this.surfaceHabitable=s; //ici besoin this psq constructeur
    }
    public String toString(){
        return "l'adress: "+ adresse+" la surface habitable: "+ surfaceHabitable; //pas besoin de this
    }
    public double getSurface(){
        return surfaceHabitable; //pas besoin de this
    }
    
    

}
