package EX1;
public class Test {
    public static void main(String[] args) {
        Personne tony=new Personne("Parker", "Tony", 29,10000);
        System.out.println(tony);
        Personne mickael=tony; //tony et mickael sont un meme objet 
        mickael.setPrenom("Mickael"); //modifié mickael c'est modifié tony car meme objet 
        //Q2:
        mickael.setNom("Gelabale"); 
        System.out.println(tony); //== System.out.println(tony.toString());
        //EX2 Q2:
        Personne alex=new Personne("Karev", "Alex", 29,20000);
        Personne.donne(alex,tony,100);
        alex.donne(tony,100);
        System.out.println(alex);
        System.out.println(tony);


    }
    //Q1: Je m'appelle :Tony Parker. J'ai 20 ans.
        //Je m'appelle :Mickael Parker. J'ai 20 ans.
    //Q3 : OUI psq a l'interieur de la classe 
}
