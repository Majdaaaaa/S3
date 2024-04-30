import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void testAutomate0() {
		Etat[] etats = new Etat[3];
		etats[0] = new Etat(0, false);
		etats[1] = new Etat(1, false);
		etats[2] = new Etat(2, true);
		etats[0].ajouteTransition('a', etats[1]);
		etats[0].ajouteTransition('a', etats[2]);
		etats[1].ajouteTransition('a', etats[1]);
		etats[1].ajouteTransition('c', etats[1]);
		etats[1].ajouteTransition('b', etats[2]);
		Automate a = new Automate(etats[0]);
		System.out.println(a);

		String s = "aaab";
		System.out.println("Mot " + s + " accepté ? " + a.accepte(s));

		Set<Etat> s1 = new HashSet<Etat>();
		s1.add(etats[0]);
		Set<Etat> s2 = new HashSet<Etat>();
		s2.add(etats[1]);
		s2.add(etats[2]);
		Set<Etat> s3 = new HashSet<Etat>();
		s3.add(etats[2]);
		s3.add(etats[1]);
		s3.add(etats[2]);

		System.out.println(" s1 == s2 ? " + s1.equals(s2));
		System.out.println(" s2 == s3 ? " + s2.equals(s3));
		System.out.println(a.alphabet());
		System.out.println(a.estDeterministe());
	}

	public static void testAutomate1() {
		// écrire ici le premier automate de l'énoncé
		Etat[] etats = new Etat[11];
		etats[0]=new Etat(0,false);
		etats[1]=new Etat(1,false);
		etats[2]=new Etat(2,false);
		etats[3]=new Etat(3,false);
		etats[4]=new Etat(4,false);
		etats[5]=new Etat(5,false);
		etats[6]=new Etat(6,false);
		etats[7]=new Etat(7,false);
		etats[8]=new Etat(8,false);
		etats[9]=new Etat(9,false);
		etats[10]=new Etat(10,true);

		etats[0].ajouteTransition('a', etats[0]);
		etats[0].ajouteTransition('b', etats[0]);
		etats[0].ajouteTransition('a', etats[1]);
		for(int i=0;i<10;i++){
			etats[i].ajouteTransition('a', etats[i+1]);
			etats[i].ajouteTransition('b', etats[i+1]);
		}
		Automate A1=new Automate(etats[0]);
		System.out.println(A1.nombreTransitions());
		System.out.println(A1.alphabet());
		System.out.println(A1.estComplet());
		System.out.println(A1.estDeterministe());
		System.out.println(A1.accepte("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	public static void testAutomate2() {
		// écrire ici le second automate de l'énoncé
		Etat[] etats=new Etat[31];
		for(int i=0;i<30;i++){
			etats[i]=new Etat(i,false);
		}
		etats[30]=new Etat(30,true);

		etats[0].ajouteTransition('a', etats[0]);
		etats[0].ajouteTransition('b', etats[0]);
		for(int i=0;i<30;i++){
			etats[i].ajouteTransition('a', etats[i+1]);
			etats[i].ajouteTransition('b', etats[i+1]);
			etats[i].ajouteTransition('a',etats[i]);
			etats[i].ajouteTransition('b',etats[i]);
		}
		etats[30].ajouteTransition('a', etats[30]);
		etats[30].ajouteTransition('b', etats[30]);
		Automate A2=new Automate(etats[0]);
		System.out.println(A2.nombreTransitions());
		System.out.println(A2.alphabet());
		System.out.println(A2.estComplet());
		System.out.println(A2.estDeterministe());
		//System.out.println(A2.accepte("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	public static void main(String[] args) {
		//testAutomate0();
		testAutomate1();
		testAutomate2();
	}
}
