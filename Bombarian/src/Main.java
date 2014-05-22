
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	public Main() {
		JPanel panel = new JPanel();
		
		setTitle("Bombarian");
		
		setSize(Blocks.getWidth(), Blocks.getHeight());
		setResizable(false);
		
		Menu menu = new Menu();
		add(menu);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}

    
}
