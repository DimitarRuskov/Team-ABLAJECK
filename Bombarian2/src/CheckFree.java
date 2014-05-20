public class CheckFree {
	
	public static boolean left(int blockPos[][], int y, int x) {
    	if (blockPos[y/40][(x/40)-1] == 0 && blockPos[(y+34)/40][x/40-1] == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public static boolean right(int blockPos[][], int y, int x) {
    	if (blockPos[y/40][(x+35)/40] == 0 && blockPos[(y+34)/40][(x+35)/40] == 0){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public static boolean up(int blockPos[][], int y, int x) {
    	if (blockPos[y/40-1][(x/40)] == 0 && blockPos[y/40 - 1][(x+34)/40] == 0){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public static boolean down(int blockPos[][], int y, int x) {
    	if (blockPos[(y+35)/40][(x/40)] == 0 && blockPos[(y+35)/40][(x+34)/40] == 0){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
}
