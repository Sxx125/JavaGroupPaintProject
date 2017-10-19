package paint;
import java.awt.*;
import java.util.ArrayList;

/**
 * Squiggle object, child of Shape.
 * Creates a new squiggle.
 */
public class Squiggle extends Shape{
	//String rep. Type. Declared as final.
	private final String type = "Squiggle";
	private ArrayList<Point> points;
	int numPoints;
	

	/**
	 * @param p: the point of origin for the squiggle
	 * @param c: the color of the squiggle
	 * @param lineThickness: the thickness of the squiggle line.
	 */
	public Squiggle(Point p, Color c, int lineThickness){
		super(p, c, lineThickness);//Send to super.
		this.points = new ArrayList<Point>();
		this.points.add(p);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#getType()
	 */
	public String getType()
	{
		return this.type;
	}
	

	public void moveMouse(Point p){
		
	}
	
	public void dragMouse(Point p){
		this.addPoint(p);
	}
	
	public void clickMouse(Point p, int button){
		
	}
	
	public void pressMouse(Point p, int button){
		
	}
	
	public void releaseMouse(Point p){}
	
	public void addPoint(Point p)
	{
		this.points.add(p);
		this.numPoints = this.numPoints + 1;

	}
	
	public int getNumPoints()
	{
		return this.numPoints;
	}
	
	
	public ArrayList<Point> getPoints()
	{
		return this.points;
	}
}
