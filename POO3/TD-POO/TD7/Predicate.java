public interface Predicate {
    boolean test(int n);
}

class Predicate1 {
    Predicate p = new Predicate() {
        public boolean test(int n) {
            return n != 0; // ou return n>0; pour "n est positif"
        }
    };
    Predicate p1 = n -> n != 0; // meme code que p, prends n et renvoie n!=0

    public static int[] filter (int[] tab,Predicate pred){
        int n=0; //compteur
        for (int v: tab) { //v pour valeur //evaluation taille du tab
            if(pred.test(v))    
                n++;
        }
        int[] tf=new int[n];
        int k=0;
        for (int i : tf) {
            if(pred.test(i)) //on peut ecrire tf[k++]=i; (perturbant mais col)
                k++;
        }
        return tf;
    }
}
