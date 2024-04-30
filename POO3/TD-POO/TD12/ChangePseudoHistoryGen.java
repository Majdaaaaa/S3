import java.util.*;

public class ChangePseudoHistoryGen<T> {
    private static class Pair<T> {
        private T before;
        private T after;

        Pair(T b, T a) {
            before = b;
            after = a;
        }

        public String toString() {
            return this.before.toString() + " --> " + this.after.toString() + "\n";
        }

    }

    List<Pair<T>> motifications = new LinkedList<Pair<T>>();

    public void infoChange(T x, T y) {
        motifications.add(new Pair<T>(x, y));
    }

    public String toString(){
        String res="";
        for (Pair<T> pair : motifications) {
            res+=pair.toString();
        }
        return res;
    }
}
