package Figures;

public abstract class Figure{
    private double posX;  // Position sur l’axe horizontal
    private double posY;  // Position sur l’axe vertical

    public Figure(double posX,double posY){
        this.posX=posX;
        this.posY=posY;
    }

    public final double getPosX(){
        return this.posX;
    }

    public final double getPosY(){
        return this.posY;
    }

    public abstract void affiche();
    
    public double estDistantDe(Figure fig){
            return (this.getPosX()+fig.getPosX())+(this.getPosY()+this.getPosY());
    }
    
    public abstract double surface();
}