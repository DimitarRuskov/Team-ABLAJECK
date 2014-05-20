
public class Walls {
	public static String[] walls = new String[13];
	
    public static String[] insertWalls() {
    	walls[0] = "000000000000000000000000000";
    	walls[1] = "000011101001010000110000200";
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

	public static int[][] getWallPositions() {
		String[] mapCurrent = insertWalls();
		int[][] getWallPositions = new int[13][27];
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
					case '3':
						getWallPositions[i][j]=3;
						break;
				}
			}
		}
		return getWallPositions;
	}
}
