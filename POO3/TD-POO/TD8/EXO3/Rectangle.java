package EXO3;
public class Rectangle extends Figure{
    private double largeur, hauteur;

    public Rectangle(double x,double y, double l, double h){
        super(x,y);
        if(l<0 || h<0){
            throw new IllegalArgumentException();
        }
        this.hauteur=h;
        this.largeur=l;
    }

    @Override
    public boolean contient(Figure f) {
        throw new UnsupportedOperationException("Unimplemented method 'contient'");
    }

    @Override
    public Figure intersection(Figure f) {
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }

    public Cercle cercleCirconscrit(){
        double r=Math.sqrt(largeur*largeur+hauteur*hauteur); 
        return new Cercle(this.getCentreX(),this.getCentreY(),r);

    }

}
