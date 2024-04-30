import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Arbre {
    public class Noeud {
        private String nom;
        private int taille;
        private boolean repertoire;
        private ArrayList<Noeud> fils;

        public Noeud(File f) throws FileNotFoundException {
            if (!f.exists()) {
                throw new FileNotFoundException();
            } else {
                this.nom = f.getName();
                this.taille = (int) f.length();
                this.repertoire = f.isDirectory();
                if (repertoire) {
                    this.fils = new ArrayList<Noeud>();
                    for (File file : f.listFiles()) {
                        this.fils.add(new Noeud(file));
                    }
                }
            }
        }
    }

    Noeud racine;

    public Arbre(String chemin) {
        
    }
}
