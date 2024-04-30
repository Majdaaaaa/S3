package Exo3;

public class PlanteFleurie extends Plante {
    private static int nbPlanteSansEngrais;
    private boolean engrais = false;

    public PlanteFleurie() {
        nbPlanteSansEngrais++;
    }

    public String toString() {
        if (this.engrais) {
            return (super.toString() + " et j'ai eu de l'engrais"); // on peut pas faire this.super pas possible
        } else {
            return (super.toString() + " et j'ai besoin d'engrais");
        }
    }

    public static String Etat() {
        return Plante.Etat() + "Il y'a " + nbPlanteSansEngrais + " plantes qui ont besoin d'engrais."; // pas besoin de
                                                                                                       // super car
                                                                                                       // methode static
    }

    public static void arosage(PlanteFleurie p) { // surcharge
        Plante.arosage(p);
        if (!p.engrais) {
            p.engrais = true;
            nbPlanteSansEngrais--;
        }
    }

    public void arosage() { // override
        super.arosage();
        if (!engrais) {
            engrais = true;
            nbPlanteSansEngrais--;
        }
    }
}
