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
	public static int width;
	public static block block = new block();

	public board (int w) {
		width = w;
		boolean[][] lineNull = new boolean[1][width];
		lineNull[0] =  new boolean[] {false,true,false,false};
		pushBoard(lineNull);
		grid = popBoard(w);
	}
	
	/**
	 * Pop out the board from the stack
	 * @param w
	 * @return 
	 */
	public static boolean[][] popBoard (int w) {
		boolean[][] output;
		boolean[] foundHeight = new boolean[w];
		boolean[] temp2 = new boolean[w];
		int count = 0;
		boolean enough = false;
		Stack<boolean[]> temp = (Stack)boardStack.clone();

		for (int i = 0; i < w; i++) {
			foundHeight[i] = false;
		}

		while (!enough){
			if (temp.empty())enough = true;
			count++;
			if (!temp.empty()) temp2 = temp.pop();
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
			if (numTrue != width && numFalse != width) if (numTrue != 0 && numFalse != 0)boardStack.push(input[i]);
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
	
	/**
	 * Drop the block to the inputed boolean array.
	 * @param blockType the block type being dropped
	 * @param rotation the rotation of the block
	 * @param location the x coordinates of the block being dropped to
	 * @param input the board the block being dropped
	 * @return the block dropped in board
	 */
	public static boolean[][] dropBlock(int blockType, int rotation, int location, boolean[][] input) {
		//INTEPRETATION OF THE BLOCK PHYSICS
		boolean[][] output = input;
		block block2 = new block();
		boolean[][] physics = block2.getBlock(blockType, rotation);
		//System.out.println(Arrays.toString(block2.getBlock(1, 0)[0]));
		int blockWidth = physics[0].length;
		int blockHeight = physics.length;
		int destination = location;
		boolean drop = true;
		int height = 0;
		boolean isEmptyGrid= false;;
		//int downwards = 0;

		//System.out.println("blockWidth   "+blockWidth);
		//System.out.println("blockHeight   "+blockHeight);
		//System.out.println("location   "+location);
		//System.out.println("destination   "+destination);
		//System.out.println("width   "+width);

		//DETERMINE IF LOCATION IS A POSSIBLE COORDIANTE ELSE RETURN RIGHT MOST
		if ((location + blockWidth) > (width-1)) {
			destination = width -blockWidth;
			System.out.println("----RAN----");
			System.out.println("Destination =  "+ destination);
		}

		//System.out.println("destination + blockWidth "+destination + blockWidth);
		//System.out.println("input.length "+input.length);


		while (drop){
			//System.out.println("height "+height);
			for (int i = destination; i < (destination + blockWidth); i++) {
				//System.out.println("(output[height][i])  "+ output[height][i]);
				//System.out.println("i  =   " +i );
					if (output[height][i]) drop = false;
					if(height == input.length-1){drop = false;
					isEmptyGrid = true;}
			}

			if (drop)height++;

		}



		//NATURE OF THE LOOP WILL INCREMENT 1 MORE
		System.out.println("height = "+height);
		//height--;

		//DETERMINE IF THE BLOCK COULD COLLIDE WITH THE TERAIN

		//System.out.println("----before wrong code----");
		//System.out.println("(physics[0][0]"+physics[0][0]);
		//System.out.println("output[height-1+downwards+0][destination+0] "+ output[height-1+0][destination+0]);
		//System.out.println("height   "+ height + "    destination  "+ destination);
		//System.out.println("blockHeight   "+ blockHeight);
		//System.out.println("blockWidth   "+ blockWidth);
		//System.out.println("");

		///////////////////WRONG CODE////////////////////
		//return output;

		int destinationY = 0;
		drop = true;
		int k = 0;
		while (drop) {

			if(isEmptyGrid){
				destinationY = height;
				System.out.println("000 destinationY =  " +destinationY);
				break;
			}


			for (int j = 0; j < blockHeight; j++) {
				for (int i = 0; i <blockWidth; i++) {
					//System.out.println("physics["+j+"]["+i+"]"+physics[j][i]);
					//System.out.println("output["+(height+j)+"]["+(destination+i)+"] "+ output[height+j][destination+i]);
					if (physics[j][i] && output[j+height-blockHeight+k][i+destination]) {
						destinationY = j+height-blockHeight+k-1;
						drop = false;
					}
				}
			}
			k++;
		}
		for (int i = 0; i < blockHeight; i++) {
			for (int j = 0; j < blockWidth; j++){
				//System.out.println("blockHeight "+ blockHeight+" blockWidth "+ blockWidth);
				System.out.println("j "+j+" i "+i+" destinationY "+destinationY);
				if (physics[i][j])
				output[i+destinationY-blockHeight+1][destination+j] = true;

			}
		}
		return output;
	}

	/**
	 * Return the height of the tetris board
	 * @return int the height
	 */
	public static int getBoardHeight() {
		boolean[][] input = getFullStack();
		return input.length;
	}


	/**
	 * Return the number of holes in the tetris board
	 * @return int the number of holes
	 */
	public static int getHole() {
		boolean[][] input = getFullStack();
		int count = 0;

		for (int j = 0; j < input.length; j++) {
			for (int i = 0; i < width; i++) {
				if(!input[j][i]) {
				if(j > 0)
				if(!input[j][i] && input[j-1][i]) count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Return the difference between the highest and
	 * lowest line of the tetris board
	 * @return the height difference
	 */
	public static int getFlatness(){
		boolean[][] input = getFullStack();
		int max = 0;
		int min = 0;
		int num = 0;

		for (int i = 0; i < width; i++) {
			int j =0;
			outerloop:
			while(!input[j][i] && i != input.length-1) {
				j++;
				if (input[j][i]){
					if (j < min || min == 0) {
						if (j > max)max = j;
						min = j;
						num++;
						break outerloop;
					}
					if (j > max) {
						max = j;
						num++;
						break outerloop;
					}
				}
			}
		}
		System.out.println("max  " +max + "   min   "+ min);
		return max - min;
	}


	/**
	 * Input a played 2D boolean board and calculate the cleared lines
	 * @param input the boolean array
	 * @return a number of line cleared
	 */
	public static int getCleared(boolean[][] input) {
		int result = 0;
		for (int i = (input.length-1); i >= 0; i--) {
			int numTrue = 0;
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j]) numTrue++;
				}
			if (numTrue == width) result++;
		}
		return result;
	}
	
	/**
	 * Pop out the full stack of the board into a 2D boolean array
	 * @return the whole board in 2D boolean array
	 */
	public static boolean[][] getFullStack() {
		Stack<boolean[]> temp = (Stack)boardStack.clone();
		Stack<boolean[]> temp2 = (Stack)boardStack.clone();
		boolean[][] output;
		int count = 0;
		int i = 0;
		while (!temp.empty()) {
			count++;
		}

		output = new boolean[count][width];
		while (!temp2.empty()) {
			output[i] = temp2.pop();
			i++;
		}
		return output;
	}
	
	/**
	 * Determine if the block will placed on the right most even out of bound
	 * @param blockType the block type being dropped
	 * @param rotation the rotation of the block
	 * @param location the x coordinates of the block being dropped to
	 * @return return true is on the far right false otherwise
	 */
	public boolean isOnRight(int blockType, int rotation, int location) {
		block block2 = new block();
		boolean[][] physics = block2.getBlock(blockType, rotation);
		int blockWidth = physics[0].length;
		
		return ((location + blockWidth) >= (width-1));
	}
	
	/**
	 * Determine if the block will placed on the left most
	 * @param blockType the block type being dropped
	 * @param rotation the rotation of the block
	 * @param location the x coordinates of the block being dropped to
	 * @return return true is on the far right false otherwise
	 */
	public boolean isOnLeft(int blockType, int rotation, int location) {
		return (location == 0);
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
		//boardStack.push(line1);
		//boardStack.push(line2);
		//boardStack.push(line3);
		//boardStack.push(line4);
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
		//boolean[][] temp = popBoard(4);
		System.out.println("------popBoard------");
		System.out.println("------pushBoard------");
		//pushBoard(temp);
		//printBoard();
		//temp = dropBlock( 5,3, 8, temp);
		//getCleared(temp);
		//System.out.println("getFlatness =  "+ getFlatness(temp));
		//System.out.println("getHole  =  "+ getHole(temp));
		System.out.println("------print temp------");
		boolean[][] temp = popBoard(4);
		System.out.println(Arrays.toString(temp[0]));
		System.out.println(Arrays.toString(temp[1]));
		System.out.println(Arrays.toString(temp[2]));
		System.out.println(Arrays.toString(temp[3]));
		//System.out.println(Arrays.toString(temp[4]));
		//System.out.println(Arrays.toString(temp[5]));

		grid = new boolean[4][4];
		boolean[] line5 = {false,true,false,false};
		boolean[] line6 = {false,false,false,false};
		grid[0] = new boolean[] {false,false,false,false};
		grid[1] = new boolean[] {false,false,false,false};
		grid[2] = new boolean[] {true,false,true,true};
		grid[3] = new boolean[] {false,true,false,false};
		System.out.println("------print grid------");
		System.out.println(Arrays.toString(grid[0]));
		System.out.println(Arrays.toString(grid[1]));
		System.out.println(Arrays.toString(grid[2]));
		System.out.println(Arrays.toString(grid[3]));
		grid = dropBlock( 3,1, 1, grid);
		System.out.println(Arrays.toString(grid[0]));
		System.out.println(Arrays.toString(grid[1]));
		System.out.println(Arrays.toString(grid[2]));
		System.out.println(Arrays.toString(grid[3]));
	}
}
