public class fusion {
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
}
