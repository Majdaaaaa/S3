public class test {
    public static void main(String[] args) {
        Pseudo a=new Pseudo("a");
        Pseudo b=new Pseudo("b");
        Pseudo c=new Pseudo("c");
        Pseudo d=new Pseudo("d");

        PseudoGen<String> aa=new PseudoGen<String>("a");
        ChangePseudoHistoryGen<String> h_aab=new ChangePseudoHistoryGen<String>();

        ChangePseudoHistory h_ab=new ChangePseudoHistory();
        ChangePseudoHistory h_bc=new ChangePseudoHistory();

        a.addHist(h_ab);
        b.addHist(h_ab,h_bc);
        c.addHist(h_bc);

        a.set("a1");
        b.set("b1");
        a.set("a2");
        c.set("c1");
        d.set("d1");

        System.out.println(h_ab);
        System.out.println(h_bc);
    }

}
