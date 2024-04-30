public class Arbre {
    Noeud racine;

    public Arbre() {
        this.racine = null;
    }

    public Arbre(Noeud r) {
        this.racine = r;
    }

    public Arbre Vide() {
        return new Arbre();
    }

    public int taille() {
        if (this != null) {
            return this.racine.taille();
        } else {
            return 0;
        }
    }
}
