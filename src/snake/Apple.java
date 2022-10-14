package snake;

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author Aroon Sankoh (aroonjsankoh@gmail.com)
 *
 */
public class Apple {
	
	public double size = 0.0125;
	public double x = 0.5;
	public double y = 0.75;
	
	/**
	 * Constucts an Apple
	 */
	public Apple() {
		StdDraw.setPenColor(255, 0, 0);
		StdDraw.circle(x, y, size);
	}
	
	/**
	 * Redraws the apple every new frame and when it switches locations
	 */
	public void draw() {
		StdDraw.setPenColor(255, 0, 0);
		StdDraw.circle(x, y, size);
	}

}
