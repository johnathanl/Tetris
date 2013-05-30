import java.util.Stack;
import java.io.PrintWriter;


/**
 * Write a description of class game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class game
{
	/**
	 * Width of the Tetris Game
	 */
	public int width = 11;

	/**
	 * Buffer storing an extra tetris
	 */
	public int[] buffer;

	/**
	 * Buffer size
	 */
	public int bufferSize = 1;

	/**
	 * Line to be write
	 */
	public String[] writeList;

	/**
	 * write Counrt
	 */
	public int writeCount = 0;
	public board board = new board(width);
	public readfile readfile = new readfile();
	public int[] toDropList;


	/**
	 * Get the Score of the execution drop
	 * @param type ,type of block to be dropped
	 * @param rotation ,rotation of the block
	 * @param location ,location be dropped
	 * @param bd ,board to be dropped
	 * @return int score
	 */
	public int getScore(int type, int rotation, int location, board bd) {
		Stack<boolean[]> tempStack = (Stack)bd.boardStack.clone();
		int score = 0;
		boolean[][] temp;
		int holeBefore = bd.getHole();

		temp = bd.popBoard(width);
		temp = bd.dropBlock(type, rotation, location, temp);
		int clear = bd.getCleared(temp);
		bd.pushBoard(temp);

		int height = bd.getBoardHeight();
		int flatness = bd.getFlatness();
		int hole = bd.getHole();

		score =  (-1 * (hole + flatness) * (height * 2)) + (clear * 50);
		if (bd.isOnLeft(type, rotation, location) || bd.isOnRight(type, rotation, location))
			score++;
		if ((hole - holeBefore)<=1 && clear > 0)
			score = 201;

		return score;
	}

	public int[] getBestDrop(int type, boolean allowBuffer) {
		int blockOut = type;
		block blockTemp = new block();
		int[] output = new int[3];
		output[0] = type;
		int bestScore = 0;

		for (int i = 0; i < bufferSize && allowBuffer; i++) {
			if (buffer[i] == 0) {
				buffer[i] = type;
				int k[] = {0,0,0};
				return k;
			}
		}

		int l = 0;
		int i = 0;
		boolean firstTry = true;
		while( l <( buffer.length ) || firstTry){
			if (firstTry) {
				blockOut = type;
			}
			else blockOut = buffer[l];
			for (int j = 0; j <= width - blockTemp.getBlock(blockOut,i).length; j++){
				for (i = 0; i < 4; i++) {
					int temp = getScore(blockOut, i, j, board);
					if (temp > bestScore){
						output[0] = blockOut;
						output[1] = i;
						output[2] = j;
						bestScore = temp;
						if (bestScore == 201) {
							if (!firstTry) buffer[l] = 0;
							int k[] = {blockOut,i,j};
							return k;
						}
					}
				}
			}
			if(firstTry)firstTry = false;
			else l++;
		}
		return output;
	}

	public void clearBuffer() {
		for (int i = 0; i < buffer.length; i++) {
			if (buffer[i] != 0) {
				toPrint(getBestDrop(buffer[i], false));
			}
		}
	}
	public void intBuffer() {
		for (int i = 0; i < bufferSize; i++)
			buffer[i] = 0;
	}

	public void toPrint(int[] input) {
		if (input[0] != 0){
			board.popBoard(width);
			board.grid = board.dropBlock(input[0], input[1], input[2], board.grid);
			board.pushBoard(board.grid);
			writeList[writeCount] = input[0] + " " + input[1] + " " + input[2];
			writeCount++;
		}
	}

	public void main(String args)throws Exception {
		intBuffer();
		board.popBoard(width);
		toDropList = readfile.getInput(args);
		writeList = new String[toDropList.length];
		for (int i = 0; i < toDropList.length; i++) {
			toPrint(getBestDrop(toDropList[i], true));
		}
		clearBuffer();
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		for (int i = 0; i < writeCount; i++)
		writer.println(writeList[i]);
		writer.close();

	}
}
