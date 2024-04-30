public class C {
    static class A {
        public boolean test(A a) {
            return true;
        }
    }

    static class B extends A {
        public boolean test(B b) {
            return false;
        }
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.println(!a.test(new B()));
        Integer i = 2;
        Integer j = 2;
        System.out.println(i == j);
        String s = "HELLO";
        s.toLowerCase();
        System.out.println(s);
    }
}
