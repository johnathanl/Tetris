
/**
 * Write a description of class board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Stack;

public class board
{
	public Stack<line> boardStack;
	public boolean[][] grid;
	public int width;

	public board (int w) {

	}

	public void popBoard (int w) {
		boolean[] foundHeight = new boolean[w];
		int rowCleared =  0;
		int count = 0;
		Stack<line> temp = boardStack;

		for (int i = 0; i < w; i++) {
			foundHeight[i] = false;
		}

		while (rowCleared < w){
			if (temp.empty())rowCleared = w;
			count++;
			for (int i = 0; i < w; i++) {
				if (temp.pop().getLine()[i]) {
					foundHeight[i] = true;
					rowCleared++;
				}
			}
		}

		//RENEW THE GRID
		boolean[][] grid = new boolean[w][count+4];
		for (int i = 0; i <= (count+4); i++) {
			for (int j = 0; j < w; j++) {
				grid[i][j] = false;
			}
		}

		//POP STACK INTO GRID
		for (int i = 3; i <= (count+4); i++) {
			grid[i] = boardStack.pop().getLine();
		}
	}

	public void pushStack (int[][] input) {
		Stack boardStack = new Stack();
		//Check if the line is full
		//for (int i = 0; i)
	}
	//public static void main(String [] args) {}
}
