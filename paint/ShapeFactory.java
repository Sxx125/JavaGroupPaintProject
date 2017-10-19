package paint;
import java.awt.*;
/**
 * Creates different shapes.
 * 
 * @author Procrastinators
 *
 */
public class ShapeFactory 
{
	/**
	 * This method checks the type of the shape object to be created and generates
	 * the appropriate respective shape.
	 * 
	 * @param type: String - Shape
	 * @param p: Point Object - starting point
	 * @param width: integer
	 * @param height: integer
	 * @param c: color
	 * @param lineThickness
	 * @return Shape Object
	 */
	public static Shape makeShape(String type, Point p, int width, int height, Color c, int lineThickness)
	{
		Shape shape = null;
		if (type == "Circle")
		{
			shape = new Circle(p,width,c,lineThickness);
		}
		else if (type == "Square")
		{
			shape = new Square(p,width,c,lineThickness);
		}
		else if (type == "Rectangle")
		{
			shape = new Rectangle(p,width,height,c,lineThickness);
		}
		
		else if (type == "Polyline")
		{
			shape = new Polyline(p,c,lineThickness);
		}
		
		else if (type == "Squiggle")
		{
			shape = new Squiggle(p,c,lineThickness);
		}
		return shape;
	}

}
