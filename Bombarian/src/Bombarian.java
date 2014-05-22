import javax.swing.JFrame;

public class Bombarian extends JFrame {
    public Bombarian() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Blocks.getWidth(), Blocks.getHeight());
        setLocationRelativeTo(null);
        setTitle("Bombarian");
        setResizable(false);
        setVisible(true);
    }
}