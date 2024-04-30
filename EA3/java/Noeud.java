

public class Noeud {
    String key;
    Noeud filsG;
    Noeud filsD;

    public Noeud(String k) {
        this.key = k;
        this.filsG = null;
        this.filsD = null;
    }

    public Noeud(String k, Noeud fg, Noeud fd) {
        this.key = k;
        this.filsG = fg;
        this.filsD = fd;
    }

    public void affiche(Noeud r) {
        //Affiche l'arbre en parcours postfixe
        if (r != null) {
            affiche(r.filsG);
            affiche(r.filsD);
            System.out.println(r.key);
        }

    }

    public int taille() {
        if (this != null) {
            return 1 + this.filsG.taille() + this.filsD.taille();
        } else {
            return 0;
        }
    }
}
