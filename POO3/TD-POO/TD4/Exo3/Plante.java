package Exo3;

public class Plante {
    private static int nbPlanteSoif;
    private boolean arosee = false;

    public Plante() {
        nbPlanteSoif++;
    }

    public String toString() {
        if (this.arosee) {
            return "j'ai été arrosée";
        } else {
            return "j'ai soif";
        }
    }

    public static String Etat() { // psq nbPlanteSoif est static donc Etat() est statique
        return "il y'a " + nbPlanteSoif + " plantes qui ont soifs. ";
    }

    public static void arosage(Plante p) {
        if (!p.arosee) {
            p.arosee = true;
            nbPlanteSoif--;
        }
    }

    public void arosage() { // sans this
        if (!arosee) {
            arosee = true;
            nbPlanteSoif--;
        }
    }

}