package snake;

import java.util.LinkedList;
import edu.princeton.cs.introcs.StdDraw;
/**
 * 
 * @author Aroon Sankoh (aroonjsankoh@gmail.com)
 *
 */
public class SnakeGame {
	
	
	private static final double max = 0.95;
	private static final double min = .1;
	private static LinkedList<SnakeBody> fullBody = new LinkedList<SnakeBody>();
	
		
	public static void main(String[] args) {

		/**
		 * Double buffering, which will allow the snake to be constantly erased and drawn again to simulate movement
		 */
		StdDraw.enableDoubleBuffering();  
		
		/**
		 * Initializes the gameboard, snakehead, and first apple
		 */
		boolean simulation = true;
		SnakeHead Head = new SnakeHead();
		Apple tastyApple = new Apple();
		GameBoard Board = new GameBoard();
		StdDraw.show();
		
		/**
		 * The simulation for the game, only stopped when the user dies
		 */
		while (simulation) {
			
			/**
			 * Motion mechanics for the head and apple 
			 */
			Head.motion();
			Head.draw();
			tastyApple.draw();
			Board.draw();
			StdDraw.show();
			
			/**
			 * Growing mechanics of the snake for the first body part
			 */
			if (Head.score == 0 && Head.touchingApple(tastyApple)) {
				tastyApple.x = Math.random() * ((max - min) + min); 
				tastyApple.y = Math.random() * ((max - min) + min);
				Head.score++;
				SnakeBody Neck = new SnakeBody(Head.GetLastX(), Head.GetLastY());
				fullBody.add(Neck);
			}
			
			/**
			 * Growing mechanics of the snake for every subsequent body part
			 */
			if (Head.score != 0 && Head.touchingApple(tastyApple) ) {
				tastyApple.x = Math.random() * ((max - min) + min); 
				tastyApple.y = Math.random() * ((max - min) + min);
				Head.score++;
				SnakeBody Body = new SnakeBody ( fullBody.get(fullBody.size() - 1).GetLastX(), fullBody.get(fullBody.size() - 1).GetLastY() );
				fullBody.add(Body);
				Head.pauseTime = Head.pauseTime - 2;
			}
				
			
			/**
			 * Motion mechanics for the head and body parts 
			 */
			if (fullBody.size() > 0) {
				fullBody.get(0).motion(Head.GetLastX(), Head.GetLastY());
				fullBody.get(0).draw();
				StdDraw.show();
	
				for (int i = 1; i < fullBody.size(); ++i) {
					fullBody.get(i).motion( fullBody.get(i-1).GetLastX(), fullBody.get(i-1).GetLastY() );
					fullBody.get(i).draw();
					StdDraw.show();
				}
			}
			
			/**
			 * When the snake hits a boundary of the game board 
			 */
			if ( Head.touchingWall() ) {
				simulation = false;
			} 
			
			/**
			 * When the snake hits a body part
			 */
			for (int i = 1; i < fullBody.size(); ++i) {
				if (Head.GetX() == fullBody.get(i).GetX() && Head.GetY() == fullBody.get(i).GetY()) {
					simulation = false;
				}
			}
		}
		
		/**
		 * Gameover screen
		 */
		StdDraw.clear();
		StdDraw.setPenColor(0, 0, 0);
		StdDraw.text(0.5, 0.5, "Game Over");
		StdDraw.text(0.5, 0.45, "Score: " + Head.score);
		StdDraw.show();	
	
	}  
}
