public class Case {
    private boolean color; //true = blanc false= noir
    private Piece piece;
    public Piece getPiece(){
        return this.piece;
    }
    public boolean estVide(){
        return (this.piece==null); 
    }
    public void remplirPiece(Piece p){
        if(this.estVide()){
            this.piece=p;
        }
    }
    public void enleverPiece(){
        if(!this.estVide()){
            this.piece=null;
        }
    }
    public String toString(){
        if(this.estVide() && this.color){
            return ".";
        }else if(this.estVide() && !this.color){
            return "#";
        }else{
            return this.piece.getName().substring(0,1);
        }
    }
    public void setC(boolean c){
        this.color=c;
    }
}
