
/**
 * Write a description of class board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Stack;
import java.util.Arrays;

public class board
{
	public static Stack<boolean[]> boardStack;
	public static boolean[][] grid;
	public int width;
	public block block = new block();

	public board (int w) {

	}

	public static void popBoard (int w) {
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
		boolean[][] grid = new boolean[w][count+4];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < (count+4); j++) {
				grid[i][j] = false;
			}
		}
		//POP STACK INTO GRID
		while (!boardStack.empty()) {
			int i = 0;
			grid[i+3] = boardStack.pop();
			System.out.println(Arrays.toString(grid[i+3]));
		}
	}

	public void pushStack (int[][] input) {
		//Stack boardStack<line> = new Stack();
		//Check if the line is full
		//for (int i = 0; i)
	}

	public void dropBlock(int blockType, int rotation, int location) throws Exception {
		//INTEPRETABURTE THE BLOCK PHYSICS
		//boolean[][] physics = block.getBlock(blockType, rotation);
		//while (){

		//}
	}
	public static void main(String [] args) {
		//TESTING THE popBoard method
		boardStack = new Stack();
		grid = new boolean[3][4];
		boolean[] line1 = {false,true,true,true};
		boolean[] line2 = {false,true,false,false};
		boolean[] line3 = {true,false,true,true};
		boardStack.push(line1);
		boardStack.push(line2);
		boardStack.push(line3);
		System.out.println("------Imginary Board-----");
		System.out.println(Arrays.toString(line3));
		System.out.println(Arrays.toString(line2));
		System.out.println(Arrays.toString(line1));
		System.out.println("------2D Array------");
		grid[0] = line1;
		grid[1] = line2;
		grid[2] = line3;
		System.out.println(Arrays.toString(grid[2]));
		System.out.println(Arrays.toString(grid[1]));
		System.out.println(Arrays.toString(grid[0]));
		System.out.println("------popBoard------");
		popBoard(4);
	}
}
