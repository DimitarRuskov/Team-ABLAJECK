import java.awt.*;
import java.awt.event.ActionEvent;
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
 
 
public class EndScreen extends JPanel {
       
        boolean restarted = false;
       
        public EndScreen() {
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
               
                add(Box.createVerticalStrut(320));
                add(Box.createHorizontalStrut(285));
               
                CustomButton button = new CustomButton();
                button.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                restart();
                        }
                });
                       
                add(button);
               
                add(Box.createVerticalGlue());
               
                try {
                        URL url = EndScreen.class.getResource("die.wav");
                        URL url2 = EndScreen.class.getResource("endscreen.wav");
                        AudioInputStream die = AudioSystem.getAudioInputStream(url);
                        AudioInputStream endScreen = AudioSystem.getAudioInputStream(url);
                        Clip musicClip = AudioSystem.getClip();
                        musicClip.open(die);
                        musicClip.open(endScreen);
                } catch (Exception ex) {
                }
        }
       
        public void restart() {
                removeAll();
                restarted = true;
                repaint();
        }
       
        @Override
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (!restarted)
                        g.drawImage(new ImageIcon(Menu.class.getResource("background.png")).getImage(), 0, 0, 1085, 558, this);
                else
                        new Bombarian();
        }
       
}