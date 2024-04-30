import java.util.List;
import java.util.function.Function;

public class Main {
    public static <T> void echange(T[] tab, int i, int j) {
        T tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    public static float sumFloat(List<? extends Number> list) {
        float x = 0;
        for (Number y : list)
            x += y.floatValue();
        return x;
    }

    public static void main(String[] args) {
        Individu i = new Individu(true, 1998, 7);
        Function<Individu, Carte> res = (individu) -> {
            String a = "";
            if (individu.femme) {
                a += 2;
            } else {
                a += 1;
            }
            a += individu.anneeNaissance;
            a += individu.moisNaissance;
            int carte = Integer.parseInt(a);
            return new Carte(carte);
        };
        System.out.println(res.apply(i).numero);
        Integer[] tab = {1, 2, 3, 4, 5};
        echange(tab, 0, 1);

    }

}