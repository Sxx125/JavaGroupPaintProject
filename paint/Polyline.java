package paint;
import java.awt.*;
import java.util.ArrayList;

/*
 * Polyline class is a child of the Shape class. 
 * Creates a new polyline object.
 */
public class Polyline extends Shape{
	//String rep. the type of shape.
	// Declared as final, since it has no change.
	private final String type = "Polyline"; 
	private ArrayList<Point> points;
	int numPoints;
	/*
	 * @param p: the Point of origin for the polyline.
	 * @param c: the color of the polyline
	 * @param lineThickness: the thickness of the polyline.
	 */
	public Polyline(Point p, Color c, int lineThickness){
		super(p, c, lineThickness);
		this.points = new ArrayList<Point>();
		this.points.add(p);
		this.numPoints = 1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ca.utoronto.utm.paint.Shape#getType()
	 */
	public String getType(){
		return this.type;
	}
	
	public void moveMouse(Point p){
		this.changePoint(p);
	}
	
	public void dragMouse(Point p){
		
	}
	
	public void clickMouse(Point p, int button){
		if (button == 1){
			this.addPoint(p);
		}
		else if (button == 3){
			this.removePoint();
		}
	}
	
	public void pressMouse(Point p, int button){
		if (button == 1){
			this.addPoint(p);
		}
		else if (button == 3){
			this.removePoint();
		}
	}
	
	public void releaseMouse(Point p){
		
	}
	
	public int getNumPoints()
	{
		return this.numPoints;
	}
	
	
	public ArrayList<Point> getPoints()
	{
		return this.points;
	}
	
	
	public void addPoint(Point p)
	{
		this.points.add(p);
		this.numPoints = this.numPoints + 1;
	}
	
	
	public void changePoint(Point p)
	{
		this.points.remove(this.points.size()-1);
		this.points.add(p);
	}
	
	
	public void removePoint()
	{
		this.points.remove(this.points.size()-1);
		this.numPoints = this.numPoints - 1;
	}
}
