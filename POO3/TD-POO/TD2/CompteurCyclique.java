public class CompteurCyclique {
    private int valeur;
    private final int sup;

    public void setValeur(int valeur){
        this.valeur=((valeur%sup)+sup)%sup;
    }
    public CompteurCyclique(int sup){
        this(sup, 0);
    }
    public CompteurCyclique(int sup,int valeur){
        this.sup=sup;
        setValeur(valeur); //psq faut les valeur correctes
    }
    public int getValeur(){
        return valeur; //on a le droit
    }
    public void reinitialiser(){
        setValeur(0); //ou valeur=0
    }
    public boolean incrementer(){
        valeur=(valeur+1)%sup;
        return valeur==0;
    }
    public String toStringManuel(){ //on veut valeur avec valeur avec le nombre de chiffre de sup
        //sup-1 car si sup=10 on affiche de 0 a 9
        int nbChiffres= Integer.toString(sup-1).length(); //nb de chiffres de sup 
        String valStr=Integer.toString(valeur);
        int nbVal=valStr.length(); //nb de chiffre de valeur
        String padding="";
        //si nbChiffres=nbVal on rentre pas dans la boucle
        for(int i=0;i<nbChiffres-nbVal;i++){
            padding+="0";
        }
        return padding+valStr;
    }//pour valeur=0 affiche 0()

}
