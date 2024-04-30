public class Pion extends Piece {
    private static String n="pion";
    public Pion(boolean c) {
        super(c, n);
    }
    public boolean estValide(Deplacement d,Plateau p){
        return super.estValide(d, p) ;
    }
    
}
