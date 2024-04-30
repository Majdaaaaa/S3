public class ExempleException {

    public static void main(String[] args) {
        try {
            methodeA();
            //methodeB();
            methodeC();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException attrapée : " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Exception attrapée : " + e.getMessage());
        }
    }

    public static void methodeA() {
        System.out.println("Début de la méthode A");
    }

    public static void methodeB() throws RuntimeException{
        // Lance une exception non vérifiée (RuntimeException)
        throw new RuntimeException("Une exception s'est produite dans methodeB");
    }

    public static void methodeC() throws Exception{
        // Lance une exception vérifiée (Exception)
        throw new Exception("Une exception s'est produite dans methodeC");
    }
}