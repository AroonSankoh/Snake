package snake;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 * @author Aroon Sankoh (aroonjsankoh@gmail.com)
 *
 */
public class SnakeHead {
	
	public int score = 0;
	public int pauseTime = 325;
	private double speed = 0.05;  
	private double size = 0.05; 
	private double x = 0.5;
	private double y = 0.35;
	private double lastx = x;
	private double lasty = y;
	private String direction = "Nothing"; 
	
	
	/**
	 * Constructs a "Snakehead" which represents the head of the snake
	 */
	public SnakeHead() {
		StdDraw.setPenColor(0, 0, 0);
		StdDraw.filledSquare(x, y, size / 2 );
	}
	
	/**
	 * @return x gets current x coord
	 */
	public double GetX() {
		return x;
	}
	
	/**
	 * @return y gets current y coord
	 */
	public double GetY() {
		return y;
	}
	
	/**
	 * @return lastx gets last x coord 
	 */
	public double GetLastX() {
		return lastx;
	}
	
	/**
	 * @return lasty gets last y coord
	 */
	public double GetLastY() {
		return lasty;
	}
	
	/**
	 * @return direction gets direction of head 
	 */
	public String GetDirection() {
		return direction;
	}
	
	/**
	 * Motion of the snakehead; head moves in direction of last key pressed
	 */
 	public void motion() {
		if ( StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) ) { 
			direction = "right";
			}
		if ( StdDraw.isKeyPressed(KeyEvent.VK_LEFT) ) { 
			direction = "left";
			}
		if ( StdDraw.isKeyPressed(KeyEvent.VK_UP) ) { 
			direction = "up";
			}
		if ( StdDraw.isKeyPressed(KeyEvent.VK_DOWN) ) { 
			direction = "down";
			}
		
		//Rightward motion
		if ( direction.equals("right") ) {
			lastx = x;
			lasty = y;
			x = x + speed;
			StdDraw.pause(pauseTime);
			}
		//Leftward motion
		if ( direction.equals("left") ) {
			lastx = x;
			lasty = y;
			x = x - speed;
			StdDraw.pause(pauseTime);
			}
		//Upward motion
		if ( direction.equals("up") ) {
			lastx = x;
			lasty = y;
			y = y + speed;
			StdDraw.pause(pauseTime);
			}
		//Downward motion
		if ( direction.equals("down") ) {
			lastx = x;
			lasty = y;
			y = y - speed;
			StdDraw.pause(pauseTime);
			}
	}
	
	/**
	 * Draws the head every new frame
	 */
 	public void draw() {
		StdDraw.clear();
		StdDraw.setPenColor(0, 0, 0);
		StdDraw.filledSquare(x, y, size / 2 );
		StdDraw.text(0.95, 0.05, score + " ");
	}
	
	/**
	 * Checks if the SnakeHead is touching an apple 
	 * @param applePrime the apple currently on screen
	 * @return whether or not a SnakeHead is touching an apple 
	 */
 	public boolean touchingApple(Apple applePrime) {
		double distance = size + applePrime.size;
		double xDiff = x - applePrime.x;
		double yDiff = y - applePrime.y;
		
		if ( distance > Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2)) ) {
			return true;
		}
		else  {
			return false;
		}
	}
	
 	/**
 	 * Checks if the SnakeHead is touching a wall
 	 * @return whether or not a SnakeHead is touching a wall
 	 */
	public boolean touchingWall() {
		if (x - (size / 2) < 0) {
			return true;
		} 
		else if (x + (size / 2) > 1) {
			return true;
		}
		else if (y - (size / 2) < 0) {
			return true;
		}
		else if (y + (size / 2) > 1) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	
}
