package EXO3;
public class Cercle extends Figure{
    private double rayon;
    
    public Cercle(double x,double y,double r){
        super(x,y);
        //sans message
        if(r<0){
            throw new IllegalArgumentException(); //pas besoin de classe
        }
        this.rayon=r;
    }

    @Override
    public boolean contient(Figure f){
        if(f instanceof Cercle){
            double dx=this.getCentreX()-f.getCentreX(); //diffrence x
            double dy=this.getCentreY()-f.getCentreY(); //diff des centres en x et y
            Cercle c=(Cercle) f; //psq f de base se comporte comme une figure et non un cercle
            return Math.hypot(dx, dy)+c.rayon<=this.rayon;
        }if(f instanceof Rectangle){
            Rectangle r=(Rectangle) f; 
            return this.contient(r.cercleCirconscrit());
        }else{
            throw new UnsupportedOperationException("j pas fais deso "); //on peut ne pas mettre de message
        }
    }
    public boolean contient(double x,double y) { 
        return Math.hypot(x-this.getCentreX(), y-this.getCentreY())<=this.rayon;
    }
    public Figure intersection(Figure f) {
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }
    
    /*public Rectangle rectangleCirconscrit(){
        double r=Math.sqrt(); 
        return new Rectangle(this.getCentreX(),this.getCentreY(),r);
        
    }*/

}
