import java.util.Random;

public class Societe {
    private Personne[] personnes;
    //refaure avec linkedList
    public Societe(int n) {
        Personne[] personnes = new Personne[n];
        double intervalle[] = { 0.1, 0.2, 0.5, 0.8 };
        personnes = new Personne[n];
        for (int i = 0; i < n; i++) {
            double role = Math.random();
            Random r = new Random();
            int argent = r.nextInt(100);
            if (role <= intervalle[0]) {
                personnes[i] = new Noble("Noble" + i);
            } else if (role <= intervalle[1]) {
                personnes[i] = new Pretre("Pretre" + i);
            } else if (role <= intervalle[2]) {
                personnes[i] = new Paysan("Paysan" + i);
            } else if (role <= intervalle[3]) {
                personnes[i] = new Artisan("Artisan" + i);
            } else {
                personnes[i] = new Bourgeois("Bourgeois" + i);
            }
            personnes[i].setArgent(argent);
        }
    }
    public String toString(){
        String res="";
        for(int i=0;i<personnes.length;i++){
            res+=personnes[i].toString()+"\n";
        }
        return res;
    }
    public int argentTotal(){
        int res=0;
        for(int i=0;i<personnes.length;i++){
            res+=personnes[i].getArgent();
        }
        return res;
    }

}
