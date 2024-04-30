import java.util.LinkedList;
import java.lang.Integer;
public class Parking {
    private final Voiture[] places;
    private final LinkedList<Integer> libres; //vu que c'est une liste chainée ca marche tqt 

    Parking(int n){ //n=nombre place
        places=new Voiture[n];
        libres=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            libres.add(Integer.valueOf(i));
        }
    }

    public int prendPlace(Voiture v){
        if(libres.isEmpty()){
            return 0;
        }
        int i=libres.removeFirst().intValue();
        places[i]=v;
        return i;
    }
    public Voiture liberePlace(int i){ //i=place libérable/indice dans tableau de voiture 

        return null;
    }
}
