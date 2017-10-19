package paint;

import ca.utoronto.utm.paint.Point;
import java.awt.*;

/**
 * Square is a child of Shape. 
 * Creates a new square object.
 */
public class Square extends Shape 
{
	// String rep. the type of shape.
	// Declared as final.
	private final String type = "Square";
	
	/**
	 * @param p: the point rep. the edge the square is drawn from.
	 * @param width: the width (and the height) of the square.
	 * @param c: the color of the square.
	 * @param lineThickness: thickness of outline line.
	 */
	public Square(Point p, int width, Color c, int lineThickness)
	{
		super(p,width,width,c,lineThickness); // Send to Shape class.
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
	 * Re-adjusts the width and height of the shape.
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