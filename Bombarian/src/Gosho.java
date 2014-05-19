import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.TimerTask;
import java.util.Timer;

public class Gosho {
	
	private String gosho = "goshoGIF.gif"; //address of Gosho when he stays in one place
	private String goshoUP = "goshoUP.png"; //address of Gosho when he moves up
	private String goshoDOWN = "goshoDOWN.png"; //address of Gosho when he moves down
	private String goshoLEFT = "goshoLEFT.png"; //address of Gosho when he moves left
	private String goshoRIGHT = "goshoRIGHT.png"; //address of Gosho when he moves right
    private int dx; //temporary mask variable for x
    private int dy; //temporary mask variable for y
    private int goshoX; //coordinates of the TOP-LEFT corner of gosho image
    private int goshoY; //coordinates of the TOP-LEFT corner of gosho image
    private Image image_gosho; //image of Gosho
    private Image image_gosho_up; //image of Gosho
    private Image image_gosho_down; //image of Gosho
    private Image image_gosho_left; //image of Gosho
    private Image image_gosho_right; //image of Gosho
    private ArrayList bombs = new ArrayList();; //new ArrayList for the bombs
    private static int timeForBomb = 4; //the time after which bombs explode
    private int[][] tilesPositions = Map.getTilePositions(); //int[][] var for the tiles
    private int[][] wallsPositions = Walls.getWallPositions(); //int[][] var for the walls
    private static int direction = 0; //direction at which Gosho is moving (1-left, 2-right, 3-up, 4-down)
    private int maxBombs = 1; //set number of max bombs
    
    public Gosho() {
    	//images of gosho
        ImageIcon ii = new ImageIcon(this.getClass().getResource(gosho));
        image_gosho = ii.getImage();
        ImageIcon ii_up = new ImageIcon(this.getClass().getResource(goshoUP));
        image_gosho_up = ii_up.getImage();
        ImageIcon ii_down = new ImageIcon(this.getClass().getResource(goshoDOWN));
        image_gosho_down = ii_down.getImage();
        ImageIcon ii_left = new ImageIcon(this.getClass().getResource(goshoLEFT));
        image_gosho_left = ii_left.getImage();
        ImageIcon ii_right = new ImageIcon(this.getClass().getResource(goshoRIGHT));
        image_gosho_right = ii_right.getImage();
        
      //starting position of Gosho:
        goshoX = 41;
        goshoY = 41;
    }
    
    public void move() {
    	//move left
    	if (direction==1 && goshoX%40>0) {
    		goshoX += dx;
    	}
    	else if (CheckFree.left(tilesPositions, goshoY, goshoX) == true && CheckFree.left(wallsPositions, goshoY, goshoX) == true  && direction==1) {
    		goshoX += dx;
    	}
    	//move right
    	if (CheckFree.right(tilesPositions, goshoY, goshoX) == true && CheckFree.right(wallsPositions, goshoY, goshoX) == true && direction==2){
    		goshoX += dx;
    	}
    	//move up
    	if (direction == 3 && goshoY % 40 > 0){
    		goshoY+=dy;
    	}
    	else if (CheckFree.up(tilesPositions, goshoY, goshoX) == true && CheckFree.up(wallsPositions, goshoY, goshoX) == true && direction==3) {
    		goshoY += dy;
    	}
    	//move down
    	if (direction ==4 && (goshoY+35)%40>0){
    		goshoY += dy;
    	}
    	else if (CheckFree.down(tilesPositions, goshoY, goshoX) == true && CheckFree.down(wallsPositions, goshoY, goshoX) == true && direction==4) {
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
    
    //returns image of Gosho in different positions
    public Image getImageSTATIC() {
        return image_gosho;
    }
    
    public Image getImageUP() {
        return image_gosho_up;
    }
    
    public Image getImageDOWN() {
        return image_gosho_down;
    }
    
    public Image getImageLEFT() {
        return image_gosho_left;
    }
    
    public Image getImageRIGHT() {
        return image_gosho_right;
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
        	if (bombs.size()==maxBombs-1) {
        		dropItLikeItsHot();
        		
        	}
        }
    }
    
    public static int getDirection() {
    	return direction;
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
    
    public int getMaxBombs() {
    	return maxBombs;
    }
    
    public Rectangle getGoshoBounds() {
        return new Rectangle(goshoX, goshoY, 35, 35);
    }

}
