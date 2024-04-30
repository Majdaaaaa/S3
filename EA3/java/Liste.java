
public class Liste {
    Cellule head;
    public Liste(Cellule c){
        this.head=c;
    }

    public void affiche(){
        if(this.head!=null)
            this.head.affiche();
    }
    public void ajoutfin(Cellule c){
        if(this.head==null){
            this.head=c;
        }else{
            this.head.ajoutfin(c);
        }
    }

    public int taille(){
        if(this.head==null){
            return 0;
        }else{
            return this.head.taille();
        }
    }
}
