package Figures;

public class Triangle extends Figure{
    private final double base; 
    private final double hauteur;
    public Triangle(double posX, double posY,double b,double h) {
        super(posX, posY);
        this.base=b;
        this.hauteur=h;
    }

    @Override
    public void affiche() {
        throw new UnsupportedOperationException("Unimplemented method 'affiche'");
    }
        @Override
    public double surface() {
        return this.base*this.hauteur;
    }
    
}
