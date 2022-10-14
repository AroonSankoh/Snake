package snake;

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author Aroon Sankoh (aroonjsankoh@gmail.com)
 *
 */

public class GameBoard {

	/**
	 * Creates the boundaries for the game board
	 */
	public GameBoard() {
		StdDraw.setPenColor(0, 0, 0);
		StdDraw.rectangle(.5, .5, .48, .48);
	}
	
	/**
	 * Redraws the gameboard every new frame 
	 */
	public void draw() {
		StdDraw.setPenColor(0, 0, 0);
		StdDraw.rectangle(.5, .5, .48, .48);
	}
}
