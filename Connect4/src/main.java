/**
 * Main
 * 
 * @author Aryan Patel, Samyak Metha
 *
 */
public class main {

    public static int x = 100;
    public static int y = 100;

    public static void main(String[] args) {

        // once the program runs, it creates a starting menu using window builder
        // the main program runs in "Play" class
        Start startFrame = new Start();
        startFrame.makeFrame();
    }

    /**
     * Check if application has moved
     * 
     * @param xx the new x value
     * @param yy the new y value
     */
    public static void setValues(int xx, int yy) {
        x = xx;
        y = yy;
    }
}
