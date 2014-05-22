import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.net.URL;
 
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
 
import java.awt.event.ActionListener;
 
 
public class Menu extends JPanel {
       
    boolean started = false;
    private Clip musicClip;
        public Menu() {
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
               
                add(Box.createVerticalStrut(320));
                add(Box.createHorizontalStrut(285));
               
                CustomButton button = new CustomButton();
                button.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                start();
                        }
                });
                       
                add(button);
               
                add(Box.createVerticalGlue());
               
                try {
                        URL url = Menu.class.getResource("imperial.wav");
                        AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                        musicClip = AudioSystem.getClip();
                        musicClip.open(audio);
                        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (Exception ex) {
                }
        }
       
        public void start() {
                removeAll();
                musicClip.close();
                started = true;
                repaint();
        }
       
        @Override
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (!started)
                        g.drawImage(new ImageIcon(Menu.class.getResource("background.png")).getImage(), 0, 0, 1085, 558, this);
                else
                        new Bombarian();
        }
       
}