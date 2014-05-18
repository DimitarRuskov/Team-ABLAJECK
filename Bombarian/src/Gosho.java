
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import java.util.Timer;

public class Gosho {
	
	private String gosho = "gosho.png"; //address of Gosho
    private int dx; //temporary mask variable for x
    private int dy; //temporary mask variable for y
    private int goshoX; //coordinates of the TOP-LEFT corner of gosho image
    private int goshoY; //coordinates of the TOP-LEFT corner of gosho image
    private Image image_gosho; //image of Gosho
    private ArrayList bombs; //new ArrayList for the bombs
    private static int timeForBomb = 4; //the time after which bombs explode
    private int[][] tilesPositions = Map.getTilePositions(); //int[][] var for the tiles
    private int[][] wallsPositions = Walls.getWallPositions(); //int[][] var for the walls
    private int direction = 0; //direction at which Gosho is moving (1-left, 2-right, 3-up, 4-down)
    
    public Gosho() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(gosho));
        image_gosho = ii.getImage();
        bombs = new ArrayList();
        //starting position of Gosho:
        goshoX = 41;
        goshoY = 41;
    }
    
    public void move() {
    	//move left
    	if (direction==1 && goshoX%40>0) {
    		goshoX += dx;
    	}
    	else if (checkFree.left(tilesPositions, goshoY, goshoX) == true && checkFree.left(wallsPositions, goshoY, goshoX) == true  && direction==1) {
    		goshoX += dx;
    	}
    	//move right
    	if (checkFree.right(tilesPositions, goshoY, goshoX) == true && checkFree.right(wallsPositions, goshoY, goshoX) == true && direction==2){
    		goshoX += dx;
    	}
    	//move up
    	if (direction ==3 && goshoY%40>0){
    		goshoY+=dy;
    	}
    	else if (checkFree.up(tilesPositions, goshoY, goshoX) == true && checkFree.up(wallsPositions, goshoY, goshoX) == true && direction==3) {
    		goshoY += dy;
    	}
    	//move down
    	if (direction ==4 && (goshoY+35)%40>0){
    		goshoY += dy;
    	}
    	else if (checkFree.down(tilesPositions, goshoY, goshoX) == true && checkFree.down(wallsPositions, goshoY, goshoX) == true && direction==4) {
    		goshoY += dy;
    	}
    }
    
    //returns X position of Gosho
    public int getX() {
        return goshoX;
    }

    //returns Y position of Gosho
    public int getY() {
        return goshoY;
    }
    
    //returns image of Gosho
    public Image getImage() {
        return image_gosho;
    }
    
    //onKeyPress
    public void keyPressed(KeyEvent keyEvente) {
        int key = keyEvente.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
    		dx = -1;
    		direction = 1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            direction = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            direction = 3;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            direction = 4;
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	if (bombs.size()==0) {
        		dropItLikeItsHot();
        	}
        }
    }

    //onKeyRelease
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            direction = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            direction = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            direction = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            direction = 0;
        }
    }
    
    //dropping the bomb
    public void dropItLikeItsHot() {
		bombs.add(new Bomb(goshoX, goshoY));
    }
    
    public ArrayList getBombs() {
        return bombs;
    }
    
    public Rectangle getGoshoBounds() {
        return new Rectangle(goshoX, goshoY, 35, 35);
    }

}
