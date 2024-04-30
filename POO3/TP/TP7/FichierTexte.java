import java.util.Scanner;

public class FichierTexte extends Element2 implements Affichable, Editable{
    String contenue;

    
    @Override
    public String getType() {
        return "texte";
    }


    @Override
    public void afficher() {
        System.out.println(this.contenue);
    }


    @Override
    public void editer(Scanner sc, boolean echo) {
        String l=sc.nextLine();
        String aux="";
        while(l.charAt(0)!='.' ){
            aux+=l+" "+"\n";
            if(echo){
                System.out.println(l+"\n");
            }
            l=sc.nextLine();
        }
        aux.substring(aux.length()-2, aux.length()-1);
        this.contenue=aux;
        sc.close();
    }
    
}
