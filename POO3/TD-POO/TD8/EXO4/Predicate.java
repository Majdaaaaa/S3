package EXO4;

public interface Predicate {
    public boolean test(int n);

    public static int[] filter(int[] tab, Predicate pred) {
        int nbElts = 0;
        for (int n : tab)
            nbElts += (pred.test(n)) ? 1 : 0;
        int i = 0;
        int[] res = new int[nbElts];
        for (int n : tab) {
            if (pred.test(n))
                res[i++] = n;
        }
        return res;
    }

}
