package snake;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class SnakeBody {
  
	private double size = 0.05; 
	private double x;
	private double y;
	private double lastx;
	private double lasty;
	
	
	/**
	 * Constructs a "SnakeBody" which represents a body part of the snake 
	 * @param xInput
	 * @param yInput
	 */
	public SnakeBody (double xInput, double yInput) {
		this.x = xInput;
		this.y = yInput;
		StdDraw.setPenColor(0, 0, 255);	
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
	 * Motion of the snakebody; body takes the last position of the head/body part before it 
	 * @param xInput
	 * @param yInput
	 */
	public void motion(double xInput, double yInput) {
		lastx = x;
		lasty = y;
		x = xInput;
		y = yInput;
	}
	
	/**
	 * Draws the body part every new frame
	 */
	public void draw() {
		StdDraw.setPenColor(0, 0, 255);
		StdDraw.filledSquare(x, y, size / 2 );
	}
}
