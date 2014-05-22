import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomb {
	private static int x;
	private static int y;
    private Image image_bomb;
    boolean visible;
    
    public Bomb(int x, int y) {

        ImageIcon ii = new ImageIcon(this.getClass().getResource("bomb.gif"));
        image_bomb = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
        
    }
    public Image getImage() {
        return image_bomb;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    
    public static Rectangle getBombBounds() {
        return new Rectangle(x, y, 35, 35);
    }
}
