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
	public int width;
	public block block = new block();

	public board (int w) {

	}
	/**
	 * Popping the board out of the stack, pop till every line contain
	 * at least one element else pop till bottom of the board 
	 * @return a 2D boolean array showing the top most of the board
	 */
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
		System.out.print("count =");
		System.out.println(count);
		//RENEW THE GRID
		output = new boolean[w][count+4];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < (count+4); j++) {
				output[i][j] = false;
			}
		}
		//POP STACK INTO GRID
		while (!boardStack.empty()) {
			int i = 0;
			output[i+3] = boardStack.pop();
			System.out.println(Arrays.toString(output[i+3]));
		}
		return output;
	}

	public void pushStack (int[][] input) {
		//Stack boardStack<line> = new Stack();
		//Check if the line is full
		//for (int i = 0; i)
	}

	/**
	 * Input a 2D boolean array and push the 2D array back in the stack
	 * @param input the boolean array
	 */
	public static void pushBoard (boolean[][] input) {
		//boolean toPush = false;
		
		for (int i = 0; i < input.length; i++) {
			int numTrue = 0;
			int numFalse = 0;
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j]) numTrue++;
				else numFalse++;
				System.out.println("numTrue "+numTrue+" numFalse "+numFalse);
			}
			//-------------TODO change it back to width-----------
			if (numTrue != 4 || numFalse != 4) boardStack.push(input[i]);
			System.out.println("pushed "+i+" "+Arrays.toString(input[i]));
		}
	}

	/**
	 * Print the board
	 * @param input the boolean array
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
	 * Input the block type rotation and location the block will to the designated place.
	 * @param blockType the block type
	 * @param rotation rotation of the black max 3
	 * @param location the x coordinate the block will drop to
	 * @throws Exception
	 */
	public void dropBlock(int blockType, int rotation, int location) throws Exception {
		//INTEPRETABURTE THE BLOCK PHYSICS
		boolean[][] physics = block.getBlock(blockType, rotation);
		int blockWidth = physics.length;
		int blockHeight = physics[physics.length-1].length;
		int destination = location;
		boolean drop = true;
		boolean collision = false;
		int height = 0;
		//DETERMINE IF THE BLOCK CAN DROP AT THE SPECIFIC LOCATION
		if (location + blockWidth > width-1) destination = width -1 -blockWidth;

		while (drop){
			for (int i = destination; i < (destination + blockWidth); i++)
				if (grid[i][height]) drop = false;
			height++;
		}

		//DETERMINE IF THE BLOCK COULD COLLIDE WITH TERAIN
		int i = 0;
		while (!collision || i >= blockWidth-1) {
			if (physics[i][blockHeight-1])
				if(grid[destination + i][height])
					collision = true;
		}

		if (collision) destination = destination + 1;

		//LAND THE BLOCK INTO THE SURFACE




	}
	public static void main(String [] args) {
		//TESTING THE popBoard method
		boardStack = new Stack();
		grid = new boolean[4][4];
		boolean[] line1 = {true,true,true,true};
		boolean[] line2 = {false,true,false,false};
		boolean[] line3 = {true,false,true,true};
		boolean[] line4 = {false,false,false,false};
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
		System.out.println(Arrays.toString(temp[3]));
		System.out.println(Arrays.toString(temp[2]));
		System.out.println(Arrays.toString(temp[1]));
		System.out.println(Arrays.toString(temp[0]));
		//System.out.println("------popBoard------");
		System.out.println("------pushBoard------");
		pushBoard(temp);
		printBoard();
	}
}
