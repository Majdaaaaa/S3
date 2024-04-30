import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class InterfaceJoueur extends JFrame{
    private static Color[] palette=new Color[]{new Color(176,176,179)};
    private final static Dimension d =new Dimension(800,700);

    private JButton[][] boff=new JButton[Grille.DIM][Grille.DIM];
    private JButton[][] button;

    public InterfaceJoueur(Jeu jeu){
        JPanel panneauOffense=new JPanel();
        panneauOffense.setLayout(new GridLayout(Grille.DIM,Grille.DIM));
        
    }

}
