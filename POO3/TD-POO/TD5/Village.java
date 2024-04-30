import java.util.LinkedList;

public class Village implements Cloneable{ //pour pouvoir faire des copies (des bonnes copies attributs par attributs )
    LinkedList<Roturier> hab;
    public Village(LinkedList<Roturier> h){
        this.hab=h;
    }
    public int volArgent(){
        int somme =0;
        for(int i=0;i<hab.size();i++){
            Personne h=hab.get(i);
            int vol=h.getArgent()/2;
            if(h.perte(vol)){
                somme+=vol;
            }
        }
        return somme;
    }
    @Override
    public Village clone() throws CloneNotSupportedException{
        LinkedList<Roturier> habCopy=new LinkedList<Roturier>();
        for (Roturier roturier : hab) {
            habCopy.add(roturier.clone());
        }
        Village vClone=(Village) super.clone();
        vClone.hab=habCopy;
    }
}
