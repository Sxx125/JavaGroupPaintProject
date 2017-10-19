package paint;

/**
 * The Point class represents a point on the canvas. 
 * The class will be used to draw Polyline, Squiggle, Rectangle, Square, and circle
 * such as the connecting points, the radius, and the edges of the various shapes.
 */
public class Point {
	int x, y; // the x and y coordinates.
	
	/**
	 * @param x: the X coordinate
	 * @param y: the Y coordinate
	 */
	Point(int x, int y){
		this.x=x; this.y=y; // Set the coordinates.
	}
	
	/**
	 * Returns the x coordinate
	 * @return: int representation of the x coordinate.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Sets a new x coordinate for the specific point referenced.
	 * @param x: the new x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Returns the y coordinate
	 * @return: int representation of the y coordinate.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets a new y coordinate for the specific point referenced.
	 * @param y: the new y coordinate
	 */	
	public void setY(int y) {
		this.y = y;
	}
	
}
