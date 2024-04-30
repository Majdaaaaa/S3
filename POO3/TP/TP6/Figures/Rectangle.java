package Figures;

public class Rectangle extends Figure implements Deformable{
    private final double largeur;
    private final double hauteur;
    public Rectangle(double posX, double posY,double l,double h) {
        super(posX, posY);
        this.largeur=l;
        this.hauteur=h;
        
    }

    boolean estUnCarre(){
        return this.largeur==this.hauteur;
    }

    Carre toCarre(){
        if(this.estUnCarre()){
            return new Carre(this.getPosX(),this.getPosY(),this.largeur,this.hauteur);
        }else{
            System.out.println("C'est pas  un carrée");
            return null;
        }
    }
    @Override
    public void affiche() {
        System.out.println("je suis un rectangle");
    }
    @Override
    public Rectangle deformation(double coeffH, double coeffV) {
        return new Rectangle (this.getPosX()*coeffH,this.getPosY()*coeffV,this.largeur,this.hauteur);
    }

    @Override
    public double surface() {
        return this.hauteur*this.largeur;
    }
    
    
    

}
