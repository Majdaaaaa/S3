package Exo3;

public class test {
    public static void main(String[] args) {
        Plante[] serre = new Plante[5];
        serre[0] = new Plante();
        serre[1] = new PlanteFleurie();
        serre[2] = new Plante();
        serre[3] = new PlanteFleurie();
        serre[4] = new Plante();
        System.out.println(Plante.Etat());
        System.out.println(PlanteFleurie.Etat());
        for (int i = 0; i < 5; i++) {
            Plante.arosage(serre[i]); // remplacer par PlanteFleurie.arosage(serre[i]) ne change rien psq tout les
                                      // plante se comporte comme des Plante pas fleurie donc elles utilisent les
                                      // methode de la classe mere
            // reponse question 6: 
            serre[i].arosage();
            System.out.println(serre[i]);
        }
        System.out.println(Plante.Etat());
        System.out.println(PlanteFleurie.Etat());
    }
}