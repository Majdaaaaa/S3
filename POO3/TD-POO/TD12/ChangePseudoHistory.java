import java.util.*;

public class ChangePseudoHistory {
    private static class Pair {
        private String before;
        private String after;

        Pair(String b, String a) {
            before = b;
            after = a;
        }

        public String toString() {
            return this.before + " --> " + this.after + "\n";
        }

    }

    List<Pair> motifications = new LinkedList<Pair>();

    public void infoChange(String x, String y) {
        motifications.add(new Pair(x, y));
    }

    public String toString(){
        String res="";
        for (Pair pair : motifications) {
            res+=pair.toString();
        }
        return res;
    }
}
