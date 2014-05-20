import java.awt.Image;
import javax.swing.ImageIcon;

public class Bomb {
	private int x, y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

}
