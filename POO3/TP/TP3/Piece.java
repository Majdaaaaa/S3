public class Piece{
    private boolean color;
    private String name;
    public Piece(boolean c,String n){
        this.color=c;
        this.name=n;
    }
    
    public String toString(){
        if(this.color){
            return this.name.substring(0, 1).toLowerCase()+this.name.substring(1);
        }else{
            return this.name.substring(0, 1).toUpperCase()+this.name.substring(1);
        }
    }
    public String getName(){
        if(this.color){
            return this.name.substring(0, 1).toLowerCase()+this.name.substring(1);
        }else{
            return this.name.substring(0, 1).toUpperCase()+this.name.substring(1);
        }
    }
    public boolean estValide(Deplacement d,Plateau2 p){
        return !p.horsLimite(d) &&  p.getCase(d.x1, d.y1)!=null;
    }
}