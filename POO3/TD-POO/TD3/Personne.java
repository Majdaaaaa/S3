public class Personne {
    private String name;
    private int argent=0;
    protected int age;
    private final int esperanceDeVie;
    public static final int majorite=18;
    public Personne(String name,int esperance){
        this.name=name;
        this.esperanceDeVie=esperance;
    }
    public String toString(){
        return "je m'appelle "+this.name+".";
    }
    public int getArgent(){
        return this.argent;
    }
    public void setArgent(int i){
        this.argent=i;
    }
    public void recevoirArgent(int i){
        this.argent+=i;
    }
    public boolean donnerArgent(int i){
        if(this.argent<i){
            return false;
        }else{
            argent-=i;
            return true;
        }
    }
    public boolean anniversaire(){
        if(this.age+1>esperanceDeVie){
            return false;
        }else{
            this.age+=1;
            return true;
        }
    }

}