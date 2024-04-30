package Figures;

public class Ellipse extends Figure implements Deformable{
    private final double grand_rayon;
    private final double petit_rayon;
    public Ellipse(double posX, double posY,double g,double p) {
        super(posX, posY);
        this.grand_rayon=g;
        this.petit_rayon=p;
    }

    boolean estUnCercle(){
        return this.grand_rayon==this.petit_rayon;
    }

    Cercle toCercle(){
        if(this.estUnCercle()){
            return new Cercle(this.grand_rayon, this.petit_rayon, this.grand_rayon);
        }else{
            System.out.println("C'est pas une ellipse");
            return null;
        }
    }


    @Override
    public void affiche() {
        throw new UnsupportedOperationException("Unimplemented method 'affiche'");
    }

    @Override
    public Ellipse deformation(double coeffH, double coeffV) {
        return new Ellipse(this.getPosX()*coeffH, this.getPosY()*coeffV, this.petit_rayon, this.grand_rayon);
    }

        @Override
    public double surface() {
        return Math.PI*this.grand_rayon*this.petit_rayon;
    }
    
}
