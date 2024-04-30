public class Cellule {
    int key;
    Cellule next;

    public Cellule(int k, Cellule n) {
        this.key = k;
        this.next = n;
    }

    public void affiche() {
        Cellule tmp = this;
        while (tmp.next != this) {
            System.out.print(tmp.key + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void ajoutfin(Cellule c) {
        Cellule tmp = this;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = c;
    }

    public int taille() {
        Cellule tmp = this;
        int res = 0;
        while (tmp != null) {
            res++;
            tmp = tmp.next;
        }
        return res;
    }
}

