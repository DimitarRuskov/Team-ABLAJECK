import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{
	
    private static Timer timer; //the timer for the animation of Gosho
    private Gosho gosho; //the guy we move (Gosho)
    private Image tile; //image of UNBREAKABLE terrain (tiles)
    private Image wall; //image of BREAKABLE walls
    private Image wallExplode; //image of BREAKABLE walls
    private Image door; //image of the door
    private Image enemy; //image of the enemy
    private ArrayList<Enemy> enemies = new ArrayList<>();
    public static ArrayList bm; 
    private int goshoSPEED = 10; //the speed with which Gosho moves
    private static boolean setVisible = true;
    
    public static void stopTimer () {
        timer.stop();
    }
    
    public Board() {
    	addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(new Color(100, 100, 100));
        setDoubleBuffered(true);
        
        //we create the ImageIcon for tiles
        ImageIcon tile_im = new ImageIcon(this.getClass().getResource("tile.png"));
        tile = tile_im.getImage();
        
        //we create the ImageIcon for walls
        ImageIcon wall_im = new ImageIcon(this.getClass().getResource("wall.png"));
        wall = wall_im.getImage();
        
        //we create the ImageIcon for walls
        ImageIcon wall_explode = new ImageIcon(this.getClass().getResource("explode.gif"));
        wallExplode = wall_explode.getImage();
        
        //we create the ImageIcon for walls
        ImageIcon doorII = new ImageIcon(this.getClass().getResource("door.png"));
        door = doorII.getImage();
        
        ImageIcon enemyIm = new ImageIcon(this.getClass().getResource("enemy.png"));
        enemy = enemyIm.getImage();
        
        gosho = new Gosho();
        
        Enemy.insertEnemies();
        
        timer = new Timer(goshoSPEED, this);
        timer.start();
    	
    }
    
    //paint method: everything that happens on the BOARD is painted by this method
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
		
		//draw walls
		int[][] walls = Walls.getWalls();
		for (int yc = 0; yc < 13; yc++) {
			for (int xc = 0; xc < 27; xc++) {
				if (walls[yc][xc] == 1) {
					g2d.drawImage(wall, xc*40, yc*40, null);
				}
				else if (walls[yc][xc] == 2) {
					g2d.drawImage(wallExplode, xc*40, yc*40, null);
				}
				else if (walls[yc][xc] == 8) {
					g2d.drawImage(wall, xc*40, yc*40, null);
				}
				else if (walls[yc][xc] == 9) {
					g2d.drawImage(door, xc*40, yc*40, null);
				}
			}
		}
        
		//draw enemies
		for (int enemyNumber = 0; enemyNumber < 9; enemyNumber++) {
			g2d.drawImage(enemy, Enemy.getX(enemyNumber), Enemy.getY(enemyNumber), this);
		}
						
		//draw bomb
		bm = gosho.getBombs();
        for (int i = 0; i < bm.size(); i++ ) {
            Bomb m = (Bomb) bm.get(i);
            if (bm.size()==1) {
            	if (m.getX()%40 < 20 && m.getY()%40 < 20) {
            		g2d.drawImage(m.getImage(), m.getX()-m.getX()%40, m.getY()-m.getY()%40, this);
            	}
            	else if (m.getX()%40 > 20 && m.getY()%40 > 20) {
            		g2d.drawImage(m.getImage(), m.getX()-m.getX()%40+40, m.getY()-m.getY()%40+40, this);
            	}
            	else if (m.getX()%40 < 20 && m.getY()%40 > 20) {
            		g2d.drawImage(m.getImage(), m.getX()-m.getX()%40, m.getY()-m.getY()%40+40, this);
            	}
            	else if (m.getX()%40 > 20 && m.getY()%40 < 20) {
            		g2d.drawImage(m.getImage(), m.getX()-m.getX()%40+40, m.getY()-m.getY()%40, this);
            	}
            }
        }
        
        //draw Gosho
        if (gosho.getDirection() == 0) {
        	g2d.drawImage(gosho.getImageSTATIC(), gosho.getX(), gosho.getY(), this);
        }
        else if (gosho.getDirection() == 1) {
        	g2d.drawImage(gosho.getImageLEFT(), gosho.getX(), gosho.getY(), this);
        }
        else if (gosho.getDirection() == 2) {
        	g2d.drawImage(gosho.getImageRIGHT(), gosho.getX(), gosho.getY(), this);
        }
        else if (gosho.getDirection() == 3) {
        	g2d.drawImage(gosho.getImageUP(), gosho.getX(), gosho.getY(), this);
        }
        else if (gosho.getDirection() == 4) {
        	g2d.drawImage(gosho.getImageDOWN(), gosho.getX(), gosho.getY(), this);
        }
        
      //draw terrain
        String[] map = Blocks.insertBlock();
		for (int yc = 0; yc < 13; yc++) {
			for (int xc = 0; xc < 27; xc++) {
				if (map[yc].charAt(xc)== '1') {
					g2d.drawImage(tile, xc*40, yc*40, null);
				}
			}
		}
		
        Enemy.move();
        
        //something that is needed for us to sync everything
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    //moving Gosho
    public void actionPerformed(ActionEvent e) {
        gosho.move();
       	repaint();  
    }

    public static ArrayList getBM () {
    	return bm;
    }
    
    //using the keys to move gosho
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            gosho.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            gosho.keyPressed(e);
        }
    }
}