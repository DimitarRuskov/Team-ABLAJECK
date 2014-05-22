import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
 
public class BombTimer {
	static int interval;
	static Timer timer;
	private static int[][] tilesPositions = Blocks.getTilePositions(); //int[][] var for the tiles
	
	public static void bombTimer(final ArrayList bm) {
	    int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    interval = 4;
	    timer.scheduleAtFixedRate(new TimerTask() {
	 
	        public void run() {
	            if(setInterval() == 0){
		            bm.clear();
		            Walls.change((Bomb.getX()-20)/40, Bomb.getY()/40);
		            Walls.change((Bomb.getX()+60)/40, Bomb.getY()/40);
		            Walls.change(Bomb.getX()/40, (Bomb.getY()-20)/40);
		            Walls.change(Bomb.getX()/40, (Bomb.getY()+60)/40);
		            Gosho.checkDead();
		            Enemy.checkDead();
	            }
	 
	        }
	    }, delay, period);
	}
	 
	private static final int setInterval() {
	    if (interval == 1) {
	        timer.cancel();
	    }
	    return --interval;
	}
	
	
	public static Rectangle getExplodeUP() {
        return new Rectangle(Bomb.getX(), Bomb.getY()-40, 40, 40);
    }
	
	public static Rectangle getExplodeDOWN() {
        return new Rectangle(Bomb.getX(), Bomb.getY()+40, 40, 40);
    }
	
	public static Rectangle getExplodeLEFT() {
        return new Rectangle(Bomb.getX()-40, Bomb.getY(), 40, 40);
    }
	
	public static Rectangle getExplodeRIGHT() {
        return new Rectangle(Bomb.getX()+40, Bomb.getY(), 40, 40);
    }

	public static Rectangle getExplodeCENTER() {
        return new Rectangle(Bomb.getX(), Bomb.getY(), 40, 40);
    }
	
}
