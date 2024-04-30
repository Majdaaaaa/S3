public class Palette{
    private Vue view;
    private Modele model;
    private Controleur controleur;
    
    public Palette(){
        model =new Modele();
        view = new Vue(model);
        controleur=new Controleur(model,view);
        view.setVisible(true);
    }


    public static void main(String[] args) {
        new Palette();
    }
}