public class exam {
    //TD2 : EX3
    //Q1
    public static int plusGrand(int[] t){
        int res=0;
        for (int i = 0; i < t.length; i++) {
            if(res<t[i]){
                res=t[i];
            }
        }
        return res;
    }

    public static int plusGrandII(int[] t){
        int res=0;
        for (int i = 0; i < t.length-1; i++) {
            if(t[i]>res){
                res=t[i];
            }
            if(t[i+1]>res)
                res=t[i+1];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] t={0,1,6,8,10,6,4,11};
        System.out.println(plusGrandII(t));
    }
}
