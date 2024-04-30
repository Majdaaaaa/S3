import java.util.Scanner;

public class test {
    public static void main(String[] args)  {
        FichierTexte t=new FichierTexte();
        t.editer(new Scanner(System.in), true);
        t.afficher();
    }
}
