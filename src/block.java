/**
 * Write a description of class block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class block {

	boolean[][] temp;
	public boolean[][] getBlock(int type, int rotation) throws Exception {
		if (type <= 0 || type > 7 || rotation < 0 || rotation > 3)
			throw new Exception("No Such Piece or rotation"); 
		switch (type) {
			case 1 : 
				if (rotation == 0 || rotation == 2) {
					boolean[][] temp = new boolean[1][4];
					for (int i = 0; i <= 0; i++)
						for (int j = 0; j <= 3; j++) temp[i][j] = false;
					for (int i = 0; i <= 3; i++) temp[0][i] = true;
					return temp;
				}
				if (rotation == 1 || rotation == 3) {
					boolean[][] temp = new boolean[4][1];
					for (int i = 0; i <= 3; i++) 
						for (int j = 0; j <= 0; j++) temp[i][j] = false;
					for (int i = 0; i <= 3; i++) temp[i][0] = true;
					return temp;
				}
				break;
			case 2 :
				if (rotation >= 0 && rotation <= 3) {
					boolean[][] temp = new boolean[2][2];
					for (int i = 0; i <= 1; i++) 
						for (int j = 0; j <= 1; j++) temp[i][j] = false;
					for (int i = 0; i <= 1; i++)
						for (int j = 0; j <= 1; j++) temp[i][j] = true;
					return temp;
				}
				break;
			case 3 :
				if (rotation == 0) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[0][i] = true;
					}
					temp[1][1] = true;
					return temp;
				}
				if (rotation == 1) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[i][1] = true;
					}
					temp[1][1] = true;
					return temp;
				}
				if (rotation == 2) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[1][i] = true;
					}
					temp[0][1] = true;
					return temp;
				}
				if (rotation == 3) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[i][0] = true;
					}
					temp[1][0] = true;
					return temp;
				}
				break;
			case 4 :
				if (rotation == 0) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[0][i] = true;
					}
					temp[1][0] = true;
					return temp;
				}
				if (rotation == 1) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
					}
					}
					for (int i = 0; i <= 2; i++) {
						temp[i][1] = true;
					}
					temp[2][1] = true;
					return temp;
				}
				if (rotation == 2) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[1][i] = true;
					}
					temp[0][2] = true;
					return temp;
				}
				if (rotation == 3) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[i][0] = true;
					}
					temp[0][0] = true;
					return temp;
				}
				break;
			case 5 :
				if (rotation == 0) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[1][i] = true;
					}
					temp[0][0] = true;
					return temp;
				}
				if (rotation == 1) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[i][0] = true;
					}
					temp[2][0] = true;
					return temp;
				}
				if (rotation == 2) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[0][i] = true;
					}
					temp[1][2] = true;
					return temp;
				}
				if (rotation == 3) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					for (int i = 0; i <= 2; i++) {
						temp[i][1] = true;
					}
					temp[0][1] = true;
					return temp;
				}
				break;
			case 6 :
				if (rotation == 0 || rotation == 2) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					temp[0][0] = true;
					temp[0][1] = true;
					temp[1][1] = true;
					temp[1][2] = true;
					return temp;
				}
				if (rotation == 1 || rotation == 3) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					temp[0][1] = true;
					temp[1][0] = true;
					temp[1][1] = true;
					temp[2][0] = true;
					return temp;
				}
				break;
			case 7 :
				if (rotation == 0 || rotation == 2) {
					boolean[][] temp = new boolean[2][3];
					for (int i = 0; i <= 1; i++) {
						for (int j = 0; j <= 2; j++) {
							temp[i][j] = false;
						}
					}
					temp[0][1] = true;
					temp[0][2] = true;
					temp[1][0] = true;
					temp[1][1] = true;
					return temp;
				}
				if (rotation == 1 || rotation == 3) {
					boolean[][] temp = new boolean[3][2];
					for (int i = 0; i <= 2; i++) {
						for (int j = 0; j <= 1; j++) {
							temp[i][j] = false;
						}
					}
					temp[0][0] = true;
					temp[1][0] = true;
					temp[1][1] = true;
					temp[2][1] = true;
					return temp;
				}
				break;
		}
		return temp;
	}
}
