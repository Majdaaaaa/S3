package EXO2;
public interface I{
    default void m(){
        System.out.println("I.m");
    }
    void n();
}