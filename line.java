
/**
 * Write a description of class ss here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class line
{
	public boolean[] ln;
	public line (int width) {
		boolean[] ln = new boolean[width];
		for (int i = 0; i < width; i++) {
			ln[i] = false;
		}
	}

	public boolean[] getLine() {
		return ln;
	}
}
