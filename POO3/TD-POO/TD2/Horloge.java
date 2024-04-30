public class Horloge {
    private CompteurCyclique heure;
    private CompteurCyclique minute;
    public Horloge(int h,int m){
        heure=new CompteurCyclique(24,h);
        minute=new CompteurCyclique(60,m);
    }
    public void setHeure(int h, int m){
        heure.setValeur(h);
        minute.setValeur(m);
    }
    public void setHeure(int h){ 
        heure.setValeur(h);
        minute.setValeur(0);
        //possible: this.setHeure(h,0);
    }
    public void incrementer(){
        if(minute.incrementer()){ //c'est la fonction de CompteurCyclique
            heure.incrementer();  
        }
    }

    @Override //decorateur (pour la surchage) 
    public String toString(){
        return heure.toStringManuel()+":"+minute.toStringManuel();
    }

}
