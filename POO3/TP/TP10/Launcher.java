import java.awt.EventQueue;

public class Launcher {
    public Launcher() {
        ImageEditModel model = new ImageEditModel("vscode.png");
        ImageEditView view = new ImageEditView(model);
        view.pack();
        view.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launcher();
            }
        });

    }
}
