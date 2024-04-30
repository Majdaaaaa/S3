public class Janvier2018 {

    public static class Q {
        int f(int n) {
            int a = x;
            for (int x = 1; x < n; x++) {
                a = a * x;
            }
            a = a * x;
            return a;
        }

        private int x;

        Q(int x) {
            this.x = x;
        }


    }

    public static class A {
        int c = 0;

        public int getC() {
            return c;
        }
    }

    static class B extends A {
        int c = 1;
    }

    public interface Ab<A, B> {
        B ab(A a);
    }

    public static class Barbara<A, B, C> {
        Ab<Ab<A, B>, Ab<Ab<B, C>, Ab<A, C>>> barbara = (ab1) -> (ab2) -> (a) -> ab2.ab(ab1.ab(a));
// Votre expression lambda ici
    }

    public static void main(String[] args) {
//        int n = 4, m = 4;
//        Q q = new Q(m);
//        System.out.println(q.f(n));
//        B b = new B();
//        A a = b;
//        System.out.print(b.getC() + " ");
//        System.out.println(a.getC());
        Ab<Integer, String> f = i -> Integer.toString(i);
        Ab<String, Character> g = s -> s.charAt(0);
        Barbara<Integer, String, Character> barb =
                new Barbara<Integer, String, Character>();
        int test = 3345;
        char c = barb.barbara.ab(f).ab(g).ab(test); // c doit valoir ’3’
        System.out.println(c);
    }
}
