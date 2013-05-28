
/**
 * Write a description of class testBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testBlock
{
    static block test = new block();
    public static void main(String [] args) throws Exception {
        //boolean[][] temp = test.getBlock(1,0);

        //System.out.println(test.getBlock(1,0)[0].length);
        for( int i = 0; i < test.getBlock(1,0)[0].length; i++) {
            if(test.getBlock(1,0)[0][i] == true)
            System.out.println("x");
            else
            System.out.println("0");
        }
    }
}
