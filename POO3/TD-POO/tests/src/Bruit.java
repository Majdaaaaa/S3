public class Bruit {
    public static void main(String[] args) {
        Portable tel = new Portable();
        Sonnerie s1 = new Sonnerie();
        DoubleSonnerie s2 = new DoubleSonnerie();
        Sonnerie s3 = new DoubleSonnerie();
        tel.sonne(s1);
        System.out.println(((Sonnerie)s2).getClass());
        tel.sonne((Sonnerie) s2);
        tel.sonne(s2);
        tel.sonne(s3);
    }
}