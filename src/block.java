//import java.util.Arrays;
/**
 * To generate the block with specific specification
 *
 * @author LIM, Kian Aik (20687818)
 * @author TSE, Tai Loi (20893048)
 */
public class block {

	/**
	 * Out put the block with specific specification
	 * @param type the block type
	 * @param rotation number range from 0 to 3 each increment equals to 90 degree clockwise
	 * @return 2D boolean array with the specified rotation
	 * @throws Exception when the type or rotation is out of range
	 */
	public static boolean[][] getBlock(int type, int rotation) //throws Exception
	{
	//	System.out.println("type = "+ type);
	//if (type <= 0 || type > 7 || rotation < 0 || rotation > 3)
		//throw new Exception("No Such Piece or rotation");

	switch (type) {
		case 1 :
			if (rotation == 0 || rotation == 2) {
				boolean[][] temp = new boolean[4][1];
				for (int i = 0; i <= 0; i++)
					for (int j = 0; j <= 3; j++) temp[j][i] = false;
				for (int i = 0; i <= 3; i++) temp[i][0] = true;
				return temp;
			}
			if (rotation == 1 || rotation == 3) {
				boolean[][] temp = new boolean[1][4];
				for (int i = 0; i <= 3; i++)
					for (int j = 0; j <= 0; j++) temp[j][i] = false;
				for (int i = 0; i <= 3; i++) temp[0][i] = true;
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
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[i][0] = true;
				}
				temp[1][1] = true;
				return temp;
			}
			if (rotation == 1) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[0][i] = true;
				}
				temp[1][1] = true;
				return temp;
			}
			if (rotation == 2) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[i][1] = true;
				}
				temp[1][0] = true;
				return temp;
			}
			if (rotation == 3) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[1][i] = true;
				}
				temp[0][1] = true;
				return temp;
			}
			break;
		case 4 :
			if (rotation == 0) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[i][0] = true;
				}
				temp[0][1] = true;
				return temp;
			}
			if (rotation == 1) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[0][i] = true;
				}
				temp[1][2] = true;
				return temp;
			}
			if (rotation == 2) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[i][1] = true;
				}
				temp[2][0] = true;
				return temp;
			}
			if (rotation == 3) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[1][i] = true;
				}
				temp[0][0] = true;
				return temp;
			}
			break;
		case 5 :
			if (rotation == 0) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[i][1] = true;
				}
				temp[0][0] = true;
				return temp;
			}
			if (rotation == 1) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[1][i] = true;
				}
				temp[0][2] = true;
				return temp;
			}
			if (rotation == 2) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[i][0] = true;
				}
				temp[2][1] = true;
				return temp;
			}
			if (rotation == 3) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				for (int i = 0; i <= 2; i++) {
					temp[0][i] = true;
				}
				temp[1][0] = true;
				return temp;
			}
			break;
		case 6 :
			if (rotation == 0 || rotation == 2) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				temp[0][0] = true;
				temp[1][0] = true;
				temp[1][1] = true;
				temp[2][1] = true;
				return temp;
			}
			if (rotation == 1 || rotation == 3) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				temp[1][0] = true;
				temp[0][1] = true;
				temp[1][1] = true;
				temp[0][2] = true;
				return temp;
			}
			break;
		case 7 :
			if (rotation == 0 || rotation == 2) {
				boolean[][] temp = new boolean[3][2];
				for (int i = 0; i <= 1; i++) {
					for (int j = 0; j <= 2; j++) {
						temp[j][i] = false;
					}
				}
				temp[1][0] = true;
				temp[2][0] = true;
				temp[0][1] = true;
				temp[1][1] = true;
				return temp;
			}
			if (rotation == 1 || rotation == 3) {
				boolean[][] temp = new boolean[2][3];
				for (int i = 0; i <= 2; i++) {
					for (int j = 0; j <= 1; j++) {
						temp[j][i] = false;
					}
				}
				temp[0][0] = true;
				temp[0][1] = true;
				temp[1][1] = true;
				temp[1][2] = true;
				return temp;
			}
			break;
			}
			boolean[][] temp = new boolean[1][1];
			return temp;
		}
		public static void main(String [] args) {
			//boolean[][] temp = getBlock(7,3);
			//for (int i = 0; i < temp.length; i++)
			//System.out.println(Arrays.toString(temp[i]));

		}
	}
