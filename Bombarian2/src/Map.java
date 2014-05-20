public class Map {
	public static String[] map = new String[13];
	
    public static String[] insertMap() {
    	map[0] = "111111111111111111111111111";
    	for (int i = 1; i < 12; i+=2) {
    		map[i] = "100000000000000000000000001";
    	}
    	for (int i = 2; i < 12; i+=2) {
    		map[i] = "101010101010101010101010101";
    	}
    	map[12] = "111111111111111111111111111";
    	return map;
    }

	public static int[][] getTilePositions() {
		String[] mapCurrent = insertMap();
		int[][] getTilesPositions = new int[13][27];
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 27; j++) {
				if (mapCurrent[i].charAt(j)=='1'){
					getTilesPositions[i][j] = 1;
				}
				else {
					getTilesPositions[i][j] = 0;
				}
			}
		}
		return getTilesPositions;
	}
    
    
    
}
