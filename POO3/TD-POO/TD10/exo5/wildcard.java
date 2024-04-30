package exo5;

import java.util.List;
//? utilisable que si on a pas besoin de recuperer les trucs 
//? type inconnu

public class wildcard {
    static void print(List<?> l){
        for (Object o : l) {
            System.out.println(o);
        }
    }
    //1. Parce que <?> ne nous fournit aucune info sur le type de l a part qu'il herite de Object
    //2. null c'est compatible avec tout les objets
}
