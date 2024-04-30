import java.util.Stack;

public class etoile {
    static int head = 0;
    static int tail = 0;

    // func affiche
    public static void affiche(int[] t) {
        for (int j : t) {
            System.out.print(j + "," + " ");
        }
        System.out.println();
    }

    // TD1
    public static int compteInf(int[] t, int x) {
        int res = 0;
        int n = t.length;
        for (int i = 0; i < n; i++) {
            if (t[i] < x) {
                res++;
            }
        }
        return res;
    }

    public static int mediane(int[] t) {
        int res = 0;
        int n = t.length;
        for (int i = 0; i < t.length; i++) {
            if (compteInf(t, i) == ((n - 1) / 2)) res = t[i];
        }
        return res;
    }

    // TD2
    public static void triDrapeau(int[] t) {
        int p = 0;
        int m = 0;
        int g = t.length - 1;
        while (m <= g) {
            switch (t[m]) {
                case 0:
                    int var = t[p];
                    t[p] = t[m];
                    t[m] = var;
                    m++;
                    p++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    int var2 = t[g];
                    t[g] = t[m];
                    t[m] = var2;
                    g--;
                    break;
            }
        }
        affiche(t);
    }

    public static void triDrapeauBicolore(int[] t) {
        int p = 0;
        int g = t.length - 1;
        while (p <= g) {
            switch (t[p]) {
                case 0:
                    p++;
                    break;
                case 1:
                    int var = t[p];
                    t[p] = t[g];
                    t[g] = var;
                    g--;
                    break;
            }
        }
        affiche(t);
    }

    // TD3:

    public static void fusionTab(int[] a) {
        int[] b = new int[a.length];
        b[0] = a[0];
        int f = 1;
        while (f < b.length && b[f - 1] <= a[f]) { // on recopie dans b le tableau a jusqu’a parvenir à l limite du
            // premier tableau trié
            b[f] = a[f];
            f = f + 1;
        }
        int ia = f;
        int ib = 0;
        int i = 0;
        while (ia < a.length && ib < f) {// tant qu’on est pas arrivé à la fin de b et de a
            // le tableau a est trié jusqu’a i-1 tous les autres elements sont plus grands
            // a partir de ib dans b , on retrouve les elements du premier tableau trié qui
            // n’ont pas encore ete insérés
            // a partir de ia dans a , on retrouve les elements du deuxième r tableau trié
            // qui n’ont pas encore ete insérés
            // on met dans a[i] le plus petit element

            if (a[ia] < b[ib]) {
                a[i] = a[ia];
                ia++;
                i++;
            } else {
                a[i] = b[ib];
                ib++;
                i++;
            }
        }
        while (ia < a.length) { // on recopie la fin de a
            a[i] = a[ia];
            ia++;
            i++;
        }
        while (ib < f) { // on recopie la fin de b
            a[i] = b[ib];
            ib++;
            i++;
        }
        affiche(a);
    }

    // TD4:
    // EXO 2 Q5
    public static int fibRec(int n) {
        return fibRecTer(n, 1, 1);
    }

    public static int fibRecTer(int n, int n1, int n2) {
        if (n == 0 || n == 1) {
            return n2;
        } else {
            return fibRecTer(n - 1, n2, n1 + n2);
        }
    }

    // EXO2 Q6
    public static int fibRecII(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibRecII(n - 1) + fibRec(n - 2);
        }
    }

    public static int fibIt(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int a1 = 1, a2 = 1, tmp = 0;
            for (int i = 2; i <= n; i++) {
                tmp = a1 + a2;
                a2 = a1;
                a1 = tmp;
            }
            return tmp;
        }
    }

    // TD5
    public static boolean pointFixe(int[] t) {
        for (int i = 0; i < t.length; i++)
            if (t[i] == i) return true;
        return false;
    }

    // TD6
    public static Liste fusion(Liste lI, Liste lII) {
        Liste res = new Liste(null);
        if (lI.head != null && lII.head != null) {
            Cellule tmpI = lI.head;
            Cellule tmpII = lII.head;
            while (tmpI != null && tmpII != null) {
                if (tmpI.key < tmpII.key) {
                    res.ajoutfin(tmpI);
                    tmpI = tmpI.next;
                } else {
                    res.ajoutfin(tmpII);
                    tmpII = tmpII.next;
                }
            }
            if (tmpI == null) {
                while (tmpII != null) {
                    res.ajoutfin(tmpII);
                    tmpII = tmpII.next;
                }
            }
            if (tmpII == null) {
                while (tmpI != null) {
                    res.ajoutfin(tmpI);
                    tmpI = tmpI.next;
                }
            }

        } else if (lI.head == null && lII.head != null) {
            return lII;
        } else {
            return lI;
        }
        return res;
    }

    public static Liste triFusion(Liste l, int n) {
        // Pour que ca s'arrete faut se mettre sur des Liste de taille 1 ou faire une
        // fonction qui test si la liste est bien triée
        if (l.head == null) {
            return l;
        } else {
            Liste lI = new Liste(null);
            Liste lII = new Liste(null);
            int i = 0;
            Cellule tmp = l.head;
            while (i < n / 2) {
                lI.ajoutfin(tmp);
                i++;
                tmp = tmp.next;
            }
            while (i < n) {
                lII.ajoutfin(tmp);
                tmp = tmp.next;
                i++;
            }
            return fusion(triFusion(lI, lI.taille()), triFusion(lI, lI.taille()));
        }
    }

    // TD7
    // Q2
    public static int rpn(String[] t) {
        Stack<Integer> p = new Stack<>();
        int res = 0;
        if (!error(t)) {
            System.out.println("Expression fausse.");
            return 0;
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals("-")) {
                while (!p.empty()) {
                    res = p.pop() - res;
                }
            } else if (t[i].equals("+")) {
                while (!p.empty()) {
                    res += p.pop();
                }
            } else if (t[i].equals("*")) {
                while (!p.empty()) {
                    res *= p.pop();
                }
            } else if (t[i].equals("^")) {
                while (!p.empty()) {
                    res = p.pop() ^ res;
                }
            } else {
                p.push(Integer.valueOf(t[i]));
            }
        }
        return res;
    }

    public static boolean error(String[] t) {
        int n = t.length - 1;
        if (t[0].equals("+") || t[0].equals("-") || t[0].equals("^") || t[0].equals("*")) {
            return false;
        }
        for (int i = 0; i < t.length - 1; i++) {
            if ((t[i].equals("+") || t[i].equals("-") || t[i].equals("^") || t[i].equals("*")) && (t[i + 1].equals("+") || t[i + 1].equals("-") || t[i + 1].equals("^") || t[i + 1].equals("*"))) {
                return false;
            }
        }
        if (!(t[n].equals("+") || t[n].equals("-") || t[n].equals("^") || t[n].equals("*"))) {
            return false;
        }
        return true;
    }

    // TD8
    // implémenter les files avec les tableaux
    public static boolean isEmpty(int[] t) {
        return t.length == 0 || t == null || head == tail;
    }

    public static void put(int x, int[] t) {
        if (t[head] == 0) {
            t[head] = x;
            tail++;
        } else {
            t[tail] = x;
            tail++;
        }
    }

    public static int get(int[] t) {
        int res = t[head];
        t[head] = 0;
        head++;
        return res;

    }

    //TD9
    public static Arbre arbrePologne(String[] t) {
        Arbre res = new Arbre(null);
        res.racine = new Noeud(t[t.length - 1], null, null);
        Noeud tmpg = res.racine.filsG;
        Noeud tmpd = res.racine.filsD;
        for (int i = t.length - 2; i < 0; i--) {
            if (t[i] == "+" || t[i] == "-" || t[i] == "*" || t[i] == "^") {
                tmpg = new Noeud(t[i], null, null);
                tmpd = new Noeud(t[i - 1], null, null);
                tmpg = tmpg.filsG;
                tmpd = tmpd.filsD;
            } else {
                tmpg = new Noeud(t[i], null, null);
                tmpg = tmpg.filsG;
            }
        }
        return res;
    }

    //Fonction affiche pour les arbres
    public static void afficheArbre(Noeud n) {
        if (n != null) {
            System.out.println(n.key);
            afficheArbre(n.filsG);
            afficheArbre(n.filsD);
        }
    }

    //TD10
    //Une fonction qui change un arbre binaire en un arbre générale et donne son parcours prefixe
    public static String[] trasfBinGen(Arbre a) {
        String[] res = new String[a.taille()];
        res[0] = a.racine.key;
        res[1] = a.racine.filsG.key;
        Noeud tmpG = a.racine.filsG.filsG;
        Noeud tmpD = a.racine.filsG.filsD;
        for (int i = 0; i < a.taille() - 3; i++) {
            if (tmpD != null) {
                res[i] = tmpD.key;
                tmpD = tmpD.filsD;
            } else if (tmpG != null) {
                res[i] = tmpG.key;
                tmpG = tmpG.filsG;
            }
        }
        return res;
    }

    //Écrire une fonction trasfBinGen qui prend en parametre un arbre binaire sans sous-arbre
    //droit et renvoie le code prefixe décrit en cours de l’arbre général correspondant. Testez cette fontion dans un main
    public static void main(String[] args) {
        // TD1
        System.out.println("TD1:");
        int[] t = {2, 1, -3, 5, 4, 8, 6};
        System.out.println(compteInf(t, 0));
        System.out.println(mediane(t));
        System.out.println();
        // TD2
        System.out.println("TD2:");
        int[] drapeau = {1, 1, 1, 2, 2, 2, 0, 2, 1, 0, 0, 1, 2};
        triDrapeau(drapeau);
        int[] draBico = {1, 0, 0, 1, 1, 0, 1, 0};
        triDrapeauBicolore(draBico);
        System.out.println();
        // TD3:
        System.out.println("TD3:");
        int[] fus = {2, 9, 4, 6, 7, 10};
        fusionTab(fus);
        System.out.println();
        // TD4
        System.out.println("TD4:");
        System.out.println("EXO2 Q5");
        System.out.println(fibRec(5));
        System.out.println("EXO2 Q6");
        System.out.println(fibRecII(5));
        System.out.println(fibIt(5));
        System.out.println();
        // TD5
        System.out.println("TD5:");
        int[] point = {-1, 0, 1, 3, 4, 8};
        int[] pointI = {-1, 0, 1, 2, 3, 4, 5, 6};
        System.out.println(pointFixe(point));
        System.out.println(pointFixe(pointI));
        System.out.println();
        // TD6
        System.out.println("TD6:");
        Cellule d = new Cellule(8, null);
        Cellule c = new Cellule(6, d);
        Cellule b = new Cellule(5, c);
        Cellule a = new Cellule(1, b);
        Liste lis = new Liste(a);
        // triFusion(lis, lis.taille()).affiche();
        System.out.println();
        // TD7
        System.out.println("TD7:");
        String[] r = {"2", "3", "-", "1", "-"};
        System.out.println("c'est faux mais l'idée est la avec la pile");
        System.out.println(rpn(r));
        System.out.println(error(r));
        System.out.println();
        // TD8
        System.out.println("TD8:");
        int[] f = {0, 0, 0, 0, 0};
        System.out.println(isEmpty(f));
        put(3, f);
        put(4, f);
        affiche(f);
        System.out.println(get(f));
        affiche(f);
        //TD9:
        System.out.println("TD9:");
        String[] ar = {"2", "6", "*", "5", "1", "-", "+"};
        afficheArbre(arbrePologne(ar).racine);
        //TD10:
        System.out.println("TD10:");
        System.out.println();
        //TD11:
        System.out.println("TD11:");


    }
}
