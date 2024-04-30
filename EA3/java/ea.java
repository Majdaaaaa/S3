public class ea {
    public static int rechercheMax(int[] t) {
        int n = t.length;
        int res = t[0];
        for (int i = 1; i < n; i++) {
            if (res < t[i]) {
                res = t[i];
            }
        }
        return res;
    }

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
            if (compteInf(t, i) == ((n - 1) / 2))
                res = t[i];
        }
        return res;
    }

    public static void triDrapeau(int[] t) {
        int p = 0;
        int m = 0;
        int g = t.length - 1;
        while (m <= g) {
            switch (t[m]) {
                case 0:
                    int k = t[m];
                    t[m] = t[p];
                    t[p] = k;
                    m++;
                    p++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    int l = t[m];
                    t[m] = t[g];
                    t[g] = l;
                    g--;
                    break;
            }
        }
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + "," + " ");
        }
        System.out.println();
    }

    public static int fibRec(int n) {
        return fibRecTer(n, 1);
    }

    public static int fibRecTer(int n, int f) {
        if (f == 0) {
            return f;
        } else {
            return fibRecTer(n, f);
        }
    }

    public static int SuiteRec(int n) {
        if (n < 1) {
            return 2;
        } else {
            return 3 * SuiteRec(n - 1) + 4;
        }
    }

    public static int SuiteRecTer(int n) {
        return SuiteRecTerAux(n, 2); // psq 2=a0
    }

    public static int SuiteRecTerAux(int n, int a) {
        if (n < 1) {
            return a;
        } else {
            return SuiteRecTerAux(n - 1, 3 * a + 4);
        }
    }

    public static Liste ARec(Liste lis, Cellule c) {
        if (c.key < c.next.key + 1 && c.next != null) {
            Cellule m = new Cellule(c.key + 1, c.next);
            c.next = m;
            return ARec(lis, c.next);
        } else {
            return lis;
        }
    }

    public static Liste ARec(Liste lis) {
        Cellule tmp = lis.head;
        if (tmp.next == null)
            return lis;
        if (tmp.key == tmp.next.key + 1)
            return lis;
        if (tmp.key >= tmp.next.key + 2) {
            Cellule c = new Cellule(tmp.next.key - 1, tmp.next);
            tmp.next = c;
            return (ARec(lis));
        }
        return null;
    }

    public static Liste mys(Liste lis) {
        Cellule tmp = lis.head;
        while (tmp.next != null & tmp.key < tmp.next.key - 1) {
            Cellule c = new Cellule(tmp.key + 1, tmp.next);
            tmp.next = c;
            tmp = tmp.next;
        }
        return lis;
    }

    public static int PariteLog(int[] T) {
        int deb = 0;
        int fin = T.length - 1;
        int m;
        if (T[fin] % 2 == 0)
            return (fin);
        if (T[deb] % 2 == 1)
            return (deb);
        // le tableau commence par un entier pair et termine par un entier impair
        while ((fin - deb) > 1) {
            m = deb + (fin - deb) / 2;
            if (T[m] % 2 == 0)
                deb = m;
            else
                fin = m;
        }
        return (fin);
    }

    public static int pivot(int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] % 2 != 0) {
                return i;
            }
        }
        return p.length;
    }

    // idee pour proramme logarthmique, crée un tableau avec que les valeurs paire
    // et retourner sa taille == le pivot

    public static int MultiIt(int a, int b) {
        int r = 0;
        while (b > 0) {
            if (b % 2 == 1) {
                r += a;
            }
            a = a * 2;
            b = b / 2;
        }
        return r;
    }

    public static int MultiRecTer(int a, int b) {
        return MultiRecAux(a, b, 0);
    }

    public static int MultiRecAux(int a, int b, int r) {
        if (b > 0) {
            if (b % 2 == 1) {
                return MultiRecAux(a * 2, b / 2, r + a);
            }
            return MultiRecAux(a * 2, b / 2, r);
        } else {
            return r;
        }
    }

    public static Liste suppression(Liste l) {
        if (l.head == null) {
            return null;
        } else if (l.head.next == l.head) {
            l.head = null;
            return l;
        } else {
            Cellule tmp = l.head;
            while (tmp.next != l.head) {
                tmp = tmp.next;
            }
            l.head = l.head.next;
            tmp.next = l.head;
            return l;
        }
    }

    public static int decalage(int[] t) {
        return decalageAux(t, 0, t.length - 1);
    }

    private static int decalageAux(int[] t, int l, int r) {
        if (r < l) {
            return -1;
        }
        int mid = ((l + r) / 2);
        if (t[mid] < t[mid + 1]) {
            return decalageAux(t, mid + 1, r);
        } else if (t[mid] > t[mid + 1]) {
            return decalageAux(t, l, mid - 1);
        }
        return 1;
    }

    public static int func(int[] t, int i) {
        if (i == t.length - 1) {
            return 1;
        }
        if (t[i] <= t[i + 1]) {
            return 1 + func(t, i + 1);
        } else {
            return t[i] + func(t, i + 1);
        }
    }

    public static boolean mystere(int[] t) {
        return func(t, 0) == t.length;
    }

    public static int funRec(int[] t, int i, int j) {
        if (i == t.length - 1) {
            return j;
        }
        if (t[i] <= t[i + 1]) {
            return funRec(t, i + 1, j + 1);
        } else {
            return funRec(t, i + 1, j + t[i]);
        }
    }

    public static int mystereRec(int[] t) {
        return funRec(t, 0, 1);
    }

    public static int MinValleeEsc(int[] t, int l, int r) {
        if (r < l) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (t[mid] < t[mid + 1] && t[mid] < t[mid - 1]) {
            return mid;
        }
        if (t[l] < t[r]) {
            return MinValleeEsc(t, l, mid - 1);
        } else {
            return MinValleeEsc(t, mid + 1, r);
        }
    }

    public static int MinValleeEscRec(int[] t) {
        return MinValleeEsc(t, 0, t.length - 1);
    }

    public static int SigneRec(int[] t, int i) {
        if (t[i] < 0) {
            return i;
        } else {
            return SigneRec(t, i + 1);
        }
    }

    public static int SigneDichIt(int[] p) {
        int n = p.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2;
            if (p[mid] < 0) {
                r = l;
                return mid;
            } else {
                if (p[mid + 1] < 0) {
                    l = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] t = { 2, 1, -3, 5, 4, 8, 6 };
        System.out.println(rechercheMax(t));
        System.out.println(mediane(t));
        int[] l = { 1, 1, 0, 2, 0, 2 };
        triDrapeau(l);
        System.out.println();

        System.out.println(SuiteRec(4));
        System.out.println(SuiteRecTer(4));
        System.out.println();

        Cellule d = new Cellule(8, null);
        Cellule c = new Cellule(6, d);
        Cellule b = new Cellule(5, c);
        Cellule a = new Cellule(1, b);

        Liste lis = new Liste(a);
        // lis.affiche();
        // ARec(lis,lis.head);
        // lis.affiche();

        int[] p = { 2, 4, 6, 8, 1, 3, 5, 7, 9 };
        int[] r = { 1, 3, 5 };
        int[] u = { 2, 4, 6, 8 };
        System.out.println(pivot(p));
        System.out.println(pivot(r));
        System.out.println(pivot(u));
        System.out.println();

        System.out.println(PariteLog(p));
        System.out.println(MultiIt(4, 12));
        System.out.println(MultiRecTer(4, 12));
        System.out.println();

        System.out.println();
        int[] m = { 5, 10, 15, 20, 1, 2 };
        int[] mm = { 5, 6, 1, 2, 3 };
        // System.out.println(decalage(m));

        int[] e = { 3, 4, 5, 6, 7 };
        System.out.println(mystereRec(e));
        System.out.println();

        int[] ee = { 7, 4, 3, 1, 2, 5 };
        int[] eee = { 4, 5, 2, 3, 6, 7 };
        int[] eeee = { 20, 10, 5, 6, 7, 8 };
        System.out.println(MinValleeEscRec(eeee));
        System.out.println();

        int[] s = { 1, 4, 6, 8, -1, -6, -7 };
        int[] ss = { 2, 4, 3, -1, -3, -4 };
        System.out.println(SigneRec(s, 0));
        System.out.println();
        System.out.println(SigneDichIt(s));
    }
}