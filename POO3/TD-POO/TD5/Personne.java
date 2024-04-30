public class Personne {
    protected String nom;
    protected int argent;
    protected int pdv; // les points de vie de la personne

    public Personne(String nom, int argent, int pdv) {
        this.nom = nom;
        this.argent = argent;
        this.pdv = pdv;
    }

    public int getArgent() {
        return argent;
    }

    public void gain(int n) {
        this.argent += n;
    }

    public boolean perte(int n) {
        if (n > this.argent)
            return false;
        this.argent -= n;
        return true;
    }

    public void blessure(int n) {
        if (this.pdv - n <= 0) {
            this.pdv = 0;
            System.out.println("Arg je suis mort.(" + this.nom + ")");
        } else {
            this.pdv -= n;
        }
    }

    public void attaque(Personne p) {
        p.blessure(0);
    }

    public String toString() {
        return "Je m’appelle " + this.nom + ". J’ai " + this.argent + " unités monétaires , et " + this.pdv
                + " points de vie.";
    }
}