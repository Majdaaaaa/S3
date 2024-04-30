package Exo4;
public class Maison extends Batiment {
    private int nbPieces;
    private double surfaceJardin;
    public Maison(String a,double sH,double sJ,int nb){
        super(a,sH);
        this.surfaceJardin=sJ;
        this.nbPieces=nb;
    }
    public String toString(){
        return super.toString()+" surface jardin "+surfaceJardin+" nombre de pieces "+nbPieces;
    }
    public double getSurfaceJ(){
        return surfaceJardin;
    }
}
