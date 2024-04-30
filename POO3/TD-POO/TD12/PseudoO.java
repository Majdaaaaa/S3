//EXO4

import java.util.*;

public class PseudoO<P> extends Observable {
    private P contenu;
    

    private List<CPHO<P>> obeservateurs;

    PseudoO(P c) {
        this.contenu = c;
        this.obeservateurs = new LinkedList<>();
    }
    public P getContenu() {
        return contenu;
    }

    public void set(P new_c){
        P var=contenu;
        contenu=new_c;
        setChanged();
        notifyObservers(var);
    }
}
