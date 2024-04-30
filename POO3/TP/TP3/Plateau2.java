public class Plateau2 {
    private int l,L; //l=longueur L=largeur
    private Case[][] c;
    public Plateau2(int longueur,int largeur){
        this.l=longueur;
        this.L=largeur;
        c=new Case[l][L];
        for(int lo=0;lo<l;lo++){
            for(int la=0;la<L;la++){
                c[lo][la]=new Case();
                if(lo%2==0){
                    if(la%2==0){
                        c[lo][la].setC(true);
                    }else{
                        c[lo][la].setC(false);
                    }
                }else{
                    if(la%2==0){
                        c[lo][la].setC(false);
                    }else{
                        c[lo][la].setC(true);
                    }
                }
            }
        }
    }
    public int getl(){
        return this.l;
    }
    public int getL(){
        return this.L;
    }
    public boolean horsLimite(int x,int y){
        return this.l<x && this.L<y && this.l>=0 && this.L>=0; //return true si c bon et false si c hors limite
    }
    public boolean horsLimite(Deplacement d){
        return true;
    }
    public Case getCase(int x,int y){
        if(horsLimite(x, y)){
            return c[x][y];
        }else{
            return null;
        }
    }
    public void videCase(int x,int y){
        if(horsLimite(x, y)){
            c[x][y].enleverPiece();
        }
    }
    public void remplirCase(int x,int y,Piece p){
        if(horsLimite(x, y)){
            c[x][y].remplirPiece(p);
        }
    }
    public void afficher(){
        for(int lo=0;lo<this.l;lo++){
            for(int la=0;la<this.L;la++){
                System.out.print(c[lo][la]);
            }
            System.out.println();
        }
    }
}
