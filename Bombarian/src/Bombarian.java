
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Bombarian extends JFrame {
	
	int x, y;
	private Image dbImage;
	private Graphics dbg;
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			
			int keyCode = e.getKeyCode();
			if (keyCode == e.VK_UP) {
				y--;
			}
			if (keyCode == e.VK_DOWN) {
				y++;			
						}
			if (keyCode == e.VK_LEFT) {
				x--;
			}
			if (keyCode == e.VK_RIGHT) {
				x++;
			}
			
		}
		public void keyReleased(KeyEvent e){
		
		}
	}
	
    public Bombarian() {
    	addKeyListener(new AL());
        add(new Board());
        setTitle("Bombarian");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        x = 20;
        y = 45;
    }
    
    public void paint(Graphics g){
    	dbImage = createImage(getWidth(), getHeight());
    	dbg = dbImage.getGraphics();
    	paintComponent(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    }
    
    public void paintComponent(Graphics g){
    	g.fillOval(x, y, 20, 20);
    	repaint();
    }
    
    public static void main(String[] args) {
        new Bombarian();
    }
}








































































































//
//
//import java.awt.event.KeyListener;
//import java.io.BufferedReader;
//import java.io.Console;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Bombarian {
//	
//	
//	static boolean[][] gameField;
//	// gameField returns true if an UNBREAKABLE tile (block) or false if empty
//	public static boolean gameField (int x, int y) {
//		for (int row = 0; row < 24; row ++) {
//			for (int col = 0; col < 100; col ++) {
//				if (col / 4 % 2 == 1 && row / 2 % 2 == 1) {
//					if (x == col && y == row) {
//						return true;
//					}
//				}
//				else {
//					if (x == col && y == row) {
//						return false;
//					}
//				}
//			}
//		}
//		return false;
//	}
//	
//	public static StringBuilder[] createMap () {
//		StringBuilder[] map = new StringBuilder[22];
//		map[0] = new StringBuilder ("0001110100101000011000020");
//		map[2] = new StringBuilder ("0000100000101000001000001");
//		map[4] = new StringBuilder ("0000001110001110001000010");
//		map[6] = new StringBuilder ("0000000010000000000000000");
//		map[8] = new StringBuilder ("0011000001110000011110000");
//		map[10] = new StringBuilder ("1010000010000010000000001");
//		map[12] = new StringBuilder ("1010000111001110000010001");
//		map[14] = new StringBuilder ("0010000000000010001010001");
//		map[16] = new StringBuilder ("0000110000111000010110000");
//		map[18] = new StringBuilder ("1000100000100000001000000");
//		map[20] = new StringBuilder ("1101100001110000110001111");
//		for (int i = 1; i < 22; i= i+2) {
//			map[i] = map[i-1];
//		}
//		StringBuilder mask = new StringBuilder();
//		for (int i = 0; i < 22; i++) {
//			mask = map[i];
//			map[i] = new StringBuilder ("");
//			for (int j = 0; j < 25; j++) {
//				for (int g = 0; g < 4; g++) {
//					map[i].append(mask.charAt(j));
//				}
//			}
//		}
//		return map;
//	}
//	public static void main(String[] args) {
//		int x, y;
//		while(true){
//		
//		StringBuilder[] map = createMap();
//		
//		//obhojdame cqloto pole i proverqvame dali ima block, wall, enemy, bomb ili Gosho i izvurshvame suotvetnoto deistvie
//		for (y = 0; y < 24; y++) {
//			if (y == 0) {
//				for (x = 0; x < 102; x++) {
//					if (x==0) {
//						System.out.print("\u2554"); //CORNER border top-left
//					}
//					else if (x==101) {
//						System.out.print("\u2557"); //CORNER border top-right
//					}
//					else {
//						System.out.print("\u2550"); //HORIZONTAL border top
//					}
//				}
//			}
//			else if (y == 23) {
//				for (x = 0; x < 102; x++) {
//					if (x==0) {
//						System.out.print("\u255A"); // CORNER border bottom-left
//					}
//					else if (x==101) {
//						System.out.print("\u255D"); // CORNER border bottom-right
//					}
//					else {
//						System.out.print("\u2550"); //HORIZONTAL border bottom
//					}
//				}
//				System.out.println();
//			}
//			else {
//				System.out.print("\u2551"); // VERTICAL border left
//				for (x = 0; x < 100; x++) {
//					if (gameField(x, y-1) == true) {
//						System.out.print("\u2588");
//					}
//					else if (map[y-1].charAt(x) == '1') {
//						System.out.print("\u2591");
//					}
//					else {
//						System.out.print(" ");
//					}
//				}
//				System.out.print("\u2551"); // VERTICAL border right
//			}
//			System.out.println();
//			
//		}
//		final String ANSI_CLS = "\u001b[2J";
//        final String ANSI_HOME = "\u001b[H";
//        System.out.print(ANSI_CLS + ANSI_HOME);
//        System.out.flush();
//		}
//	
//	}
//	
//	public static void printEnemy(int row, int col) {
//		char[][] enemy = new char[2][4];
//		enemy[0][0] = ' ' ;
//		enemy[0][1] = '\u2552';
//		enemy[0][2] = '\u2555';
//		enemy[0][3] = ' ';
//		enemy[1][0] = ' ';
//		enemy[1][1] = '\u2561';
//		enemy[1][2] = '\u255E';
//		enemy[1][3] = ' ';
//		
//		
//		
//		System.out.println(enemy);
//	}
//}
//
//
//
