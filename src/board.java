import java.util.Stack;
import java.util.Arrays;

/**
 * Write a description of class board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class board
{
	public static Stack<boolean[]> boardStack;
	public static boolean[][] grid;
	public static int width = 4;
	public static block block = new block();

	public board (int w) {

	}

	public static boolean[][] popBoard (int w) {
		boolean[][] output;
		boolean[] foundHeight = new boolean[w];
		boolean[] temp2 = new boolean[w];
		int rowCleared =  0;
		int count = 0;
		boolean enough = false;
		Stack<boolean[]> temp = (Stack)boardStack.clone();

		for (int i = 0; i < w; i++) {
			foundHeight[i] = false;
		}

		while (!enough){
			if (temp.empty())enough = true;
			count++;
			temp2 = temp.pop();
			for (int i = 0; i < w; i++) {
				if (temp2[i]) {
					foundHeight[i] = true;
				}
			}
			int count2 = 0;
			for (int j = 0; j < foundHeight.length; j++) {
				if (foundHeight[j])count2++;
			}
			if (count2 == w) enough = true;
		}
		//RENEW THE GRID
		output = new boolean[count+4][w];
		for (int j = 0; j < (count+4); j++) {
			for (int i = 0; i < w; i++) {
				output[j][i] = false;
			}
		}

		int i = 0;
		//POP STACK INTO GRID
		while (!boardStack.empty() && i < count) {
			output[i+4] = boardStack.pop();
			i++;
		}

		return output;
	}



	/**
	 * Input a 2D boolean array and push the 2D array back in the stack
	 * @param input the boolean array
	 */
	public static void pushBoard (boolean[][] input) {
		for (int i = (input.length-1); i >= 0; i--) {
			int numTrue = 0;
			int numFalse = 0;
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j]) numTrue++;
				else numFalse++;
			}
			//-------------TODO change it back to width-----------
			if (numTrue != 4 && numFalse != 4) boardStack.push(input[i]);
		}
	}

	/**
	 * Print the board
	 */
	public static void printBoard() {
		Stack<boolean[]> toPrint = (Stack<boolean[]>) boardStack.clone();
		while (!toPrint.isEmpty()) {
			boolean[] input = toPrint.pop();
			for (int i = 0; i < input.length; i++) {
				if (input[i]) System.out.print("1");
				else System.out.print("0");
			}
			System.out.println();
		}
	}

	public static boolean[][] dropBlock(int blockType, int rotation, int location, boolean[][] input) {
		//INTEPRETABURTE THE BLOCK PHYSICS
		boolean[][] output = input;
		block block2 = new block();
		boolean[][] physics = block2.getBlock(blockType, rotation);
		//System.out.println(Arrays.toString(block2.getBlock(1, 0)[0]));
		int blockWidth = physics[0].length;
		int blockHeight = physics.length;
		int destination = location;
		boolean drop = true;
		int height = 0;
		//int downwards = 0;

		System.out.println("blockWidth   "+blockWidth);
		System.out.println("blockHeight   "+blockHeight);
		System.out.println("location   "+location);
		System.out.println("destination   "+destination);
		System.out.println("width   "+width);

		//DETERMINE IF LOCATION IS A POSSIBLE COORDIANTE ELSE RETURN RIGHT MOST
		//if ((location + blockWidth) > (width-1)) {
		//	destination = width -1 -blockWidth;
		//	System.out.println("RAN ");
		//}

		System.out.println("destination + blockWidth "+destination + blockWidth);
		System.out.println("input.length "+input.length);


		while (drop){
			System.out.println("height "+height);
			for (int i = destination; i < (destination + blockWidth) && (height < input.length); i++) {
				//System.out.println("(output[height][i])  "+ output[height][i]);
				//System.out.println("i  =   " +i );
					if (output[height][i]) drop = false;		
			}
			if (drop)height++;
		}

			

		//NATURE OF THE LOOP WILL INCREMENT 1 MORE
		System.out.println("height = "+height);
		height--;

		//DETERMINE IF THE BLOCK COULD COLLIDE WITH THE TERAIN

		System.out.println("----before wrong code----");
		System.out.println("(physics[0][0]"+physics[0][0]);
		System.out.println("output[height-1+downwards+0][destination+0] "+ output[height-1+0][destination+0]);
		System.out.println("height   "+ height + "    destination  "+ destination);
		System.out.println("blockHeight   "+ blockHeight);
		System.out.println("blockWidth   "+ blockWidth);
		System.out.println("");

		///////////////////WRONG CODE////////////////////
		//return output;

		int destinationY = 0;
		drop = true;
		while (drop) {
					//System.out.println("here");
			outerloop:
			for (int j = 0; j <= blockHeight; j++) {
				System.out.println("here");
				for (int i = 0; i <blockWidth; i++) {
					//System.out.println("physics["+j+"]["+i+"]"+physics[j][i]);
					System.out.println("output["+(height+j)+"]["+(destination+i)+"] "+ output[height+j][destination+i]);
					if (output[height+j][destination+i]) {
						drop = false;
						System.out.println("here2");
						destinationY = height + j - 1;
						break outerloop;
					}
				}
			}
		}
		for (int k = 0; k < blockHeight; k++) {
			for (int l = 0; l < blockWidth; l++){
				System.out.println("blockHeight "+ blockHeight+" blockWidth "+ blockWidth);
				System.out.println("l "+l+" k "+k+" destinationY "+destinationY);
				if (physics[k][l])
				output[k+destinationY-blockHeight+1][destination+l] = true;

			}
		}
		return output;
		/**
		//LAND THE BLOCK INTO THE SURFACE
		for (int i = 0; i < blockWidth-1; i++) {
			for (int j = 0; j < blockHeight-1; j++)
				if (physics[j][i]){
					output[j+downwards+height][destination+i] = true;
				}
		}
		return output;
		*/
	}
public static void main(String [] args) //throws Exception
{
		//TESTING THE popBoard method
		boardStack = new Stack();
		grid = new boolean[4][4];
		boolean[] line1 = {true,false,true,true};
		boolean[] line2 = {false,true,true,true};
		boolean[] line3 = {false,true,false,false};
		boolean[] line4 = {true,false,true,true};
		boardStack.push(line1);
		boardStack.push(line2);
		boardStack.push(line3);
		boardStack.push(line4);
		grid[0] = line1;
		grid[1] = line2;
		grid[2] = line3;
		grid[3] = line4;
		System.out.println("------Imginary Board-----");
		System.out.println(Arrays.toString(line4));
		System.out.println(Arrays.toString(line3));
		System.out.println(Arrays.toString(line2));
		System.out.println(Arrays.toString(line1));
		System.out.println();
		System.out.println("------2D Array------");
		printBoard();
		System.out.println("------popBoard------");
		boolean[][] temp = popBoard(4);
		System.out.println("------print temp------");
		System.out.println(Arrays.toString(temp[0]));
		System.out.println(Arrays.toString(temp[1]));
		System.out.println(Arrays.toString(temp[2]));
		System.out.println(Arrays.toString(temp[3]));
		System.out.println(Arrays.toString(temp[4]));
		System.out.println(Arrays.toString(temp[5]));
		//System.out.println(Arrays.toString(temp[6]));
		System.out.println("------popBoard------");
		System.out.println("------pushBoard------");
		//pushBoard(temp);
		//printBoard();
		temp = dropBlock( 3,1, 1, temp);
		System.out.println("------print temp------");
		System.out.println(Arrays.toString(temp[0]));
		System.out.println(Arrays.toString(temp[1]));
		System.out.println(Arrays.toString(temp[2]));
		System.out.println(Arrays.toString(temp[3]));
		System.out.println(Arrays.toString(temp[4]));
		System.out.println(Arrays.toString(temp[5]));
	}
}
