public class Noble extends Personne {
    public static final int esperanceDeVie=66;
    public Noble(String name) {
        super(name, esperanceDeVie);
    }

    public String toString(){
        return super.toString()+"Je suis un noble";
    }
    public boolean donnerArgent(int i){
        this.setArgent(this.getArgent()-i);
        return true;
    }
    public Personne enfanter(){
        if(this.age<Personne.majorite){
            return null;
        }
        double role=Math.random();
        if(role < .5){
            return new Noble("");
        }else{
            return new Pretre("");
        }
    }
}
