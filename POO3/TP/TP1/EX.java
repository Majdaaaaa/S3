public class EX{
    public static void affiche(int[] t){
        for (int i=0;i<t.length;i++){
            System.out.print(t[i]+" ");
        }
        System.out.println("");
    }
    public static int[] multiplication(int[]t1,int[]t2){
        int[] t3=new int[Math.max(t1.length,t2.length)];
        if(t1.length < t2.length){
            for(int i=0;i<t1.length;i++){
                t3[i]=t1[i]*t2[i];
            }
            for(int i=t1.length;i<t2.length;i++){
                t3[i]=t2[i];
            }
        }else{
            for(int i=0;i<t2.length;i++){
                t3[i]=t2[i]*t1[i];
            }
            for(int i=t2.length;i<t1.length;i++){
                t3[i]=t1[i];
            }
        }
        return t3;
    }

    public static int[] split(int[]t){
        int taille=0;
        for(int i=0;i<t.length;i++){
            String a=String.valueOf(t[i]);
            if(a.length()>1){
                taille+=a.length();
            }else{
                taille+=1;
            }
        }
        int[] tPrime=new int[taille];
        for (int i=0;i<t.length;i++){
            String p=String.valueOf(t[i]);
            if(p.length()<=1 && tPrime[i]==0){
                tPrime[i]=t[i];
            }else if(tPrime[i]!=0 && p.length()>1){
                tPrime[i+p.length()-1]=Character.getNumericValue(p.charAt(0));
                tPrime[i+p.length()]=Character.getNumericValue(p.charAt(1));
            }else if(tPrime[i]!=0 && p.length()<=1){
                tPrime[i+p.length()+1]=t[i];
            }
            else{
                tPrime[i]=Character.getNumericValue(p.charAt(0));
                tPrime[i+p.length()-1]=Character.getNumericValue(p.charAt(1));
            }
        }
        return tPrime;
    }
    public static void main(String[] args) {
        int i =args.length;
        System.out.println(i);
        //javac EX.java
        //java EX il fait beau = 3 
        String a = "llll";
        System.out.println(a.length());
        int [] t= {0,1,2,3,4};
        affiche(t);
        int[] t1={12,33,6,7};
        int[] t2={2,4,6,2};
        int[] t3={2,12,36,7};
        affiche(multiplication(t1, t2));
        affiche(split(t3));
    }
}