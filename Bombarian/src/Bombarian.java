import javax.swing.JFrame;

public class Bombarian extends JFrame {

	public static int WIDTH = 1085;
	public static int HEIGHT = 548;
    public Bombarian() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Bombarian");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bombarian();
    }
}