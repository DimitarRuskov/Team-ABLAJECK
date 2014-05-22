import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Enemy {
	public int spawnX;
	public int spawnY;
	public int enemyDirection; //1-left; 2-right; 3-up; 4-down
	public int pathLength;
	private String enemyImagePath = "enemy.png";
	private static int detectRange[] = {0,0,0,0,0,0,0,0,0};
	private static int numberOfEnemies = 9;
	private static int[][] enemies = new int[numberOfEnemies][4];
	private static Image imageEnemy; //image of enemy
	
	public Enemy (int x, int y, int direction, int trajectory) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(enemyImagePath));
        imageEnemy = ii.getImage();
		spawnX = x;
		spawnY = y;
		enemyDirection = direction;
		pathLength = trajectory;
		
	}
	
	//insert enemies
	static int[][] insertEnemies() {
		enemies[0][0] = 1;
		enemies[0][1] = 3;
		enemies[0][2] = 2;
		enemies[0][3] = 3;
		enemies[1][0] = 5;
		enemies[1][1] = 4;
		enemies[1][2] = 4;
		enemies[1][3] = 5;
		enemies[2][0] = 9;
		enemies[2][1] = 5;
		enemies[2][2] = 1;
		enemies[2][3] = 3;
		enemies[3][0] = 7;
		enemies[3][1] = 9;
		enemies[3][2] = 2;
		enemies[3][3] = 3;
		enemies[4][0] = 15;
		enemies[4][1] = 5;
		enemies[4][2] = 2;
		enemies[4][3] = 3;
		enemies[5][0] = 15;
		enemies[5][1] = 9;
		enemies[5][2] = 4;
		enemies[5][3] = 3;
		enemies[6][0] = 21;
		enemies[6][1] = 4;
		enemies[6][2] = 3;
		enemies[6][3] = 4;
		enemies[7][0] = 23;
		enemies[7][1] = 3;
		enemies[7][2] = 4;
		enemies[7][3] = 4;
		enemies[8][0] = 22;
		enemies[8][1] = 9;
		enemies[8][2] = 2;
		enemies[8][3] = 3;
		for (int i = 0; i < 9; i++) {
			enemies[i][0] = enemies[i][0]*40+2;
			enemies[i][1] = enemies[i][1]*40;
		}
		return enemies;
	}
	
	public static void move () {
		
		for (int num = 0; num < numberOfEnemies; num++) {
			Rectangle gBounds = Gosho.getGoshoBounds();
			Rectangle eBounds = getEnemyBounds(num);
			
			if (gBounds.intersects(eBounds)) {
				Board.stopTimer();
				for (int i = 0; i < numberOfEnemies; i++) {
					enemies[i][0] = 0;
					enemies[i][1] = 0;
					enemies[i][2] = 0;
					enemies[i][3] = 0;
				}
				new Main();
//				EndScreen endScreen = new EndScreen();
//				endScreen.add(endScreen);
            }
			
			if (enemies[num][2] == 1) {
				if (enemies[num][3]*40-40 == detectRange[num]) {
					enemies[num][2] = 2;
					detectRange[num] = 0;
				}
				else {
					enemies[num][0]--;
					detectRange[num] ++;
				}
			}
			else if (enemies[num][2] == 2) {
				if (enemies[num][3]*40-40 == detectRange[num]) {
					enemies[num][2] = 1;
					detectRange[num] = 0;
				}
				else {
					enemies[num][0]++;
					detectRange[num] ++;
				}
			}
			else if (enemies[num][2] == 3) {
				if (enemies[num][3]*40-40 == detectRange[num]) {
					enemies[num][2] = 4;
					detectRange[num] = 0;
				}
				else {
					enemies[num][1]--;
					detectRange[num] ++;
				}
			}
			else if (enemies[num][2] == 4) {
				if (enemies[num][3]*40-40 == detectRange[num]) {
					enemies[num][2] = 3;
					detectRange[num] = 0;
				}
				else {
					enemies[num][1]++;
					detectRange[num] ++;
				}
			}
		}
	}
	
	//get the enemy image
	public static Image getEnemyImage() {
		return imageEnemy;
	}
	
	//get X of certain enemy
	public static int getX(int number) {
		return enemies[number][0];
	}
	
	//get Y of certain enemy
	public static int getY(int number) {
		return enemies[number][1];
	}
	
	//get Direction of certain enemy
	public static int getDirection(int number) {
		return enemies[number][2];
	}
	
	//get Length of trajectory of certain enemy
	public static int getLength(int number) {
		return enemies[number][3];
	}
	//get Direction of certain enemy
	public static int getNumberOfEnemies() {
		return numberOfEnemies;
	}

	public static Rectangle getEnemyBounds(int num) {
        return new Rectangle(enemies[num][0], enemies[num][1], 40, 38);
    }

	public static void checkDead() {
		for (int num = 0; num < numberOfEnemies; num++) {
			Rectangle expBoundsUP = BombTimer.getExplodeUP();
			Rectangle expBoundsDOWN = BombTimer.getExplodeDOWN();
			Rectangle expBoundsLEFT = BombTimer.getExplodeLEFT();
			Rectangle expBoundsRIGHT = BombTimer.getExplodeRIGHT();
			Rectangle expBoundsCENTER = BombTimer.getExplodeCENTER();
			Rectangle eBounds = getEnemyBounds(num);
			if(expBoundsUP.intersects(eBounds) || 
					expBoundsDOWN.intersects(eBounds) || 
					expBoundsLEFT.intersects(eBounds) || 
					expBoundsRIGHT.intersects(eBounds) ||
					expBoundsCENTER.intersects(eBounds)) {
				enemies[num][0] = 0;
				enemies[num][1] = 0;
				enemies[num][2] = 0;
				enemies[num][3] = 0;
            }
		}
		
	}
}
