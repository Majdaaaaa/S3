import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CPHO<P> implements Observer {
    private static class Pair<P> {
        private P before;
        private P after;

        Pair(P b, P a) {
            before = b;
            after = a;
        }

        public String toString() {
            return this.before.toString() + " --> " + this.after.toString() + "\n";
        }

    }

    List<Pair<P>> motifications = new LinkedList<Pair<P>>();

    public void update(Observable o, Object args) {
        try {
            PseudoO<P> o_cast = (PseudoO<P>) o;
            P args_cast = (P) args;
            motifications.add(new Pair<P>(o_cast.getContenu(), args_cast));
        } catch (ClassCastException e) {
            throw new IllegalArgumentException();
        }

    }
    public String toString(){
        String res="";
        for (Pair<P> pair : motifications) {
            res+=pair.toString();
        }
        return res;
    }
}
//utiliser finally : il se lance malgré les erreurs 
