import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {
    public JPanel panneauColore = new JPanel();
    public Modele model;
    public JLabel etiqCouleur = new JLabel("Violet");
    public Controleur controleur;
    public JPanel slider = new JPanel(new GridLayout(3, 1));
    public JPanel buttons = new JPanel(new GridLayout(1, 3));
    JSlider r = new JSlider(0, 255);
    JSlider b = new JSlider(0, 255);
    JSlider g = new JSlider(0, 255);
    public Vue(Modele model) {
        this.model=model;
        controleur=new Controleur(model,this);
        this.setTitle("Palette");
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Color violet = new Color(150, 0, 100);
        panneauColore.setBackground(violet);
        panneauColore.setLayout(new BorderLayout());
        etiqCouleur.setHorizontalAlignment(JLabel.CENTER);
        panneauColore.add(etiqCouleur, BorderLayout.CENTER);

        JPanel panneauChoix = new JPanel(new BorderLayout());
        this.getContentPane().setLayout(new GridLayout(1, 2));

        this.getContentPane().add(panneauChoix);
        this.getContentPane().add(panneauColore);

        JButton m = new JButton("Mémoriser");
        JButton s = new JButton("S'en rappeler");
        JButton c = new JButton("Complémentaire");

        r.setName("Rouge");
        r.setPaintTicks(true);
        r.setPaintLabels(true);
        r.setMajorTickSpacing(50);
        r.setMinorTickSpacing(5);

        g.setName("Vert");
        g.setPaintTicks(true);
        g.setPaintLabels(true);
        g.setMajorTickSpacing(50);
        g.setMinorTickSpacing(5);

        b.setName("Bleu");
        b.setPaintTicks(true);
        b.setPaintLabels(true);
        b.setMajorTickSpacing(50);
        b.setMinorTickSpacing(5);

        slider.add(r);
        slider.add(g);
        slider.add(b);

        buttons.add(m);
        buttons.add(s);
        buttons.add(c);

        panneauChoix.add(slider, BorderLayout.CENTER);
        panneauChoix.add(buttons, BorderLayout.SOUTH);

        r.addChangeListener((event)->{
            controleur.sliderMoved();
        });
        g.addChangeListener((event)->{
            controleur.sliderMoved();
        });
        b.addChangeListener((event)->{
            controleur.sliderMoved();
        });
    }

    public void miseAJour() {
        Color c = model.getColor();
        panneauColore.setBackground(c);
        etiqCouleur.setText(String.format(("#%02x%02x%02x"),model.getColor().getRed(),model.getColor().getGreen(),model.getColor().getBlue()));
    }



}