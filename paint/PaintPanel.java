package paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/
/**
 * Creates the Paint Panel
 * 
 * @author Procrastinators
 *
 */
class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private DrawShapeFactory dsf; //The factory which stores all drawing code
	private String mode; // modifies how we interpret input (could be better?)
	//Shape modifiers
	private Color color;
	private int lineThickness;
	private boolean fill;
	private Shape shape; //The shape currently being drawn
	
	/**
	 * Initialize the paint Panel
	 * Connect the model and the view
	 * 
	 * @param model
	 * @param view
	 */
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.lineThickness = 1;
		this.mode="Circle"; // bad code here?
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.white);
        g2d.drawString ("i="+i, 50, 75);
		i=i+1;
		
		// Draw Shapes
		ArrayList<Shape> shapes = this.model.getShapes();
		this.dsf = new DrawShapeFactory(shapes, this.shape);
		this.dsf.paintComponent(g2d);
		
		g2d.dispose();
	}
	
	/**
	 * Set the line thickness of a shape
	 * @param s: String
	 */
	public void setThickness(String s)
	{
		this.lineThickness = Integer.parseInt(s.substring(0, 1));
	}
	
	/**
	 * Set the color of a shape
	 * @param c: color
	 */
	public void setColor(Color c)
	{
		this.color = c;
	}
	
	/**
	 * Set the fill of an object
	 * @param b: boolean
	 */
	public void setFill(boolean b){
		this.fill = b;
	} 
	
	/**
	 * Return a shape's fill parameter
	 * @return boolean
	 */
	public boolean getFill(){
		return this.fill;
	}
	
	/**
	 * Manually set the moves counter
	 * @param newMoves: integer
	 */
	public void setMoves(int newMoves) {
		this.i = newMoves;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode){
		this.mode=mode;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if(this.shape!=null){
			Point newPoint = new Point(e.getX(),e.getY());
			this.shape.moveMouse(newPoint);
			this.model.modifyCurrent(this.shape);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.shape!=null){
			Point next = new Point(e.getX(), e.getY());
			this.shape.dragMouse(next);
			if(this.shape.getType()=="Squiggle"){
				Squiggle line = (Squiggle) this.shape;
				line.addPoint(next);
			}
			else if (this.shape.getType() != "Polyline")
			{
				int width = -(this.shape.getStart().getX() - e.getX());
				this.shape.setWidth(width);
				int height = -(this.shape.getStart().getY() - e.getY());
				this.shape.setHeight(height);

				
			}
			

			this.model.modifyCurrent(this.shape);
		}
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.shape != null){
			Point next = new Point(e.getX(), e.getY());
			this.shape.clickMouse(next, e.getButton());
			if (e.getButton()==3){
				this.model.addShape(this.shape);
				this.shape = null;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		if(this.shape != null){
			this.shape.pressMouse(p, e.getButton());
			if (e.getButton()==3){
				this.model.addShape(this.shape);
				this.shape = null;
			}
		}
		else
		{
			this.shape = ShapeFactory.makeShape(this.mode,p,0,0,this.color,this.lineThickness);
			if (this.shape.getType()=="Polyline")
			{
				((Polyline) this.shape).addPoint(p);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.shape != null){
			if (this.shape.getType() != "Polyline"){
				Point p = new Point(e.getX(), e.getY());
				this.shape.releaseMouse(p);
				this.shape.setFill(this.fill);
				this.model.addShape(this.shape);
				this.shape = null;
			}
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}

