package paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	//Lists containing points, shapes currently on canvas, and shapes stored by undo method
	private ArrayList<Point> points=new ArrayList<Point>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Shape> undo = new ArrayList<Shape>();
	
	private Shape current; //The shape that the user is currently drawing.
	
	/**
	 * Add a point to the points arrayList
	 * @param p: Point 
	 * @return null
	 */
	public void addPoint(Point p){
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Get a list of point Objects
	 * @return points: array of Point objects
	 */
	public ArrayList<Point> getPoints(){
		return points;
	}
	
	/**
	 * Add a shape to the list of shape objects to be painted
	 * @param s: shape object
	 */
	public void addShape(Shape s){
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Get a list of shape Objects.
	 * @return shapes: array of Shape objects
	 */
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	public void modifyCurrent(Shape s){
		this.current = s;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Completely clears the paint panel and resets the counters to 0
	 */
	public void newDrawing() {
		this.points = new ArrayList<Point>();
		this.shapes = new ArrayList<Shape>();
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Undoes the most recently drawn object and stores it in
	 * an array in case user wishes to re-do the action
	 */
	public void undo() {
		if (this.shapes.size() > 0) {
			this.undo.add(this.shapes.get(shapes.size()-1));
			this.shapes.remove(this.shapes.get(shapes.size()-1));
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	/**
	 * Grabs the most recent drawn object undone by the user and re-draws it
	 * back onto the panel.
	 */
	public void redo() {
		if (this.undo.size() > 0) {
			this.shapes.add(this.undo.get(this.undo.size()-1));
			this.undo.remove(this.undo.get(this.undo.size()-1));
			this.setChanged();
			this.notifyObservers();
		}
	}
}