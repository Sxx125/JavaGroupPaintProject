package paint;

import java.awt.*;
/**
 * Circle class is a child of the Shape class.
 */
public class Circle extends Shape { 
	// String rep. the type. Declared as final since this will never change.
	private final String type = "Circle"; 
	
	
	/**
	 * @param centre: the point on the grid that will be the centre of the circle
	 * @param radius: the integer value of the radius
	 * @param c: the color of the circle
	 * @param lineThickness: integer value representing the thickness of the outline.
	 */
	public Circle(Point centre, int radius, Color c, int lineThickness){
		super(centre,radius,radius,c,lineThickness);
		
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
