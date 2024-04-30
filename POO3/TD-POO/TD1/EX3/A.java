package EX3;
public class A {
    private int attr;
    public A(int value_attr){
        this.attr=value_attr;
    }
    public A(){
        this.attr=0;
    }
    public boolean agal(A b){
        return (this.attr==b.attr);
    }
    public int getAttr(){
        return this.attr;
    }
    public String toString(){
        return "attribut : "+attr+" ";
    }
    public static void exo(){
        A[] t=new A[10];
        for (int i=0;i<t.length;i++){
            System.out.print(t[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
       int[] t=new int [0];
       System.out.println(t);
       exo();
    }
}
