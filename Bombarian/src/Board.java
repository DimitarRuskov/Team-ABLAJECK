import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.DMUL;

public class Board extends JPanel implements ActionListener{
	
    private Timer timer;
    private Gosho gosho;
    private Image tile;
    
    
    public Board() {
    	addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(new Color(100, 100, 100));
        setDoubleBuffered(true);
        
        ImageIcon tile_im = new ImageIcon(this.getClass().getResource("tile.png"));
        tile = tile_im.getImage();
        
        gosho = new Gosho();
        
        timer = new Timer(15, this);
        timer.start();
    	
    }
    
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        
    	g2d.drawImage(gosho.getImage(), gosho.getX(), gosho.getY(), this);
    	
        String[] map = Map.insertMap();
		for (int yc = 0; yc < 13; yc++) {
			for (int xc = 0; xc < 27; xc++) {
				if (map[yc].charAt(xc)== '1') {
					g2d.drawImage(tile, xc*40, yc*40, null);
				}
			}
		}
        
        ArrayList bm = gosho.getBombs();

        for (int i = 0; i < bm.size(); i++ ) {
            Bomb m = (Bomb) bm.get(i);
            if (bm.size()==1) {
            	g2d.drawImage(m.getImage(), m.getX()-m.getX()%40, m.getY()-m.getY()%40, this);
	
            }
        }
//        Toolkit.getDefaultToolkit().sync();
//        
//        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	ArrayList bm = gosho.getBombs();
    	
        gosho.move();
        repaint();  
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            gosho.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            gosho.keyPressed(e);
        }
    }
}