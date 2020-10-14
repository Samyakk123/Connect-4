public class main {
    public static int x=100;
    public static int y=100;
	public static void main(String[] args) {
		// once the program runs, it creates a starting menu using window builder
		// the main program runs in "Play" class
		Start startFrame = new Start();
		startFrame.makeFrame();
	}
	
	public static void setValues(int xx, int yy) {
	  x = xx;
	  y = yy;
	}
	

	
	//
}