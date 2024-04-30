import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.MouseMotionListener;

public class ImageEditView extends JFrame {
    private JButton cutButton, undoButton, redoButton;
    private ImagePane imagePane;
    private ImageEditModel model;

    public class ImagePane extends JPanel {
        private Selection selection = new Selection();

        public ImagePane() {
            this.setPreferredSize(new Dimension(model.getImage().getWidth(), model.getImage().getHeight()));
            addMouseListener(selection);
            addMouseMotionListener(selection);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(model.getImage(), 0, 0, this);
            ((Graphics2D)g).draw(selection.getRectangle());
        }

        public class Selection extends MouseAdapter {
            private int x1, y1, x2, y2;

            public Rectangle getRectangle() {
                return new Rectangle(x1, y1, x2 - x1, y2 - y1);
            }

            public void mousePressed(MouseEvent event) {
                this.x1 = event.getX();
                this.y1 = event.getY();
                cutButton.setEnabled(false);
                repaint();
            }

            public void mouseDragged(MouseEvent event) {
                this.x2=event.getX();
                this.y2=event.getY();
                cutButton.setEnabled(true);
                repaint();
            }   

            public void MouseEvent(MouseEvent event){

            }
        }
    }

    public ImageEditView(ImageEditModel m){
        this.model=m;
        this.setTitle("Image Edit");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menu=new JMenuBar();

        cutButton=new JButton("Cut");
        undoButton=new JButton("Undo");
        redoButton=new JButton("Redo");

        cutButton.setEnabled(false);
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);

        menu.add(cutButton);
        menu.add(undoButton);
        menu.add(redoButton);

        this.setJMenuBar(menu);
        imagePane=new ImagePane();
        this.setContentPane(imagePane);

    }
}
