import java.util.Random;

public class Plateau {
    int hauteur, largeur, nbMines, nbDrapeux;
    private boolean[][] mines;
    private int[][] etats;
    private int[][] adja;

    public Plateau(int ha, int la, int mi) {
        this.hauteur = ha;
        this.largeur = la;
        this.nbMines = mi;
        this.mines = new boolean[ha + 2][la + 2];
        this.etats = new int[ha + 2][la + 2];
        this.adja = new int[ha + 2][la + 2];
        ajouteMinesAlea();
        calculeAdjacence();
    }

    private void ajouteMinesAlea() {
        while (this.nbMines > 0) {
            Random random = new Random();
            int x = random.nextInt(this.largeur) + 2;
            int y = random.nextInt(this.hauteur) + 2;
            if (!this.mines[x][y]) {
                this.mines[x][y] = true;
            }
            this.nbMines--;
        }
    }

    private void calculeAdjacence() {
        for (int i = 1; i < this.hauteur ; i++) { 
            for (int j = 1; j < this.largeur ; j++) {
                if (this.mines[i][j]) {
                    //hori
                    this.adja[i - 1][j]++;
                    this.adja[i+1][j]++;
                    //verti
                    this.adja[i][j - 1]++;
                    this.adja[i][j+1]++;
                    //diagonale
                    this.adja[i + 1][j + 1]++;
                    this.adja[i - 1][j - 1]++;
                }
            }
        }
    }

    public void afficheTout(){
        /*System.out.print(" "+" " );
        for(int i=1;i<largeur+1;i++){
            System.out.print(i+" ");

        }
        System.out.print("\n");
        for(int i=0;i<largeur+2;i++){
            System.out.print("--");
        }
        System.out.print("\n");*/
        for(int h=1;h<this.hauteur;h++){
            System.out.println();
            for (int l=1;l<this.largeur;l++){
                if(this.mines[h][l]){
                    System.out.print("* ");
                }else{
                    System.out.print(this.adja[h][l]+" ");
                }
            }
        }
        System.out.println();
    }

}
