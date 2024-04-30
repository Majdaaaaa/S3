import java.util.*;

public class Pseudo {
    private String contenu;

    private List<ChangePseudoHistory> history; // obeservateurs

    Pseudo(String c) {
        this.contenu = c;
        this.history = new LinkedList<>();
    }

    public String getContenu() {
        return contenu;
    }

    public List<ChangePseudoHistory> getHistory() {
        return history;
    }

    public void addHist(ChangePseudoHistory... htab) {
        for (ChangePseudoHistory h : htab) {
            history.add(h);
        }
    }

    public void set(String y){
        for (ChangePseudoHistory h : history) {
            h.infoChange(contenu, y);
        }
        this.contenu=y;
    }

    
}