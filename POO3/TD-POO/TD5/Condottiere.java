import java.util.LinkedList;

public class Condottiere extends Personne {
    LinkedList<Archer> arch = new LinkedList<Archer>();
    LinkedList<Fantassin> fan = new LinkedList<Fantassin>();

    public Condottiere(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
        arch.add(new Archer("tom",34));// sol n°1 : on a pas a verifier la liste
        
    }

    public void attaque(Village v) {
        int vol = v.volArgent();
        int m = vol / 2;
        // tu verifie si ya des gens et si ya pas le condottiere prends tout
        // Condottier:
        this.gain(m);
        int nb = arch.size() + fan.size();// nombre de gens dans la compagnie
        int part = m / nb;
        for (int i = 0; i < arch.size(); i++) {
            arch.get(i).gain(part);
        }
        for (int i = 0; i < fan.size(); i++) {
            fan.get(i).gain(part);
        }
    }
    
}