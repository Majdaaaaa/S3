public class Roturier extends Personne{
    public Roturier(String name,int argent,int pdv) {
        super(name,argent, pdv);
    }

    public String toString(){
        return super.toString()+"Je suis un roturier";
    }
    public Personne enfanter(){
        if(this.age<Personne.majorite){
            return null;
        }
        double role=Math.random();
        if(role< .4){
            return new Pretre("");
        }else if(role < .6){
            return new Paysan("");
        }else if(role< .8){
            return new Artisan("");
        }else{
            return new Bourgeois("");
        }
    }
    @Override
    public Roturier clone() throws CloneNotSupportedException{
        return (Roturier) super.clone();
    }
}