import java.util.*;

public class PseudoGen<T> {
    private T contenu;

    private List<ChangePseudoHistoryGen<T>> history; // obeservateurs

    PseudoGen(T c) {
        this.contenu = c;
        this.history = new LinkedList<>();
    }

    public void addHist(ChangePseudoHistoryGen<T> htab) {
        history.add(htab);
    }

    public void set(T y) {
        for (ChangePseudoHistoryGen<T> h : history) {
            h.infoChange(contenu, y);
        }
        this.contenu = y;
    }

}