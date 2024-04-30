public class Archer extends Roturier {
    public Archer(String name, int esperance) {
        super(name, esperance);
    }

    public void attque(Personne p){
        p.blessure(p.pdv);
    }
}
