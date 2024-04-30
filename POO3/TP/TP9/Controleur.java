import java.awt.Color;

public class Controleur {
    private Modele m;
    private Vue v;

    public Controleur(Modele m,Vue v){
        this.v=v;
        this.m=m;
    }
    public void sliderMoved(){
        m.c=new Color(v.r.getValue(),v.g.getValue(),v.b.getValue());
        v.miseAJour();
    }
}
