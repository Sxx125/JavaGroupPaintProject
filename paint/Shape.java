package paint;

import java.awt.Color;
import java.util.*;
/**
 * The abstract representation for
 * shape objects.
 * @author Procrastinators
 *
 */
public abstract class Shape 
{
	
	private Point start;
	//Shape modifiers and size
	private Color c;
	private boolean shapeFill;
	private int width,height,lineThickness;
	/**
	 * Constructor for shapes: Square, Circle, Rectangle.
	 * @param p: A point from which the shape will be drawn from.
	 * @param width: Width of the shape.
	 * @param height: Height of the shape.
	 * @param c: Desired Color of the shape.
	 * @param lineThickness: Desired line thickness of shape.
	 */
	public Shape(Point p, int width, int height, Color c, int lineThickness)
	{
		this.start = p;
		this.width = width;
		this.height = height;
		this.c = c;
		this.shapeFill = false;
		this.lineThickness = lineThickness;
	}
	/**
	 * Constructor for shapes: Polyline, Squiggle.
	 * @param p:A point from which the shape will be drawn from.
	 * @param c: Desired Color of the shape.
	 * @param lineThickness: Desired line thickness of shape.
	 */
	public Shape(Point p, Color c, int lineThickness)
	{
		this.start = p;
		this.c = c;
		this.lineThickness = lineThickness;
	}
		
	public abstract String getType();
	
	//Basic getters and setters
	public Point getStart()
	{
		return this.start;
	}
	
	
	public int getWidth()
	{
		return this.width;
	}
	
	
	public int getHeight()
	{
		return this.height;
	}
	
	
	public Color getColor()
	{
		return this.c;
	}
	
	
	public int getThickness()
	{
		return this.lineThickness;
	}
	
	
	public void setPoint(Point p)
	{
		this.start = p;
	}
	
	
	public void setWidth(int end)
	{
		this.width = end;
	}
	
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	
	public void setColor(Color c)
	{
		this.c = c;
	}
	
	
	public void setFill(boolean b)
	{
		this.shapeFill = b;
	}
	
	
	public boolean getFill()
	{
		return this.shapeFill;
	}

	
	public void setThickness(int lineThickness)
	{
		this.lineThickness = lineThickness;
	}
	
	//abstract mouse methods
	public abstract void moveMouse(Point p);
	public abstract void dragMouse(Point p);
	public abstract void clickMouse(Point p, int button);
	public abstract void pressMouse(Point p, int button);
	public abstract void releaseMouse(Point p);
}
