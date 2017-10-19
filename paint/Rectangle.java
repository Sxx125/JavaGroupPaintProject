package paint;

import ca.utoronto.utm.paint.Point;
import java.awt.*;

/**
 * Rectangle class is a child of the Shape class. Creates a new rectangle object.
 */
public class Rectangle extends Shape {
	private final String type = "Rectangle"; 
	
	/**
	 * @param p: the point on the grid that will be the edge of the rectangle
	 * @param h: the integer value of the height
	 * @param w: the integer value of the width.
	 * @param c: the color of the circle
	 * @param lineThickness: integer value representing the thickness of the outline.
	 */
	public Rectangle(Point p,int h,int w,Color c,int lineThickness) {
		super(p,w,h,c,lineThickness); // Super is Shape
	}
	
	/*
	 * (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#getType()
	 */
	public String getType()
	{
		return this.type;
	}
	
	public void moveMouse(Point p)
	{
		
	}
	/**
	 * Re-adjusts the width and height of the shape
	 * when the mouse is dragged.
	 * @param p: the point 
	 */
	public void dragMouse(Point p)
	{
		int width = -(this.getStart().getX() - p.getX());
		this.setWidth(width);
		int height = -(this.getStart().getY() - p.getY());
		this.setHeight(height);
	}
	
	public void clickMouse(Point p, int button)
	{
		
	}
	
	public void pressMouse(Point p, int button)
	{
		
	}
	/**
	 * Re-adjusts the width and height of the shape.
	 * @param p: the point 
	 */
	public void releaseMouse(Point p)
	{
		int width = -(this.getStart().getX() - p.getX());
		this.setWidth(width);
		int height = -(this.getStart().getY() - p.getY());
		this.setHeight(height);
	}
}
