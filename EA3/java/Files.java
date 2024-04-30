public class Files {
    static int head=0;
    static int tail=0;
    public static void affiche(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + "," + " ");
        }
        System.out.println();
    }


    public static boolean isEmpty(int[] t) {
        return t.length==0 || t==null || head==tail ; 
    }
    public static void put(int x,int[] t){ 
        if(t[head]==0){
            t[head]=x;
            tail++;
        }
        else{
            t[tail]=x;
            tail++;
        }
    }
    public static int get(int[] t){
        int res=t[head];
        t[head]=0;
        head++;
        return res;
        
    }
    public static void main(String[] args) {
        int N=10;
        int[] f=new int[N];
        // // System.out.println(head);
        // // System.out.println(tail);
        // affiche(f);
        // System.out.println(isEmpty(f));
        // // System.out.println(head);
        // // System.out.println(tail);
        // put(3,f);
        // affiche(f);
        // // System.out.println(head);
        // // System.out.println(tail);
        // put(4,f);
        // affiche(f);
        // // System.out.println(head);
        // // System.out.println(tail);
        // affiche(f);
        // // System.out.println(head);
        // // System.out.println(tail);
        // System.out.println(get(f));
        // // System.out.println(head);
        // // System.out.println(tail);
        // System.out.println(isEmpty(f));
        // // System.out.println(head);
        // // System.out.println(tail);
        // affiche(f);
        put(4,f);
        affiche(f);
        put(3,f);
        put(5,f);
        put(6,f);
        put(7,f);
        put(8,f);
        get(f);
        get(f);
        get(f);
        get(f);
        get(f);
        get(f);
        affiche(f);
        System.out.println(head);
        System.out.println(tail);
        System.out.println(isEmpty(f));
        
    }
}
