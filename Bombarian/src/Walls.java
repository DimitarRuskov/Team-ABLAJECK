
public class Walls {
	public static String[] walls = new String[13];
	public static int[][] getWallPositions = new int[13][27];
    public static String[] insertWalls() {
    	walls[0] = "000000000000000000000000000";
    	walls[1] = "000081101001010000110000100";
    	walls[2] = "000001000001010000010000010";
    	walls[3] = "000000011100011100010000100";
    	walls[4] = "000000000100000000000000000";
    	walls[5] = "000110000011100000111100000";
    	walls[6] = "010100000100000100000000010";
    	walls[7] = "010100001110011100000100010";
    	walls[8] = "000100000000000100010100010";
    	walls[9] = "000001100001110000101100000";
    	walls[10] = "010001000001000000010000000";
    	walls[11] = "011011000011100001100011110";
    	walls[12] = "000000000000000000000000000";
    	return walls;
    }
    
    public static void change (int x, int y) {
    	if (getWallPositions[y][x] == 1) {
    		getWallPositions[y][x] = 0;
    	}
    	if (getWallPositions[y][x] == 8) {
    		getWallPositions[y][x] = 9;
    	}
    }
    
	public static int[][] getWallsPositions() {
		String[] mapCurrent = insertWalls();
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 27; j++) {
				switch (mapCurrent[i].charAt(j)){
					case '0':
						getWallPositions[i][j]=0;
						break;
					case '1':
						getWallPositions[i][j]=1;
						break;
					case '2':
						getWallPositions[i][j]=2;
						break;
					case '8':
						getWallPositions[i][j]=8;
						break;
					case '9':
						getWallPositions[i][j]=9;
						break;
				}
			}
		}
		return getWallPositions;
	}
	public static int[][] getWalls() {
		return getWallPositions;
	}
}
