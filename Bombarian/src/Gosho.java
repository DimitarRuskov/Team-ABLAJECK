
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import java.util.Timer;

public class Gosho {
	private String gosho = "gosho.png";

    private int dx;
    private int dy;
    private int goshoX;
    private int goshoY;
    private Image image_gosho;
    private ArrayList bombs;
    private static int timeForBomb = 4;
    //for gosho.move
    private int[][] tilesPositions = Map.getTilePositions();
    private int direction = 0;
    
    public Gosho() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(gosho));
        image_gosho = ii.getImage();
        bombs = new ArrayList();
        goshoX = 41;
        goshoY = 41;
    }
    public boolean checkLeft(int blockPos[][], int goshoY, int goshoX) {
    	if (blockPos[goshoY/40][(goshoX/40)-1] == 0 && blockPos[(goshoY+34)/40][goshoX/40-1] == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean checkRight(int blockPos[][], int goshoY, int goshoX) {
    	if (blockPos[goshoY/40][(goshoX+35)/40] == 0 && blockPos[(goshoY+34)/40][(goshoX+35)/40] == 0){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean checkTop(int blockPos[][], int goshoY, int goshoX) {
    	if (blockPos[goshoY/40-1][(goshoX/40)] == 0 && blockPos[goshoY/40 - 1][(goshoX+34)/40] == 0){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean checkBottom(int blockPos[][], int goshoY, int goshoX) {
    	if (blockPos[(goshoY+35)/40][(goshoX/40)] == 0 && blockPos[(goshoY+35)/40][(goshoX+34)/40] == 0){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void move() {
    	//move left
    	if (direction==1 && goshoX%40>0) {
    		goshoX += dx;
    	}
    	else if (checkLeft(tilesPositions, goshoY, goshoX) == true  && direction==1) {
    		goshoX += dx;
    	}
    	//move right
    	if (checkRight(tilesPositions, goshoY, goshoX) == true && direction==2){
    		goshoX += dx;
    	}
    	//move up
    	if (direction ==3 && goshoY%40>0){
    		goshoY+=dy;
    	}
    	else if (checkTop(tilesPositions, goshoY, goshoX) == true && direction==3) {
    		goshoY += dy;
    	}
    	//move down
    	if (direction ==4 && (goshoY+35)%40>0){
    		goshoY += dy;
    	}
    	else if (checkBottom(tilesPositions, goshoY, goshoX) == true && direction==4) {
    		goshoY += dy;
    	}
    }
    
    public int getX() {
        return goshoX;
    }

    public int getY() {
        return goshoY;
    }

    public Image getImage() {
        return image_gosho;
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

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
    		dropItLikeItsHot();
        	
        }
    }

    
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
