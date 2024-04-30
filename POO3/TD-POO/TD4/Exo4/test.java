package Exo4;

public class test {
    public static void main(String[] args) {
        Batiment b=new Batiment("8 place de la Concorde", 600);
        Maison m=new Maison("13 rue Colbert", 300, 10, 5);//noble(famille de 2)
        Maison m1=new Maison("27 rue blabla", 50, 0, 2);//paysan (famille de 5)
        Batiment[] bat=new Batiment[10]; //tableau de null 
        //faut instanciés explicitement
        bat[0]=m;
        bat[1]=m1;


    }
}
